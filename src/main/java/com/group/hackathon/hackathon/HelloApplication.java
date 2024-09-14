package com.group.hackathon.hackathon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
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
    public static void main(String[] args) {
        String command;
        do{
            System.out.println("Testing Begun");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            if(isGreeting(command)){
                playAudio(command);
            }
            else if(isFarewell(command)){
                playAudio(command);
            }
            else if(doesOpen(command, "camera")){
                playAudio(command);
            }
            else if(doesOpen(command, "notes")){
                playAudio(command);
            }
            else if(doesOpen(command, "messages")){
                playAudio(command);
            }
            else if(doesOpen(command, "maps")){
                playAudio(command);
            }
            else if(doesOpen(command, "clock")){
                playAudio(command);
            }
        } while(!command.equalsIgnoreCase("stop"));
    }
    private static boolean isGreeting(String command){
        return command.contains("howdy") || command.contains("hello") || command.contains("hey");
    }
    private static boolean isFarewell(String command){
        return command.contains("goodbye") || command.contains("bye") || command.contains("farewell") || command.contains("hi");
    }
    private static boolean doesOpen(String command, String argument){
        return command.contains("open") && command.contains(argument);
    }

    private static void playAudio(String command){
        try{
            if(isGreeting(command)) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/greeting.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else{
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/notes.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (Exception exception){
            System.out.println("Error: Could not play audio");
        }

    }
}