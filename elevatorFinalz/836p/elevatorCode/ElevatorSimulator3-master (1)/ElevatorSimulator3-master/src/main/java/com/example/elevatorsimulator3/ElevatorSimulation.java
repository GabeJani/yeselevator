package com.example.elevatorsimulator3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.control.TextArea;

public class ElevatorSimulation {
    private SimulationSettings _simulationSettings;
    private Building building;
    private TextArea outputTextArea; // Add TextArea variable

    // Constructor that takes TextArea as a parameter
    public ElevatorSimulation(TextArea outputTextArea) {
        this.outputTextArea = outputTextArea;
    }

    public boolean initSimulation() {
        String fileName = "ElevatorSimulatorInfo.txt";
        _simulationSettings = readSettingsContent();
        building = new Building(_simulationSettings);
        runSimulation(_simulationSettings);
        return true;
    }

    protected SimulationSettings readSettingsContent() {
        String filePath = "D:\\intellIJ CODE FOLDERS\\836p\\elevatorCode\\ElevatorSimulator3-master (1)\\ElevatorSimulator3-master\\src\\main\\resources\\com\\example\\elevatorsimulator3\\ElevatorSimulatorFile\\ElevatorSimulatorInfo";
        File file = new File(filePath);
        System.out.println("Absolute Path: " + file.getAbsolutePath());

        SimulationSettings currentSettings = new SimulationSettings();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line, currentSettings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentSettings;
    }

    private void parseLine(String line, SimulationSettings currentSettings) {
        String[] tokens = line.split("\\s+");

        if (tokens.length > 0) {
            String command = tokens[0];

            switch (command) {
                case "floors":
                    currentSettings.floors = Integer.parseInt(tokens[1]);
                    break;
                case "add_passenger":
                    int floor = Integer.parseInt(tokens[1]);
                    int startFloor = Integer.parseInt(tokens[2]);
                    int endFloor = Integer.parseInt(tokens[3]);
                    String passengerType = tokens[4];
                    int quantity = Integer.parseInt(tokens[5]);
                    currentSettings.addPassenger(floor, startFloor, endFloor, passengerType, quantity);
                    break;
                case "elevator_type":
                    // handle elevator type command
                    break;
                case "request_percentage":
                    // handle request percentage command
                    break;
                case "passenger_request_percentage":
                    // handle passenger request percentage command
                    break;
                case "number_of_elevators":
                    currentSettings.number_of_elevators = Integer.parseInt(tokens[1]);
                    break;
                case "run_simulation":
                    currentSettings.run_simulation = Integer.parseInt(tokens[1]);
                    break;
                default:
                    // handle unrecognized command
                    break;
            }
        }
    }

    private void runSimulation(SimulationSettings simulationSettings) {
        int iterations = simulationSettings.run_simulation;

        for (int i = 0; i < iterations; i++) {
            simulateElevatorMovement();
            simulatePassengerActions();
            updateOutputText("Simulation iteration: " + (i + 1) + "\n");
        }
    }

    private void simulateElevatorMovement() {
        // Move each elevator in the building
        for (Elevator elevator : building.getElevators()) {
            // Determined direction for the current elevator
            direction elevatorDirection = determineElevatorDirection(elevator);

            // Called the move method with the determined direction
            boolean moved = elevator.move(elevatorDirection);

            // Append the simulation output to the TextArea
            appendToTextArea("Simulating elevator movement...");

            // Check if the elevator is idle
            if (elevatorDirection == direction.IDLE && moved) {
                String elevatorType = elevator.elevatorType;
                appendToTextArea(elevatorType + " is idle");
            }
        }
    }

    private void appendToTextArea(String text) {
        // Append the text to the TextArea
        outputTextArea.appendText(text + "\n");
    }


    private void simulatePassengerActions() {
        for (Floor floor : building.getFloors()) {
            // Simulates passenger requests on each floor
            for (Passenger passenger : floor.getWaitQueue()) {
                direction passengerDirection = determinePassengerDirection(passenger);
                boolean success = passenger.requestElevator(passengerDirection, _simulationSettings);

                if (success) {
                    // for when an elevator is requested
                    Elevator requestedElevator = building.assignElevator(passenger, passengerDirection);
                    if (requestedElevator != null) {
                        requestedElevator.addPassenger(passenger);
                        floor.removeFromWaitQueue(passenger);
                        System.out.println("Simulating passenger actions....");
                    }
                }
            }
        }
    }

    private void updateOutputText(String text) {
        outputTextArea.appendText(text);
    }


    private direction determineElevatorDirection(Elevator elevator) {
        // Implementation of determineElevatorDirection method


        return direction.IDLE; // Placeholder return
    }

    private direction determinePassengerDirection(Passenger passenger) {
        // Implementation of determinePassengerDirection method


        return direction.IDLE; // Placeholder return
    }
}
