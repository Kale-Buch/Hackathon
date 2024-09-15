package com.group.hackathon.hackathon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

public class HelloApplication extends Application {

    private Label resultLabel;
    private TextField commandInput;

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(20);
        root.setPadding(new javafx.geometry.Insets(20));

        resultLabel = new Label("Welcome!");

        commandInput = new TextField();
        commandInput.setPromptText("Enter command");

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> processCommand(commandInput.getText()));

        Button greetingButton = new Button("Greeting");
        greetingButton.setOnAction(e -> handleGreeting());

        Button openCameraButton = new Button("Open Camera");
        openCameraButton.setOnAction(e -> handleOpen("camera"));

        Button openNotesButton = new Button("Open Notes");
        openNotesButton.setOnAction(e -> handleOpen("notes"));

        Button openMapsButton = new Button("Open Maps");
        openMapsButton.setOnAction(e -> handleOpen("maps"));

        Button setAlarmButton = new Button("Set Alarm");
        setAlarmButton.setOnAction(e -> handleOpen("alarm"));

        Button getWeatherButton = new Button("Get Weather");
        getWeatherButton.setOnAction(e -> handleOpen("weather"));

        Button openCampfireButton = new Button("Open Campfire");
        openCampfireButton.setOnAction(e -> handleOpen("campfire"));

        Button farewellButton = new Button("Farewell");
        farewellButton.setOnAction(e -> handleFarewell());

        root.getChildren().addAll(resultLabel, commandInput, submitButton, greetingButton, openCameraButton, openNotesButton, openMapsButton, setAlarmButton, getWeatherButton, openCampfireButton, farewellButton);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Command Application");
        stage.setScene(scene);
        stage.show();
    }

    private void processCommand(String command) {
        if (isGreeting(command)) {
            playAudio("greeting");
            resultLabel.setText("Greeting received!");
        } else if (doesOpen(command, "camera")) {
            playAudio("camera");
        } else if (doesOpen(command, "notes")) {
            playAudio("notes");
            openNotes();
        } else if (doesOpen(command, "maps")) {
            playAudio("maps");
            getDirections();
        } else if (doesOpen(command, "alarm")) {
            playAudio("alarm");
            setAlarm();
        } else if (doesOpen(command, "weather")) {
            playAudio("weather");
            getWeather();
        } else if (doesOpen(command, "campfire")) {
            playAudio("campfire");
        } else if (isFarewell(command)) {
            playAudio("farewell");
            Platform.exit();
        } else {
            playAudio("unknown");
            resultLabel.setText("Unknown command!");
        }
        commandInput.clear();
    }

    private void handleGreeting() {
        playAudio("greeting");
        resultLabel.setText("Greeting received!");
    }

    private void handleOpen(String application) {
        //playAudio(application);
        switch (application) {
            case "notes":
                openNotes();
                break;
            case "maps":
                getDirections();
                break;
            case "alarm":
                setAlarm();
                break;
            case "weather":
                getWeather();
                break;
            case "camera":
                // Handle camera if needed
                break;
            case "firesound":
                playAudio("firesound");
                break;
        }
    }

    private void handleFarewell() {
        playAudio("farewell");
        resultLabel.setText("Farewell!");
        Platform.exit();
    }

    private boolean isGreeting(String command) {
        return Pattern.compile(Pattern.quote("howdy"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hello"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hi"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hey"), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }

    private boolean isFarewell(String command) {
        return Pattern.compile(Pattern.quote("goodbye"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("farewell"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("bye"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("exit"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("stop"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("later"), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }

    private boolean doesOpen(String command, String toOpen) {
        return Pattern.compile(Pattern.quote("open"), Pattern.CASE_INSENSITIVE).matcher(command).find() &&
                Pattern.compile(Pattern.quote(toOpen), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }

    private void playAudio(String type) {
        try {
            System.out.println(type);
            String filePath = "src/main/resources/" + type + ".wav";
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            TimeUnit.SECONDS.sleep((clip.getMicrosecondLength() / 1000000));
        } catch (Exception exception) {
            System.out.println("Error: Could not play audio");
        }
    }

    private void openNotes() {
        System.out.println("Opening Notes...");
        try {
            Runtime.getRuntime().exec("notepad.exe");
        } catch (Exception exception) {
            System.out.println("Failed to launch notes");
        }
    }

    private void getDirections() {
        System.out.println("Getting Directions...");
        try {
            URI uri = new URI("https://www.google.com/maps");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            System.out.println("Browser Open Failed.");
        }
    }

    private void setAlarm() {
        System.out.println("Setting Alarm...");
        // Implementation for setting an alarm
    }

    private void getWeather() {
        System.out.println("Getting Weather...");
        try {
            URI uri = new URI("https://weather.com");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            System.out.println("Browser Open Failed.");
        }
    }
}
