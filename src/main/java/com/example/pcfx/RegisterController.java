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
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class RegisterController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField confirmPasswordField;

    @FXML
    private Text registerMessage;

    @FXML
    protected void handleRegisterButtonAction(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (!password.equals(confirmPassword)) {
            registerMessage.setText("Las contraseñas no coinciden.");
            return;
        }

        try {
            String resultado = registerRequest(email , password);
            if ("Registro Completado".equals(resultado)) {
                registerMessage.setText("Registro Completado");
                redirectToLogin();
            }else {
                registerMessage.setText("Error al registrar el usuario");
            }
        }catch (Exception e) {
            registerMessage.setText("Error" + e.getMessage());
            e.printStackTrace();
        }
    }

    private String registerRequest(String email, String password) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String postData = "email=" + URLEncoder.encode(email , StandardCharsets.UTF_8) +
                "&password=" + URLEncoder.encode(password , StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/auth/register"))
                .header("Content-Type" , "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(postData))
                .build();

        //mandamos la request
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return "Registro Completado";
        }else {
            return "Error al registrar el usuario";
        }
    }

    @FXML
    protected void handleBackToLoginAction(ActionEvent event) throws IOException {
        redirectToLogin();
    }

    private void redirectToLogin(){
        try {
            Stage stage = (Stage) emailField.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
