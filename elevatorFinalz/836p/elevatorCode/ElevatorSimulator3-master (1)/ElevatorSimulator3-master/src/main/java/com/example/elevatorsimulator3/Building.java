package com.example.elevatorsimulator3;

import java.lang.reflect.Array;
import java.util.ArrayList;

// this class represents a building in the elevator simulation

public class Building {

    // ArrayLists to store information about floors, elevators, and simulation settings.

    ArrayList<Floor> Floors = new ArrayList<>();
    private ArrayList<Elevator> elevators = new ArrayList<>();
    private SimulationSettings _simulationSettings;

    // Constructor to initialize the Building object with simulation settings and initialize floors and elevators.

    public Building(SimulationSettings settings) {
        this._simulationSettings = settings;
        initializeFloors();
        initializeElevators();
    }

    // Method to initialize floors based on the number of floors specified in simulation settings.

    private void initializeFloors() {
        for (int i = 0; i < _simulationSettings.floors; i++) {
            Floors.add(new Floor());
        }
    }
    // Method to initialize elevators based on the number of elevators specified in simulation settings.

    private void initializeElevators() {
        for (int i = 0; i < _simulationSettings.number_of_elevators && i < _simulationSettings.add_passenger.size(); i++) {
            String passengerType = _simulationSettings.add_passenger.get(i).passengerType;
            elevators.add(createElevator(passengerType));
        }
    }
    // Method to create an elevator based on the specified type.

    private Elevator createElevator(String elevatorType) {
        // Create the respective elevator based on the type
        switch (elevatorType) {
            case "Standard":
                return new StandardElevator(1, "Standard");
            case "VIP":
                return new ExpressElevator(2, "Express"); // Change to VIP Elevator class if available
            case "Freight":
                return new FreightElevator(3, "Freight", 200);
            case "Glass":
                return new GlassElevator(4, "Glass", 200);
            default:
                // Default to Standard Elevator
                return new StandardElevator(1, "Standard");
        }
    }
    // Method to assign an elevator to a passenger based on the passenger's start floor and direction.
    public Elevator assignElevator(Passenger passenger, direction passengerDirection) {
        Elevator assignedElevator = null;
        int minLoad = Integer.MAX_VALUE; // Initialize with a high value

        int passengerStartFloor = passenger.startFloor; // Assuming startFloor is a public field

        for (Elevator elevator : elevators) {
            //if the elevator can accommodate the passenger's direction and is at the same floor
            if (elevator.getCurrentFloor() == passengerStartFloor && elevator.move(passengerDirection)) {
                if (elevator.getCurrentLoad() < minLoad) {
                    assignedElevator = elevator;
                    minLoad = elevator.getCurrentLoad();
                }
            }
        }

        return assignedElevator;
    }

    // Getter methods to retrieve the list of elevators and floors.

    public ArrayList<Elevator> getElevators() {
        return elevators;
    }
    public ArrayList<Floor> getFloors() {
        return Floors;
    }
}
