package de.bkbocholt.model.guihandler;

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

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

import static de.bkbocholt.model.User.getUserSystemPath;
import static de.bkbocholt.model.coresys.core.hashPassword;


public class Login {
    private static final String ALGORITHM = "AES";

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private void handleLogin() throws Exception {
        try {
        String userEmail = email.getText();
        String documentsPath = getUserSystemPath().toString();
        Path directoryPath = Paths.get(documentsPath, "TicketProgramm/User");
        String userPass = core.getJsonString(directoryPath, userEmail + ".json", "password");
        String hashedPass = hashPassword(password.getText());
        if (password == null) {
            System.out.println("Password field is empty.");
        }
        if (checkPassword(userPass, hashedPass)) {
            core.userID = core.getJsonInt(directoryPath, userEmail + ".json", "userID");
            core.userEmailAddress = userEmail;
            FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/mainpage.fxml"));
            Parent root = loader.load();

            // Erhalte die aktuelle Stage (Fenster)
            Stage stage = (Stage) ((Node) btnLogin).getScene().getWindow();
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



    private static Boolean checkPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        if(password.equals(hashedPassword)) {
            return true;
        }
        else
            return false;

    }

    @FXML
    private void registerOnClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/registrationPage.fxml"));
        Parent root = loader.load();

        // Erhalte die aktuelle Stage (Fenster)
        Stage stage = (Stage) ((Node) btnRegister).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}
