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
            System.out.println("--Testing Begun--");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            if(isGreeting(command)){
                playAudio(command);
            }
            else if(doesOpen(command, "camera")){
                playAudio(command);
            }
            else if(doesOpen(command, "notes")){
                System.out.println("notes");
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
        } while(!isFarewell(command));
        playAudio(command);
    }
    private static boolean isGreeting(String command){
        return Pattern.compile(Pattern.quote("howdy"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hello"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hi"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("hey"), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }
    private static boolean isFarewell(String command){
        return Pattern.compile(Pattern.quote("goodbye"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("farewell"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("bye"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("exit"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("stop"), Pattern.CASE_INSENSITIVE).matcher(command).find() ||
                Pattern.compile(Pattern.quote("later"), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }
    private static boolean doesOpen(String command, String toOpen){
        return Pattern.compile(Pattern.quote("open"), Pattern.CASE_INSENSITIVE).matcher(command).find() &&
                Pattern.compile(Pattern.quote(toOpen), Pattern.CASE_INSENSITIVE).matcher(command).find();
    }

    private static void playAudio(String command){
        try{
            if(isGreeting(command)) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/greeting.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else if(doesOpen(command, "notes")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/notes.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else if(doesOpen(command, "maps")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/maps.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else if(doesOpen(command, "app")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/app.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else if(doesOpen(command, "messages")){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/text.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            else if(isFarewell(command)){
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/farewell.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                TimeUnit.SECONDS.sleep((clip.getMicrosecondLength()/1000000));
                Platform.exit();
            }
        } catch (Exception exception){
            System.out.println("Error: Could not play audio");
        }
    }
}