package com.example.elevatorsimulator3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea outputTextArea; // Add this variable for TextArea

    // Create an instance of ElevatorSimulation in the controller
    private ElevatorSimulation elevatorSimulation;

    @FXML
    protected void onHelloButtonClick() {
        elevatorSimulation = new ElevatorSimulation(outputTextArea);
        elevatorSimulation.initSimulation();
    }
}
