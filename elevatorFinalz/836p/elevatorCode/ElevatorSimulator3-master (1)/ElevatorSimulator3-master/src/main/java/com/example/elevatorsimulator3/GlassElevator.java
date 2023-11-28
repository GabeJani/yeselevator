package com.example.elevatorsimulator3;

// Class representing a GlassElevator, a specific type of elevator that extends the generic Elevator class.


public class GlassElevator extends Elevator{
    // Private attribute to store the weight capacity of the glass elevator.
    private int weightCapacity;

    // Constructor to initialize a GlassElevator with an elevator ID, type, and weight capacity.


    public GlassElevator(int elevatorID, String elevatorType, int weightCapacity) {
        super(elevatorID, elevatorType);
        this.weightCapacity = weightCapacity;
    }

    // Getter method to retrieve the weight capacity of the glass elevator.


    public int getWeightCapacity() {
        return weightCapacity;
    }

    // Setter method to update the weight capacity of the glass elevator.

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }
    @Override
    public boolean move(direction _direction) {

        // Movement of the GlassElevator

        // Check the specified direction and update the current floor accordingly.

        if (_direction == direction.UP) {
            //moving the elevator up
            int currentFloor = getCurrentFloor();
            setCurrentFloor(currentFloor + 1);
            System.out.println("GlassElevator moving up to floor: " + getCurrentFloor());
            //Checks floors, pick up/drop passengers, etc.
        } else if (_direction == direction.DOWN) {
            //moving the elevator down
            int currentFloor = getCurrentFloor();
            setCurrentFloor(currentFloor - 1);
            System.out.println("GlassElevator moving down to floor: " + getCurrentFloor());
            //Checks floors, pick up/drop passengers, etc.
        } else {
            System.out.println("Incorrect Input");
            return false;
        }
        return true;
    }
}
