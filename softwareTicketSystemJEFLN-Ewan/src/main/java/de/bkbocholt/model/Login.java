package de.bkbocholt.model;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javax.crypto.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.MessageDigest;


public class Login {
    private static final String ALGORITHM = "AES";

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginButton;

    @FXML
    private void handleLogin() throws Exception {
        String userEmail = email.getText();
        String userPass = password.getText();
        String hashedPass = hashPassword(userPass);
        
    }


    // Generiert einen neuen AES-Schlüssel
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }


}
