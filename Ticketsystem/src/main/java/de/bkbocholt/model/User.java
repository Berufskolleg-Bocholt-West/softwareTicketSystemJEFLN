package de.bkbocholt.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
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

    public User(String firstName, String lastName, String eMail, String password) {
        try {
            this.userID = getLastUserID();
        } catch (IOException e) {
            e.printStackTrace();
            this.userID = -1; // Fallback
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

    // ID Ermittlung
    public static Path getUserSystemPath() {
        String userHome = System.getProperty("user.home");
        return Paths.get(userHome, "Documents");
    }

    public int getLastUserID() throws IOException {
        String documentsPath = getUserSystemPath().toString();
        Path filePath = Paths.get(documentsPath, "config.json");

        // JSON-Datei parsen
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Datei in ein Map-Objekt einlesen
            Map<String, Object> jsonMap = objectMapper.readValue(new File(filePath.toString()), Map.class);

            // Nach dem "lastUserIdCreated" suchen
            if (jsonMap.containsKey("lastUserIdCreated")) {
                int lastUserId = (int) jsonMap.get("lastUserIdCreated");
                int newUserId = lastUserId + 1;

                // Aktualisierte Zahl zurück in die JSON-Datei schreiben
                jsonMap.put("lastUserIdCreated", newUserId);
                objectMapper.writeValue(new File(filePath.toString()), jsonMap);

                return newUserId;
            } else {
                throw new IOException("Variabel 'lastUserIdCreated' nicht in JSON gefunden.");
            }
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen oder Schreiben der JSON-Datei: " + e.getMessage());
            return -1; // Fallback
        }
    }
}
