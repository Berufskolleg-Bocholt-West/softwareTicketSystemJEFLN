package de.bkbocholt.model.guihandler;

import de.bkbocholt.model.Ticket;
import de.bkbocholt.model.coresys.core;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import static de.bkbocholt.model.coresys.core.getDirectory;

public class mainpage extends Application {

    @Override
    public void start(Stage primaryStage) {
    }

    @FXML
    private void initialize() {
        initializeTicket();
    }


    @FXML
    private TableView<Ticket> ticketTable;

    @FXML
    private TextArea inputTitle;

    @FXML
    private TextArea inputText;

    @FXML
    private TableColumn<Ticket, Integer> idColumn;

    public void save() {
        String title = inputTitle.getText();
        Ticket ticket = new Ticket(1, title, inputText.getText(), core.userEmailAddress, core.userEmailAddress, 1, 1, null, null, null, null);
        ticket.saveTicket(getDirectory("Ticket"), ticket, title);
    }

    private void initializeTicket() {
        ObservableList<Ticket> tickets = FXCollections.observableArrayList(
               new Ticket(1, "Test", "Test", "Test", "Test", 1, 1, null, null, null, null)
        );
        int test = 1;
        ticketTable.setItems(tickets);
    }
}