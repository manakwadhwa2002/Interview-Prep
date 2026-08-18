package models;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParkingFloor {
    private final String name;
    private final List<ParkingSpot> parkingSpots = new CopyOnWriteArrayList<>();

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) { parkingSpots.add(spot); }
    public List<ParkingSpot> getParkingSpots() { return parkingSpots; }
    public String getName() { return name; }
}
