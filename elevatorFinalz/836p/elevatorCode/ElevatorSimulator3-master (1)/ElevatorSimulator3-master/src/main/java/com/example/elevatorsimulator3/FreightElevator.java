package com.example.elevatorsimulator3;

// Class representing a FreightElevator, a specific type of elevator that extends the generic Elevator class.


public class FreightElevator extends Elevator {
    // Private attribute to store the weight capacity of the freight elevator.
    private int weightCapacity;

    // Constructor to initialize a FreightElevator with an elevator ID, type, and weight capacity.
    public FreightElevator(int elevatorID, String elevatorType, int weightCapacity) {
        super(elevatorID, elevatorType);
        this.weightCapacity = weightCapacity;
    }
    // Getter method to retrieve the weight capacity of the freight elevator.

    public int getWeightCapacity() {
        return weightCapacity;
    }

    // Setter method to update the weight capacity of the freight elevator.

    public void setWeightCapacity(int weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    // Overridden method to define the movement behavior of the FreightElevator.
    @Override
    public boolean move(direction _direction) {
        //movement of the FreightElevator
        if (_direction == direction.UP) {
            //moving the elevator up
            int currentFloor = getCurrentFloor();
            setCurrentFloor(currentFloor + 1);
            System.out.println("FreightElevator moving up to floor: " + getCurrentFloor());
            //Checks floors, pick up/drop freight passengers, etc.
        } else if (_direction == direction.DOWN) {
            //moving the elevator down
            int currentFloor = getCurrentFloor();
            setCurrentFloor(currentFloor - 1);
            System.out.println("FreightElevator moving down to floor: " + getCurrentFloor());
            //Checks floors, pick up/drop freight passengers, etc.
        } else if (_direction == direction.IDLE) {
            //idle state, waiting for new freight requests
            System.out.println("FreightElevator is idle");
            //handles the idle state
        } else {
            System.out.println("Incorrect Input");
            return false;
        }
        return true;
    }
}

