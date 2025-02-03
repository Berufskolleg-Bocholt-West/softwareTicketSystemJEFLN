package de.bkbocholt.model;

import de.bkbocholt.model.core.core;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static de.bkbocholt.model.core.core.getDirectory;

public class mainpage extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    @FXML
    private TextArea inputTitle;

    @FXML
    private TextArea inputText;
    public void save() {
        String title = inputTitle.getText();
        Ticket ticket = new Ticket(1, title, inputText.getText(), core.userEmailAddress, core.userEmailAddress, 1, 1, null, null, null, null);
        ticket.saveTicket(getDirectory("Ticket"), ticket, title);
    }
}