package models;

import enums.VehicleType;

class Car extends Vehicle{
    public Car(String registrationNumber){super(registrationNumber, VehicleType.CAR);}
}
