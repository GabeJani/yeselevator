package com.example.elevatorsimulator3;

import java.util.ArrayList;

// Class representing a floor in the elevator simulation
public class Floor {

    // lists to store passengers in the wait queue, completed queue, and current elevators on the floor.
    ArrayList<Passenger> waitQueue = new ArrayList<>();
    ArrayList<Passenger> completedQueue = new ArrayList<>();
    ArrayList<Elevator> currentElevators = new ArrayList<>();

    // Method to add a passenger to the wait queue.

    public void addToWaitQueue(Passenger passenger) {
        waitQueue.add(passenger);
    }
    // Method to remove a passenger from the wait queue.
    // the rests are the same.

    public void removeFromWaitQueue(Passenger passenger) {
        waitQueue.remove(passenger);
    }

    public void addToCompletedQueue(Passenger passenger) {
        completedQueue.add(passenger);
    }

    public void removeFromCompletedQueue(Passenger passenger) {
        completedQueue.remove(passenger);
    }

    public void addElevator(Elevator elevator) {
        currentElevators.add(elevator);
    }

    public void removeElevator(Elevator elevator) {
        currentElevators.remove(elevator);
    }

    // getter methods to retrieve the wait queue, completed queue, and curent elevators.
    public ArrayList<Passenger> getWaitQueue() {
        return waitQueue;
    }

    public ArrayList<Passenger> getCompletedQueue() {
        return completedQueue;
    }

    public ArrayList<Elevator> getCurrentElevators() {
        return currentElevators;
    }

}
