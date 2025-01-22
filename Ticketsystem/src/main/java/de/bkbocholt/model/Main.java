package de.bkbocholt.model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args){
        try {
            core.checkForConfig();
            User Luis = new User("Luis", "Kessler", "ichstinke@nachkacke.com", "Dicks123");
            System.out.println(Luis.getUserID());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void start( Stage stage ) throws Exception {

    }
}