package com.group.hackathon.hackathon;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Button cameraButton, notesButton, mapsButton, alarmButton, weatherButton, campfireButton, exitButton;
    @FXML
    protected void onHelloButtonClick(ActionEvent input) {
        welcomeText.setText("Welcome to our Western Voice Assistant !! ");
    }
}