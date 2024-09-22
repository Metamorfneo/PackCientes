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
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

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
        try{
            String result = loginRequest(email , password);
            if ("Login Successful".equalsIgnoreCase(result)) {
                loginMessage.setText("Login Successful");
                loadMainScreen();
            }else {
                loginMessage.setText("Login Failed");
            }
        }catch (Exception e){
            loginMessage.setText("Error" + e.getMessage());
            e.printStackTrace();
        }
    }

    private String loginRequest(String email, String password) throws Exception{
        //Preparamos el HTTP cliente
        HttpClient client = HttpClient.newHttpClient();
        String postData = "email=" + URLEncoder.encode(email , StandardCharsets.UTF_8)
                + "&password=" + URLEncoder.encode(password , StandardCharsets.UTF_8);


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
