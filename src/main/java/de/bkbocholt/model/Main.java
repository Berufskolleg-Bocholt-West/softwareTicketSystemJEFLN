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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static de.bkbocholt.model.coresys.core.checkForAllDirectory;


public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // loads the fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/error.fxml"));
        Parent root = loader.load();


        // create a new scene and open it
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ticket App");
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {
        checkForAllDirectory(); // loading all folders in the system
        launch(args);
        //logger.saveFile("post");
    }
}