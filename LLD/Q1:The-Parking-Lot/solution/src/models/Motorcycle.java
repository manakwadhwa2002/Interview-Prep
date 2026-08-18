package models;

import enums.VehicleType;

class Motorcycle extends Vehicle {
    public Motorcycle(String registrationNumber){ super(registrationNumber, VehicleType.BIKE);}
}
