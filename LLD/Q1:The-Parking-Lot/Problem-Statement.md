# Requirements & System Scope

## Functional Scope (In-Scope)

- Multi-Floor Parking: The system should support multiple floors with diverse spot types (Motorcycle, Compact, Large).
- Spot Allocation: Match incoming vehicles automatically to their correct spot type (e.g., Cars in Compact/Large, Trucks only in Large).
- Ticket Management: Generate a unique, timestamped ticket at entry gates and collect it at exit gates.
- Fee Calculation: Pluggable hourly or flat-rate dynamic pricing based on total parked duration.
- Payment Processing: Support cards, cash, or mobile payments with mock verification logic.

## Explicit Boundaries (Out-of-Scope)

- No Real Database Integration: All storage is managed in-memory (singleton orchestrators, local maps) to focus purely on object models.
- No UI Layer: Interacted with via a simple programmatic test harness or terminal controller.
- Simplified Hardware Integrations: Barrier arm gates, ticket printers, and display boards are represented by stateless interface mocks.

# Class Diagrams & Entity Relationships

# Domain Class Diagram & Entity Relationships:

┌──────────────────────────────────────────────────────┐
│ Ticket │
├──────────────────────────────────────────────────────┤
│ - counter: final AtomicInteger │
│ - ticketId: String │
│ - vehicle: Vehicle │
│ - spot: ParkingSpot │
│ - entryTime: long │
│ - exitTime: long │
│ - fee: double │
│ - isPaid: boolean │
└──────────────────────────────────────────────────────┘
│
├──► [has-a] 1 ── references ──► (1) Vehicle
└──► [has-a] 1 ── references ──► (1) ParkingSpot

┌──────────────────────────────────────────────────────┐
│ ParkingLot │
├──────────────────────────────────────────────────────┤
│ - name: String │
│ - floors: List<ParkingFloor> │
│ - activeTickets: ConcurrentHashMap<String, Ticket> │
│ - pricingStrategy: PricingStrategy │
└──────────────────────────────────────────────────────┘
│
└──► [has-a] 1 ── owns ──► (Many) ParkingFloor

┌──────────────────────────────────────────────────────┐
│ ParkingSpot │
├──────────────────────────────────────────────────────┤
│ - id: String │
│ - type: SpotType │
│ - currentVehicle: Vehicle │
│ - isFree: boolean │
└──────────────────────────────────────────────────────┘
│
└──► [has-a] 1 ── holds ──► (0..1) Vehicle

┌──────────────────────────────────────────────────────┐
│ ParkingFloor │
├──────────────────────────────────────────────────────┤
│ - name: String │
│ - spots: List<ParkingSpot> │
└──────────────────────────────────────────────────────┘
│
└──► [has-a] 1 ── owns ──► (Many) ParkingSpot

┌──────────────────────────────────────────────────────┐
│ Payment │
├──────────────────────────────────────────────────────┤
│ - transactionId: String │
│ - amount: double │
└──────────────────────────────────────────────────────┘
│
└──► [is-a] inherited by: CashPayment, CardPayment, UPIPayment

┌──────────────────────────────────────────────────────┐
│ Vehicle │
├──────────────────────────────────────────────────────┤
│ - licensePlate: String │
│ - type: VehicleType │
└──────────────────────────────────────────────────────┘
│
└──► [is-a] inherited by: Motorcycle, Car, Truck

┌──────────────────────────────────────────────────────┐
│ HourlyPricing │
├──────────────────────────────────────────────────────┤
│ - hourlyRate: double │
└──────────────────────────────────────────────────────┘
│
└──► [is-a] implements PricingStrategy

┌──────────────────────────────────────────────────────┐
│ PricingStrategy │
├──────────────────────────────────────────────────────┤
│ │
└──────────────────────────────────────────────────────┘
│
└──► [is-a] inherited by: HourlyPricing

┌──────────────────────────────────────────────────────┐
│ PaymentFactory │
├──────────────────────────────────────────────────────┤
│ │
└──────────────────────────────────────────────────────┘

# Core Execution Workflows

## Vehicle Entry Workflow

1. Vehicle pulls up to Entry Gate and triggers sensor.
2. System queries ParkingLotManager for an available spot matching the vehicle type.
3. If spot is found:
   a. Spot is marked as occupied (atomically).
   b. A unique, concurrent-safe Ticket is created with the entry timestamp.
   c. Ticket is printed and the gate barrier is raised.
4. If no spots are free, the digital display shows “FULL” and barrier remains closed.

## Vehicle Exit & Billing Workflow

1. Vehicle arrives at Exit Gate and scans Ticket.
2. System calculates duration: duration = currentTime - entryTime.
3. The active PricingStrategy calculates total fees.
4. User selects payment method; the PaymentFactory resolves details and issues a checkout transaction.
5. Upon success, the associated ParkingSpot is released, gate barrier raises, and a receipt prints.
