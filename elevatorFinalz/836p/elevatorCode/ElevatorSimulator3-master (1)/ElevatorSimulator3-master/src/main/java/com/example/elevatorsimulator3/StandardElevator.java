package com.example.elevatorsimulator3;

// Class representing a StandardElevator, a specific type of Elevator.

public class StandardElevator extends Elevator{

    // Constructor to initialize the StandardElevator
    public StandardElevator(int elevatorID, String elevatorType) {
        super(elevatorID, elevatorType);
    }

    // Override the move method to define the movement behavior of the StandardElevator
    @Override
    public boolean move(direction _direction) {

        // Check the requested direction and the current direction of the elevator.

        if (direction.IDLE.equals(_direction)) {
            return true; // Standard elevator can accommodate when it's idle
        } else if (direction.UP.equals(_direction) && direction.UP.equals(this.direction)) {
            return true; // Standard elevator accommodates going up if it's already moving up
        } else if (direction.DOWN.equals(_direction) && direction.DOWN.equals(this.direction)) {
            return true; // Standard elevator can accommodates going down if it's already moving down
        }
        return false; // Standard elevator can't accommodate any other direction and returns false
    }
}
