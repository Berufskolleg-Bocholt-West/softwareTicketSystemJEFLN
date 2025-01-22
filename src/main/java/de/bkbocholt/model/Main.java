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
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Lade die FXML-Datei
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Ticket.fxml"));
        Parent root = loader.load();

        // Szene erstellen und anzeigen
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ticket App");
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException {
        launch(args);
        //ticketTest();
        //Ticket.readTicketData("/home/ewan/ticket.json", "string", "title");
        Ticket.getTicketData("/home/ticket.json");
    }

    public static void ticketTest(){
        // Dummy-Daten erstellen
        ArrayList<String> assignedUsers = new ArrayList<>();
        assignedUsers.add("User1");
        assignedUsers.add("User2");

        ArrayList<String> comments = new ArrayList<>();
        comments.add("test comment");
        comments.add("Second test comment");

        ArrayList<String> attachments = new ArrayList<>();
        attachments.add("File1.pdf");
        attachments.add("Image.png");

        ArrayList<String> history = new ArrayList<>();
        history.add("Ticket created");
        history.add("Priority changed");

        // Ticket erstellen
        Ticket ticket = new Ticket(
                1,
                "Test-Ticket",
                new Date(),
                "Ewan Olbrich",
                "Max Mustermann",
                3, // Priority
                1, // State
                assignedUsers,
                comments,
                attachments,
                history
        );

        // Ticket ausgeben
        System.out.println(ticket);
       ticket.saveTicket("/home/ewan/ticket.json");
        // Methoden testen
/*
        ticket.changePriority(5);
        ticket.changeState(2);
        ticket.changeEditor("Lisa Müller");

        System.out.println("\nNach Änderungen:");
        System.out.println(ticket);

        // Zusammenfassung anzeigen
        System.out.println("\nZusammenfassung:");
        System.out.println(ticket.getSummary());*/
    }
    }
