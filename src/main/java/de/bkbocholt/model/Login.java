package de.bkbocholt.model;

import de.bkbocholt.model.core.core;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.crypto.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.security.MessageDigest;
import java.util.EventObject;

import static de.bkbocholt.model.User.getUserSystemPath;
import static de.bkbocholt.model.core.core.hashPassword;


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
        try {
        String userEmail = email.getText();
        String documentsPath = getUserSystemPath().toString();
        Path directoryPath = Paths.get(documentsPath, "TicketProgramm/User");
        String userPass = core.getJsonString(directoryPath, userEmail + ".json", "password");
        System.out.println(userPass);
        String hashedPass = hashPassword(password.getText());
        System.out.println(hashedPass);
        if (password == null) {
            System.out.println("Password field is empty.");
        }
        if (checkPassword(userPass, hashedPass)) {
            core.userID = core.getJsonInt(directoryPath, userEmail + ".json", "userID");
            core.userEmailAddress = userEmail;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/mainpage.fxml"));
            Parent root = loader.load();

            // Erhalte die aktuelle Stage (Fenster)
            Stage stage = (Stage) ((Node) loginButton).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            System.out.println("Login failed");
        }
    }
    catch (Exception e) {
        System.out.println("BUG: " + e);
    }
}

    // Generiert einen neuen AES-Schlüssel

    public static Boolean checkPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        if(password.equals(hashedPassword)) {
            return true;
        }
        else
            return false;

    }
}
