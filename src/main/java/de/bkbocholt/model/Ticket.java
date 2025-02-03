
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

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.fxml.FXML;

import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ticket {
    @FXML
    private void initialize() {
    }

    private int ticketID;
    private String title;
    private String description;
    private String createdBy;
    private String editor;
    private int priority;
    private int state;
    private ArrayList<String> assignedUser;
    private ArrayList<String> comments;
    private ArrayList<String> attachments;
    private ArrayList<String> history;

    public Ticket() {

    }


    public Ticket(int ticketID, String title, String description, String createdBy, String editor, int priority, int state, ArrayList<String> assignedUser, ArrayList<String> comments, ArrayList<String> attachments, ArrayList<String> history) {
        this.ticketID = ticketID;
        this.title = title;
        this.description = description;
        this.createdBy = createdBy;
        this.editor = editor;
        this.priority = priority;
        this.state = state;
        this.assignedUser = assignedUser;
        this.comments = comments;
        this.attachments = attachments;
        this.history = history;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", title='" + title + '\'' +
                ", description=" + description +
                ", createdBy=" + createdBy +
                ", editor=" + editor +
                ", priority=" + priority +
                ", state=" + state +
                ", assignedUser=" + assignedUser +
                ", comments=" + comments +
                ", attachments=" + attachments +
                ", history=" + history +
                '}';
    }
    /*
     Gibt eine kleine zusammenfassung des Tickets zurueck
      Ist von Chatgpt UwU
     */
    public String getSummary() {
        return "Ticket #" + ticketID + ": " + title + " (State: " + state + ")";
    }


    //aendert die priority
    public void changePriority(int newPriority) {
        this.priority = newPriority;
    }

    //aendert den status
    public void changeState(int newState) {
        this.state = newState;
    }


    public void saveTicket(String filePath, Ticket ticket, String fileName) {
        ObjectMapper oM = new ObjectMapper();
        oM.findAndRegisterModules(); // Um Date und komplexe Typen zu unterstützen
        try {
            oM.writeValue(new File(new File(filePath) +"/" + fileName + ".Json"), toString()); // Serialisiert das gesamte Objekt
            System.out.println("Ticket erfolgreich gespeichert: " + filePath);
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern des Tickets: " + e.getMessage());
        }
    }


    public static JSONObject getTicketData(String filePath) {
        File file = new File(filePath);
        try{
            String ticketContent = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            JSONObject json = new JSONObject(ticketContent); //erstellt ein json objekt wo das ticket drin steht
            return json; // returned alles was im ticket steht
        } catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
            return null;
        }
    }


    public static ObservableList<Ticket> loadTickets(String directoryPath) {
        File dir = new File(directoryPath);
        ObservableList<Ticket> ticketList = FXCollections.observableArrayList();
        ObjectMapper oM = new ObjectMapper();

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Ticket-Ordner existiert nicht.");
            return ticketList;
        }

        for (File file : dir.listFiles((d, name) -> name.endsWith(".json"))) {
            try {
                Ticket ticket = oM.readValue(file, Ticket.class);
                ticketList.add(ticket);
            } catch (IOException e) {
                System.out.println("Fehler beim Laden von Ticket: " + e.getMessage());
            }
        }
        return ticketList;
    }



}