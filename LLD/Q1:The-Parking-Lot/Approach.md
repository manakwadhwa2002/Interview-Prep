# Design Patterns & SOLID Principles

- Strategy Pattern (Fee Calculation): Injecting a PricingStrategy interface (with concrete implementations like HourlyPricing and FlatRatePricing) into the billing engine allows easy adjustments without rewriting exit-gate ticket verification.
- Singleton Pattern (ParkingLot): Orchestrating state across distinct physical gates requires a single, concurrent source of truth (ParkingLotManager) to prevent overallocation or inconsistent occupancy counts.
- Factory Pattern (Payment Processor): Resolves dynamic payment modes (Cash, Card, UPI) through a factory resolver at checkout, keeping the payment controller decoupling robust.

# Concurrency & Thread Safety Strategy

In highly concurrent scenarios (e.g., dozens of vehicles entering via multiple gates simultaneously competing for the last available spot), simple collections will suffer from race conditions resulting in double-booking.

- Thread-Safe Spot Allocation: Use synchronized blocks on spot reservation methods in Java, or local Mutex locks in Python, wrapping both the availability check and the assignment inside a single atomic operation.

- Atomic ID Generators: Ticket IDs are generated via AtomicInteger / lock-protected class counters to guarantee uniqueness across threads.

- Concurrent Collections: Store active spot allocations in ConcurrentHashMap to prevent runtime crashes during read-heavy display status queries.

## Solve yourself before you jump to the solution.
