package models;

import enums.SpotType;

public class ParkingSpot {
    private final int spotId;
    private final SpotType spotType;
    private Vehicle currentVehicle;
    private boolean isFree = true;

    public ParkingSpot(int id, SpotType spotType){
        this.spotId = id;
        this.spotType = spotType;
    }

    public int getSpotId(){ return this.spotId; }
    public SpotType getSpotType(){ return this.spotType; }
    public synchronized boolean isAvailable(){ return this.isFree; }
    public Vehicle getCurrentVehicle(){ return this.currentVehicle; }

    public synchronized boolean reserve(Vehicle vehicle){
        if(!isFree){
            return false;
        }
        this.currentVehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public synchronized void release(){
        this.currentVehicle = null;
        this.isFree = true;
    }
}
