package com.group.hackathon.hackathon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hack-A-Thon 9/14/2024-9/15/2024
 * <br>
 * <ul>
 *     <li>Jack Terrell</li>
 *     <li>FLynn House</li>
 *     <li>Kale Buchanan</li>
 *     <li>Sagar Basavaraju</li>
 * </ul>
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    String response = "I'm not sure how to help with that, partner.";
    String lowerCommand = command.toLowerCase();

    if (lowerCommand.startsWith("open ")) {
        String app = command.substring(5);
        response = "Alright, partner. Openin' up that " + app + " for ya faster than a quick-draw.";
        openApp(app);
    } else if (lowerCommand.contains("camera")) {
        response = "Time to capture some memories, eh? Let's get that camera rollin' like tumbleweed.";
        openCamera();
    } else if (lowerCommand.contains("notes")) {
        response = "Sure thing, buckaroo. I'll rustle up them notes for ya quicker than a prairie fire with a tailwind.";
        openNotes();
    } else if (lowerCommand.contains("send a text")) {
        response = "Who're we sendin' a telegraph to, partner? Just say the word, and I'll get that message ridin' the wires.";
        startSendingText();
    } else if (lowerCommand.contains("directions")) {
        response = "Where're we headed, trail boss? Let's get you on a stagecoach to where you wanna go, I'll plot us a course.";
        getDirections();
    } else if (lowerCommand.contains("restaurant")) {
        response = "Fella, let's get you to the saloon before sundown. I hear they're servin' up grub that'll put meat on yer bones.";
        findNearbyRestaurants();
    } else if (lowerCommand.contains("alarm")) {
        response = "You got it, partner. I'll have them chickens hollerin' at the right time. You'll be up with the sun, guaranteed.";
        setAlarm(command);
    } else if (lowerCommand.contains("schedule")) {
        response = "Let me check yer trail map for the day, partner. Looks like you've got [list events] on the horizon " + getSchedule();
    } else if (lowerCommand.contains("campfire")) {
        response = "Comin' right up, cowpoke. I'll get that campfire cracklin' so you can rest your weary bones.";
        playCampfireAmbiance();
    } else if (lowerCommand.contains("weather")) {
        response = "Let me take a gander at the sky for ya, partner. " + getWeatherForecast();
    } else if (lowerCommand.contains("schedule")) {
        response = "Let me check yer trail map for the day, partner. Looks like you've got [list events] on the horizon " + getSchedule();
    } else if (lowerCommand.contains("cowboy name")) {
        response = "Well, let me rustle up a proper trail name for ya... How about " + generateCowboyName() + "?";
    }


    // Implement these methods to handle each specific command
    private void openApp(String appName) { /* ... */ }
    private void openCamera() { /* ... */ }
    private void openNotes() { /* ... */ }
    private void startSendingText() { /* ... */ }
    private void getDirections() { /* ... */ }
    private void findNearbyRestaurants() { /* ... */ }
    private void setAlarm(String command) { /* ... */ }
    private void playCampfireAmbiance() { /* ... */ }
    private String getWeatherForecast() { /* ... */ }
    private String getSchedule() { /* ... */ }
    private void playWesternMusic() { /* ... */ }
    private String generateCowboyName() { /* ... */ }


    public static void main(String[] args) {
        String command;
        do{
            System.out.println("Testing Begun");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            scanner.close();
            if(isGreeting(command)){
                System.out.println("HOWDY PARTNER");
            }
            else if(isFarewell(command)){
                System.out.println("SEE YA LATER PARTNER");
            }
            else if(doesOpen(command, "camera")){
                System.out.println("Opening camera...");
            }
            else if(doesOpen(command, "notes")){
                System.out.println("Opening notes...");
            }
            else if(doesOpen(command, "messages")){
                System.out.println("Opening messages...");
            }
            else if(doesOpen(command, "maps")){
                System.out.println("Opening maps...");
            }
            else if(doesOpen(command, "clock")){
                System.out.println("Opening clock...");
            }
        } while(!command.equalsIgnoreCase("stop"));
    }
    private static boolean isGreeting(String command){
        return command.contains("howdy") || command.contains("hello") || command.contains("hey");
    }
    private static boolean isFarewell(String command){
        return command.contains("goodbye") || command.contains("bye") || command.contains("farewell");
    }
    private static boolean doesOpen(String command, String argument){
        return command.contains("open") && command.contains(argument);
    }
}