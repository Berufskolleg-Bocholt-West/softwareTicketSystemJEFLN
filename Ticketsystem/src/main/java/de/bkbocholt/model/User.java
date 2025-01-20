package de.bkbocholt.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class User {
    // Variablen
    private Integer userID;
    private String firstName;
    private String lastName;
    private String eMail;
    private String password;

    public User(Integer userID, String firstName, String lastName, String eMail, String password) {
        try {
            this.userID = getLastUserID();
        } catch (IOException e) {
            e.printStackTrace();
            this.userID = 0; // Fallback
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }

    // Getter & Setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserSystemPath() {
        String userHome = System.getProperty("user.home");
        return Paths.get(userHome, "Documents").toString();
    }

    public int getLastUserID() throws IOException {
        String documentsPath = getUserSystemPath();
        Path filePath = Paths.get(documentsPath, "config.json");

        if (!Files.exists(filePath)) {
            System.out.println("Konfigurationsdatei nicht gefunden: " + filePath);
            return 0; // Fallback
        }

        // JSON-Datei parsen
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Datei in ein Map-Objekt einlesen
            Map<String, Object> jsonMap = objectMapper.readValue(new File(filePath.toString()), Map.class);

            // Nach dem Schlüssel "lastUserIdCreated" suchen
            if (jsonMap.containsKey("lastUserIdCreated")) {
                return (int) jsonMap.get("lastUserIdCreated");
            } else {
                System.out.println("Key 'lastUserIdCreated' nicht gefunden.");
                return 0; //Fallback
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der JSON-Datei: " + e.getMessage());
            return 0; //Fallback
        }
    }
}
