/*
 * Copyright (c) 2024. Ewan Olbrich
 * All rights reserved. This code is provided "as is," without warranty of any kind, express or implied,
 * including but not limited to the warranties of merchantability, fitness for a particular purpose,
 * or non-infringement. You may use, modify, and distribute this code, provided that the above copyright
 * notice and this permission notice appear in all copies or substantial portions of the code.
 *
 * For any inquiries, please contact: ewanolbrich@gmail.com
 *
 */

package de.bkbocholt.model;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

//eigene klassen/methoden
import static de.bkbocholt.model.core.core.*;


public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Lade die FXML-Datei
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/loginpage.fxml"));
        Parent root = loader.load();

        // Szene erstellen und anzeigen
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ticket App");
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        checkForAllDirectory();
        launch(args);
    }
}