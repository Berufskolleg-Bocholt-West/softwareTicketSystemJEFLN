package de.bkbocholt.model;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class core {
    public static void generateDefaultConfig() throws IOException {
        String documentsPath = User.getUserSystemPath().toString();
        Path configFilePath = Paths.get(documentsPath, "config.json");

        Map<String, Object> defaultConfig = new HashMap<>();
        defaultConfig.put("lastUserIdCreated", 0);
        defaultConfig.put("applicationName", "Ticketsystem");
        defaultConfig.put("version", "0.0.1");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(configFilePath.toString()), defaultConfig);
            System.out.println("Default config.json erstellt: " + configFilePath);
        } catch (IOException e) {
            System.out.println("Error beim erstellen der config.json: " + e.getMessage());
        }
    }
    public static void checkForConfig() throws IOException{
        if (!(Files.exists(Path.of(User.getUserSystemPath() + "/config.json")))) {
            generateDefaultConfig();
        }
    }
}
