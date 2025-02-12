package de.bkbocholt.model.coresys;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.bkbocholt.model.Ticket;
import de.bkbocholt.model.User;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class core {
    public static int userID;
    public static String userEmailAddress;
    public static Boolean isUserAdmin;
    public static boolean isUserLoggedIn;

    public static void generateDefaultConfig() throws IOException {
        String documentsPath = User.getUserSystemPath().toString();

        Path folderPath = Paths.get(documentsPath, "TicketProgramm");
        Path configFilePath = folderPath.resolve("config.conf");

        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }

        Map<String, Object> defaultConfig = new HashMap<>();
        defaultConfig.put("lastUserIdCreated", 0);
        defaultConfig.put("applicationName", "Ticketsystem");
        defaultConfig.put("version", "0.0.1");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(configFilePath.toString()), defaultConfig);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public static void checkForConfig() throws IOException {
        String documentsPath = User.getUserSystemPath().toString();
        Path configFilePath = Paths.get(documentsPath, "TicketProgramm", "config.json");

        if (!Files.exists(configFilePath)) {
            generateDefaultConfig();
        }
    }

    public static String getJsonString(Path fileLocation,String fileName, String varName) throws IOException {
        try {
            String fileLocationString = fileLocation.toString();
            String jsonContent = new String(Files.readAllBytes(Paths.get(fileLocationString + "/" + fileName)));
            JSONObject json = new JSONObject(jsonContent);
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
    public static int getJsonInt(Path fileLocation,String fileName, String varName) throws IOException {
        try{
            String fileLocationString = fileLocation.toString();
            String jsonContent = new String(Files.readAllBytes(Paths.get(fileLocationString + "/" + fileName)));
            JSONObject json = new JSONObject(jsonContent);
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

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public static void isDirectoryMissing(File directory) {
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void checkForAllDirectory() throws IOException {
        String documentsPath = User.getUserSystemPath().toString();
        Path ticketProgramPath = Paths.get(documentsPath, "TicketProgramm");
        Path userDirectory = Paths.get(ticketProgramPath.toString(), "User");
        Path ticketDirectory = Paths.get(ticketProgramPath.toString(), "Ticket");
        Path commentDirectory = Paths.get(ticketProgramPath.toString(), "Comment");
        Path attachmentDirectory = Paths.get(ticketProgramPath.toString(), "Attachment");
        Path historyDirectory = Paths.get(ticketProgramPath.toString(), "History");

        isDirectoryMissing(ticketProgramPath.toFile());
        isDirectoryMissing(userDirectory.toFile());
        isDirectoryMissing(ticketDirectory.toFile());
        isDirectoryMissing(commentDirectory.toFile());
        isDirectoryMissing(attachmentDirectory.toFile());
        isDirectoryMissing(historyDirectory.toFile());
        checkForConfig();
    }
    public static String getDirectory(String usage) {
        String documentsPath = User.getUserSystemPath().toString();
        Path ticketProgramPath = Paths.get(documentsPath, "TicketProgramm");
        switch (usage){
            case "Ticket":
                Path ticketDirectory = Paths.get(ticketProgramPath.toString(), "Ticket");
                return ticketDirectory.toString();
        case "User":
            Path userDirectory = Paths.get(ticketProgramPath.toString(), "User");
            return userDirectory.toString();
        case "comment":
            Path commentDirectory = Paths.get(ticketProgramPath.toString(), "Comment");
            return commentDirectory.toString();
        case "attachment":
            Path attachmentDirectory = Paths.get(ticketProgramPath.toString(), "Attachment");
            return attachmentDirectory.toString();
        case "history":
            Path historyDirectory = Paths.get(ticketProgramPath.toString(), "History");
            return historyDirectory.toString();
        }
    return null;
    }

    public static void initializeTicket(){
        try{
            String directory = getDirectory("Ticket");
            ArrayList<String> ticketList = new ArrayList<>();

        }catch(Exception e){
            System.out.println("Error in initializing Ticket: " + e.getMessage());
        }

    }
}
