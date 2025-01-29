package de.bkbocholt.model.core;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.bkbocholt.model.User;

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
}
