package com.example.pcfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage.setTitle("Packcientes -Login");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}