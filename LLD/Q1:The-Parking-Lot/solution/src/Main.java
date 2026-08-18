import enums.PaymentType;
import enums.SpotType;
import enums.VehicleType;
import models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Parking Lot !!!");
        ParkingLot parkingLot = ParkingLot.getInstance("Chandigarh Sector-17");
        ParkingFloor f1 = new ParkingFloor("Floor 1");
        f1.addParkingSpot(new ParkingSpot(101, SpotType.MOTORCYCLE));
        f1.addParkingSpot(new ParkingSpot(102, SpotType.COMPACT));
        f1.addParkingSpot(new ParkingSpot(103, SpotType.LARGE));
        parkingLot.addFloor(f1);
        Vehicle car1 = new Vehicle("KA-01-AB-1234", VehicleType.CAR);
        Vehicle moto1 = new Vehicle("KA-01-BA-4321", VehicleType.BIKE);
        Ticket t1 = parkingLot.parkVehicle(car1);
        Ticket t2 = parkingLot.parkVehicle(moto1);
        parkingLot.checkoutVehicle(t1.getTicketId(), PaymentType.CARD);
        parkingLot.checkoutVehicle(t2.getTicketId(), PaymentType.UPI);
    }
}