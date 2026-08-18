package models;

import enums.VehicleType;

class Truck extends Vehicle{
    public Truck(String registrationNumber){super(registrationNumber, VehicleType.TRUCK);}
}
