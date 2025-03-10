package de.bkbocholt.model.guihandler;

import de.bkbocholt.model.Ticket;
import de.bkbocholt.model.coresys.core;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import static de.bkbocholt.model.coresys.core.getDirectory;

public class mainpage extends Application {

    @Override
    public void start(Stage primaryStage) {

    }

    @FXML
    private TextArea inputTitle;

    @FXML
    private TextArea inputText;

    @FXML
    private void openSettings() {
    }
    public void save() {
        String title = inputTitle.getText();
        Ticket ticket = new Ticket(1, title, inputText.getText(), core.userEmailAddress, core.userEmailAddress, 1, 1, null, null, null, null);
        ticket.saveTicket(getDirectory("Ticket"), ticket, title);
    }

    public void delete() {
        String title = inputTitle.getText();
        Ticket ticket = new Ticket(1, title, inputText.getText(), core.userEmailAddress, core.userEmailAddress, 1, 1, null, null, null, null);
        ticket.deleteTicket(getDirectory("Ticket"), title);
    }


}