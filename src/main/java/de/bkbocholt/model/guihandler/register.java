package de.bkbocholt.model.guihandler;

import de.bkbocholt.model.User;
import de.bkbocholt.model.coresys.core;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import static de.bkbocholt.model.User.getUserSystemPath;
import static de.bkbocholt.model.coresys.core.hashPassword;

public class register {

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField reEnterPassword;

    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogin;
    @FXML
    private void loginOnClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        // Erhalte die aktuelle Stage (Fenster)
        Stage stage = (Stage) ((Node) btnLogin).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void handleRegister(){
        try {
            String userEmail = email.getText();
            String userPass = password.getText();
            String reEnterPass = reEnterPassword.getText();
            if (userPass.equals(reEnterPass)) {
                String documentsPath = getUserSystemPath().toString();
                Path directoryPath = Paths.get(documentsPath, "TicketProgramm/User");
                User.saveUserToJSON(new User(userEmail, userEmail, userEmail,userPass));
            } else {
                System.out.println("Passwords do not match.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
//änder die gui so das man vor nachnamen eingeben muss