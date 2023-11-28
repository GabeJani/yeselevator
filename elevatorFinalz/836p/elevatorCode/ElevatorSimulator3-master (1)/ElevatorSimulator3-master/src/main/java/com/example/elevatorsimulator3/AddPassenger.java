package com.example.elevatorsimulator3;

public class AddPassenger {
    // variables to store information about the passenger request
    public int floor;   // Current floor where the request is made.
    public int startFloor;  // Starting floor for the passenger's journey
    public int endFloor;    // Ending floor for the passenger's journey.
    public String passengerType; // Type of passenger (e.g., adult, child, etc.).
    public int quantity;  // Number of passengers with the specified characteristics.


    // Constructor to initialize the AddPassenger object with provided values.

    public AddPassenger(int floor, int startFloor, int endFloor, String passengerType, int quantity) {
        this.floor = floor;
        this.startFloor = startFloor;
        this.endFloor = endFloor;
        this.passengerType = passengerType;
        this.quantity = quantity;
    }
}
