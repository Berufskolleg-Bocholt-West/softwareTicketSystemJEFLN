package de.bkbocholt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static de.bkbocholt.model.coresys.core.isDirectoryMissing;

public class User {
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


    public static Path getUserSystemPath() {
        String userHome = System.getProperty("user.home");
        return Paths.get(userHome, "Documents");
    }

    @JsonIgnore
    public int getLastUserID() throws IOException {
        String documentsPath = getUserSystemPath().toString();
        Path directoryPath = Paths.get(documentsPath, "TicketProgramm");
        Path filePath = directoryPath.resolve("config.conf");

        File directory = directoryPath.toFile();
        isDirectoryMissing(directory);

        File file = filePath.toFile();
        if (!file.exists()) {
            try {
                file.createNewFile();
                Map<String, Object> initialConfig = new HashMap<>();
                initialConfig.put("lastUserIdCreated", 1);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(file, initialConfig);
            } catch (IOException e) {
                throw e;
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> jsonMap = objectMapper.readValue(file, Map.class);
            if (jsonMap.containsKey("lastUserIdCreated")) {
                int lastUserId = (int) jsonMap.get("lastUserIdCreated");
                int newUserId = lastUserId + 1;

                jsonMap.put("lastUserIdCreated", newUserId);
                objectMapper.writeValue(file, jsonMap);
                return newUserId;
            } else {
                throw new IOException("Variable 'lastUserIdCreated' not found in Config.");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // Fallback
        }
    }

    public static void saveUserToJSON(User user) throws IOException {
        String ticketProgramPath = getUserSystemPath().toString();
        Path userDirectory = Paths.get(ticketProgramPath, "TicketProgramm","User");

        File directory = new File(userDirectory.toString());
        isDirectoryMissing(directory);

        String fileName = user.geteMail() + ".json"; // nur zu email gaändert damit es leichter ist
        Path filePath = Paths.get(userDirectory.toString(), fileName);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath.toString()), user);
    }
}
