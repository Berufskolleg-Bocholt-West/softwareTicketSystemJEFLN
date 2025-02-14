package de.bkbocholt.model.guihandler;

import de.bkbocholt.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


import java.io.IOException;

import static de.bkbocholt.model.User.*;

public class register {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField reEnter;

    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogin;


    private int Empty;
    private int match;
    private int flength;
    private int llength;
    private int emailcheck;
    private int paswdlength;

    @FXML
    private void loginOnClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        // Erhalte die aktuelle Stage (Fenster)
        Stage stage = (Stage) ((Node) btnLogin).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void registerOnClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        // Erhalte die aktuelle Stage (Fenster)
        Stage stage = (Stage) ((Node) btnRegister).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void handleRegister() throws IOException {
        String userFirstName = firstName.getText();
        String userLastName = lastName.getText();
        String userEmail = email.getText();
        String userPassword = password.getText();
        String userReEnterPassword = reEnter.getText();

        if (userFirstName.isEmpty() || userLastName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty()) {
            showAlert(AlertType.ERROR, "Validation Error", "All fields must be filled!");
            Empty = 1;
            return;
        } else {
            Empty = 0;
        }

        if (!userPassword.equals(userReEnterPassword)) {
            showAlert(AlertType.ERROR, "Validation Error", "Passwords do not match!");
            match = 1;
            return;
        } else {
            match = 0;
        }

        if (userFirstName.length() <= 2) {
            showAlert(AlertType.INFORMATION, "Firstname is too short", "Firstname is too short. Please enter at least 3 characters");
            flength = 1;
            return;
        } else {
            flength = 0;
        }

        if (userLastName.length() <= 2) {
            showAlert(AlertType.INFORMATION, "Lastname is too short", "Lastname is too short. Please enter at least 3 characters");
            llength = 1;
            return;
        } else {
            llength = 0;
        }

        if (!userEmail.contains("@") || !userEmail.contains(".")) {
            showAlert(AlertType.INFORMATION, "Wrong E-Mail", "This is not a valid email address.");
            emailcheck = 1;
            return;
        } else {
            emailcheck = 0;
        }

        if (userPassword.length() <= 7 || userReEnterPassword.length() <= 7) {
            showAlert(AlertType.INFORMATION, "Password too short", "Password too short. Please enter at least 8 characters");
            paswdlength = 1;
            return;
        } else {
            paswdlength = 0;
        }

        if (Empty == 0 && match == 0 && flength == 0 && llength == 0 && emailcheck == 0 && paswdlength == 0) {
            System.out.println(userFirstName + " " + userLastName + " " + userEmail + " " + userPassword);
            saveUserToJSON(new User(userFirstName, userLastName, userEmail, userPassword));
            showAlert(AlertType.INFORMATION, "Registration Successful", "Registration Successful.");
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

//änder die gui so das man vor nachnamen eingeben musspackage de.bkbocholt.model.guihandler;

import de.bkbocholt.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


import java.io.IOException;

import static de.bkbocholt.model.User.*;

public class register {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private TextField reEnter;

    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLogin;


    private int Empty;
    private int match;
    private int flength;
    private int llength;
    private int emailcheck;
    private int paswdlength;

    @FXML
    private void loginOnClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        // Erhalte die aktuelle Stage (Fenster)
        Stage stage = (Stage) ((Node) btnLogin).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void registerOnClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(Login.class.getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        // Erhalte die aktuelle Stage (Fenster)
        Stage stage = (Stage) ((Node) btnRegister).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void handleRegister() throws IOException {
        String userFirstName = firstName.getText();
        String userLastName = lastName.getText();
        String userEmail = email.getText();
        String userPassword = password.getText();
        String userReEnterPassword = reEnter.getText();

        if (userFirstName.isEmpty() || userLastName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty()) {
            showAlert(AlertType.ERROR, "Validation Error", "All fields must be filled!");
            Empty = 1;
            return;
        } else {
            Empty = 0;
        }

        if (!userPassword.equals(userReEnterPassword)) {
            showAlert(AlertType.ERROR, "Validation Error", "Passwords do not match!");
            match = 1;
            return;
        } else {
            match = 0;
        }

        if (userFirstName.length() <= 2) {
            showAlert(AlertType.INFORMATION, "Firstname is too short", "Firstname is too short. Please enter at least 3 characters");
            flength = 1;
            return;
        } else {
            flength = 0;
        }

        if (userLastName.length() <= 2) {
            showAlert(AlertType.INFORMATION, "Lastname is too short", "Lastname is too short. Please enter at least 3 characters");
            llength = 1;
            return;
        } else {
            llength = 0;
        }

        if (!userEmail.contains("@") || !userEmail.contains(".")) {
            showAlert(AlertType.INFORMATION, "Wrong E-Mail", "This is not a valid email address.");
            emailcheck = 1;
            return;
        } else {
            emailcheck = 0;
        }

        if (userPassword.length() <= 7 || userReEnterPassword.length() <= 7) {
            showAlert(AlertType.INFORMATION, "Password too short", "Password too short. Please enter at least 8 characters");
            paswdlength = 1;
            return;
        } else {
            paswdlength = 0;
        }

        if (Empty == 0 && match == 0 && flength == 0 && llength == 0 && emailcheck == 0 && paswdlength == 0) {
            System.out.println(userFirstName + " " + userLastName + " " + userEmail + " " + userPassword);
            saveUserToJSON(new User(userFirstName, userLastName, userEmail, userPassword));
            showAlert(AlertType.INFORMATION, "Registration Successful", "Registration Successful.");
        }
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

//änder die gui so das man vor nachnamen eingeben muss
