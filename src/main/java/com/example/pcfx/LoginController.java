package com.example.pcfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private Text loginMessage;

    // Accion de pulsar el boton de Login
    @FXML
    protected void handleLoginButtonAction(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        //Validacion a insertar mas tarde corroborando con la base de datos
        if (email.equals("sblazquez2002@gmail.com") && password.equals("123456")) {
            loginMessage.setText("Sesion Iniciada");
            loadMainScreen();
        }else {
            loginMessage.setText("Contraseña o correo Incorrecto");
        }
    }

    protected void handleCreateAccountButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) emailField.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    private void loadMainScreen() {
        //Logina para cargar la pagina principal despues de iniciar sesion
        System.out.println("Cargando Pagina principal");
    }
}
