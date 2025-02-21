package de.bkbocholt.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bkbocholt.model.coresys.core;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class logger {

    private static final Logger logger = Logger.getLogger(logger.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            // Datei-Handler nur einmal erstellen
            fileHandler = new FileHandler("logfile.log", true); // Append-Modus
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            System.err.println("Fehler beim Erstellen des Log-Handlers: " + e.getMessage());
        }
    }

    public static void saveFile(String usage) {
        String userPost = "test post";
        String userComment = "test comment";
        String filePath = "test path";
        switch (usage) {
            case "login":
                logger.info("User logged in");
                break;
            case "logout":
                logger.info("User logged out");
                break;
            case "post":
                logger.fine("User post: " + userPost);
                break;
            case "comment":
                logger.fine("User comment" + userComment);
                break;
            case "file":
                logger.fine("user file:" + filePath);
                break;
            default:
                logger.warning("Unbekannte Aktion: " + usage);
                break;
        }
    }

    // Beispielmethoden zum Laden und Speichern von Daten
    private static String loadUserData() throws Exception {
        // Simuliert das Laden von Daten
        return "Max Mustermann";
    }

    private static void saveUserData(String data) throws Exception {
        // Simuliert das Speichern von Daten
        if (data == null) {
            throw new Exception("Daten sind ungültig.");
        }

}}
