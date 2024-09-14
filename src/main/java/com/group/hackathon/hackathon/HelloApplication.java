package com.group.hackathon.hackathon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import java.awt.Desktop;
import java.net.URI;

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
    public static void main(String[] args) {
        String command;
        System.out.println("--Testing Begun--");
        do{
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            System.out.println("Trying to: " + command);//debug statement tbh
            if(isGreeting(command)){
                playAudio(command);
                System.out.println("What would you like to do?");
            }
            else if(doesOpen(command, "camera")){
                playAudio(command);
            }
            else if(doesOpen(command, "notes")){
                playAudio(command);
            }
            else if(doesOpen(command, "maps")) {
                playAudio(command);
            }
            else if(doesOpen(command, "alarm")){
                playAudio(command);
            }
            else if(doesOpen(command, "weather")){
                playAudio(command);
            }
            else if(doesOpen(command, "campfire")){
                playAudio(command);
            }
            else if(!isFarewell(command)){
                playAudio(command);
            }
        } while(!isFarewell(command));
        playAudio(command);
    }//end main

    private static boolean isGreeting(String command){
        return Pattern.compile(Pattern.quote("howdy"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hello"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hi"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hey"), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }//isGreeting

    private static boolean isFarewell(String command){
        return Pattern.compile(Pattern.quote("goodbye"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("farewell"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("bye"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("exit"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("stop"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("later"), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }//end isFarewell

    private static boolean doesOpen(String command, String toOpen){
        return Pattern.compile(Pattern.quote("open"), Pattern.CASE_INSENSITIVE).matcher(command).find() &&
                Pattern.compile(Pattern.quote(toOpen), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }//end doesOpen

    private static void playAudio(String command){
        try{
            if(isGreeting(command)) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/greeting.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else if(doesOpen(command, "camera")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/camera.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                openCamera();
            }
            else if(doesOpen(command, "notes")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/notes.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                openNotes();
            }
            else if(doesOpen(command, "maps")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/maps.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                getDirections();
            }
            else if(doesOpen(command, "alarm")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/alarm.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                setAlarm();
            }
            else if(doesOpen(command, "weather")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/whatWeather.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                getWeather();
            }
            else if(doesOpen(command, "campfire")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/campfire.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                playCampfireAmbiance();
            }
            else if(isFarewell(command)){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/farewell.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                Platform.exit();
            }
            else{
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/unknown.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (Exception exception){
            System.out.println("Error: Could not play audio");
        }
    }//end playAudio

    private static void openCamera() {
        System.out.println("openCamera");
        // ...
    } //end openCamera

    private static void openNotes() {
        System.out.println("openNotes");
        // ...
    } //end openNotes

    private static void getDirections() {
        System.out.println("getDirections");
        try {
            // Replace "https://yourweatherapp.com" with the actual URL
            URI uri = new URI("https://www.google.com/maps/@33.5860592,-101.8818651,14z?entry=ttu&g_ep=EgoyMDI0MDkxMS4wIKXMDSoASAFQAw%3D%3D");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //end getDirections
    
    private static void setAlarm() {
        System.out.println("setAlarm");
        // ...
    } //end setAlarm

    private static void getWeather() {
        System.out.println("getWeather");
        try {
            // Replace "https://yourweatherapp.com" with the actual URL
            URI uri = new URI("https://weather.com/weather/today/l/afd1892a384a87776fd470b48c5d153ef137ae9b620af9e1243b6ccf9b4fa301");
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ...
    } //end getWeather

    private static void playCampfireAmbiance() {
        System.out.println("playCampfireAmbiance");
        //play a 10 hour youtube video somehow lmao
        // ...
    } //end playCampfireAmbiance


    /*not used yet/might not use?

    private String generateCowboyName() {
        System.out.println("generateCowboyName");
        // ...
        return null; // Replace with actual implementation
    } //end generateCowboyName

    */

}//end class