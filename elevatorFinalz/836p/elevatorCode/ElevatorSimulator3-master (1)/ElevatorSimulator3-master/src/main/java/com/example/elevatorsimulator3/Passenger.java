package com.example.elevatorsimulator3;
// Abstract class representing a generic Passenger.

public abstract class Passenger {
    // Protected attributes to store passenger information.

    protected int passengerID;
    protected int startFloor;
    protected int endFloor;

    // Abstract method to be implemented by subclasses for requesting an elevator
    public abstract boolean requestElevator(direction _direction, SimulationSettings _settings);

    // Getter method for startFloor
    public int getStartFloor() {
        return startFloor;
    }

    // Getter method for endFloor
    public int getEndFloor() {
        return endFloor;
    }
}

