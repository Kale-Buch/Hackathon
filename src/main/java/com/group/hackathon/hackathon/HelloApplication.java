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