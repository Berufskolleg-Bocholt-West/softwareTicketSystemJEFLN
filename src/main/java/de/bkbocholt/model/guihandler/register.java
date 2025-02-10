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

}
//änder die gui so das man vor nachnamen eingeben muss
