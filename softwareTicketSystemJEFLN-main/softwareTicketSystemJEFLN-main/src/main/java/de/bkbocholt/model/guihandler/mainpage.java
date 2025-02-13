package de.bkbocholt.model.guihandler;

import de.bkbocholt.model.Ticket;
import de.bkbocholt.model.coresys.core;
import javafx.application.Application;
import javafx.fxml.FXML;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;



import javax.swing.*;

import static de.bkbocholt.model.coresys.core.getDirectory;

public class mainpage extends Application {
    @FXML
    public void initialize() {
        loadComboBox();
    }
    @Override
    public void start(Stage primaryStage) {

    }
    @FXML
    public ComboBox<String> ComboBoxpriority;
    @FXML
    public ComboBox<String> AssignedUser;
    @FXML
    public ComboBox<String> Creator;
    @FXML
    public ComboBox<String> Status;
    @FXML
    private TextArea inputTitle;

    @FXML
    private TextArea inputText;
    public void save() {
        String title = inputTitle.getText();
        Ticket ticket = new Ticket(1, title, inputText.getText(), core.userEmailAddress, core.userEmailAddress, 1, 1, null, null, null, null);
        ticket.saveTicket(getDirectory("Ticket"), ticket, title);
    }
    public void loadComboBox(){
        ComboBoxpriority.getItems().add("Priorität");
        ComboBoxpriority.setItems(ComboBoxpriority.getItems());
        AssignedUser.getItems().add("AssignedUser");
        AssignedUser.setItems(AssignedUser.getItems());
        Creator.getItems().add("Creator");
        Creator.setItems(Creator.getItems());
        Status.getItems().add("Status");
        Status.setItems(Status.getItems());
    }

}