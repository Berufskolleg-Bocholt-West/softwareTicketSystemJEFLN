
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

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.databind.util.JSONPObject;
import javafx.fxml.FXML;

import org.json.JSONObject;

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

/*
   soll commentare nach id suchen aber kp wie funktioniert
   ist von chatgt
   public comment findComment(int commentID){
            return comments.stream()
            .filter(comment -> comment.getCommentID() == commentID)
            .findFirst()
            .orElse(null);
    }
*/

    //aendert die priority
    public void changePriority(int newPriority) {
        this.priority = newPriority;
    }

    //aendert den status
    public void changeState(int newState) {
        this.state = newState;
    }


    public void saveTicket(String filePath) {
        ObjectMapper oM = new ObjectMapper();
        oM.findAndRegisterModules(); // Um Date und komplexe Typen zu unterstützen
        try {
            oM.writeValue(new File(filePath), toString()); // Serialisiert das gesamte Objekt
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

    public static String getJsonString(String fileName, String varName) throws IOException {
        try {
            File file = new File(fileName);
            String ticketContent = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            JSONObject json = new JSONObject(ticketContent);
            if (json.has(varName)) {
                return json.getString(varName); // sucht nach einer bestimmten variable die einen string beinhaltet und gibt den drinstehenden wert zurück
            } else {
                System.out.println("Error in reading data from file: " + fileName);
                return null;
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
            return null;
        }
    }

    public static int getJsonInt(String fileName, String varName) throws IOException {
        try{
            File file = new File(fileName);
            String ticketContent = new String(Files.readAllBytes(Paths.get(file.toURI())), "UTF-8");
            JSONObject json = new JSONObject(ticketContent);
            if (json.has(varName)) {
                return json.getInt(varName);
            }
            else {
                System.out.println("Error in reading data from file: " + fileName);
                return 0;
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
            return 0;
        }
    }

    public void createTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ticket Creator");
        System.out.println("----------------");
        System.out.print("Enter the ticket ID: ");
        this.ticketID = scanner.nextInt();
        scanner.nextLine(); // Konsolenpuffer leeren

        System.out.print("Enter the title of the ticket: ");
        this.title = scanner.nextLine();

        System.out.print("Enter the description of the ticket: ");
        this.description = scanner.nextLine();

        this.createdBy = "Ewan Olbrich";
        this.editor = "Ewan Olbrich";
        this.priority = 3; // Standardwert
        this.state = 1; // Standardwert für Status (offen)
        this.assignedUser = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.attachments = new ArrayList<>();
        this.history = new ArrayList<>();

        System.out.println("Ticket created:");
        System.out.println(this);
        String filePath = "/home/ewan/"+ this.title+ ".json";
        saveTicket(filePath);
        System.out.println("Ticket created and saved to /home/ewan/"+ this.title+ ".json");
    }

}