package de.bkbocholt.model;

import de.bkbocholt.model.guihandler.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class errorhandler { // Klassennamen konventionell mit Großbuchstaben

    private String errorMessage = "This is an error message"; // Fehlernachricht als Instanzvariable

    @FXML
    private Label errorLabel; // Kein static!

    @FXML
    private Button btnConfirm;

    // JavaFX-Initialisierungsmethode
    @FXML
    public void initialize() {
        errorLabel.setText("Error: " + errorMessage); // Setzt die Standardfehlermeldung
    }

    // Methode zum Setzen der Fehlermeldung
    public void setErrorMessage(String message) {
        this.errorMessage = message;
        if (errorLabel != null) {
            errorLabel.setText("Error: " + message);
        }
    }

    @FXML
    public void onClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnConfirm.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
