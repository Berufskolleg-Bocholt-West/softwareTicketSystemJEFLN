package de.bkbocholt.model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args){
        try {
            core.checkForConfig();
            User newUser1 = new User("Luis", "Kessler", "ichstinke@nachkacke.com", "Dicks123");
            User newUser2 = new User("Kai", "Maier", "krasse@kai.com", "sAfE123");
            User.saveUserToJSON(newUser1);
            User.saveUserToJSON(newUser2);
        } catch (IOException e) {
            throw new RuntimeException(e);
            //Luis gpt experte
        }
    }
    @Override
    public void start( Stage stage ) throws Exception {

    }
}