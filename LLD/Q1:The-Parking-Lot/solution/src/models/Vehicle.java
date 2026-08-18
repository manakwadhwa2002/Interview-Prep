package models;

import enums.VehicleType;

public class Vehicle {
    private final String registrationNumber;
    private final VehicleType vehicleType;

    public Vehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
