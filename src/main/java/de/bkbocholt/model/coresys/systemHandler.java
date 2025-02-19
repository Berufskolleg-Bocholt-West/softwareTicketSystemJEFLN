package de.bkbocholt.model.coresys;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.bkbocholt.model.User;
import de.bkbocholt.model.Comment;
import de.bkbocholt.model.Ticket;

public class systemHandler {
    static String documentsPath = User.getUserSystemPath().toString();
    static Path ticketProgramPath = Paths.get(documentsPath, "TicketProgramm");
    static Path folderPathTicket = Paths.get(ticketProgramPath.toString(), "Ticket");
    static Path folderPathComment = Paths.get(ticketProgramPath.toString(), "Comment");
    static Path folderPathUser = Paths.get(ticketProgramPath.toString(), "User");

    public static List<User> loadUsersFromJsonFiles() {
        List<User> users = new ArrayList<>();
        File folder = new File(folderPathUser.toString());
        File[] listOfFiles = folder.listFiles(( dir, name ) -> name.endsWith(".json"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (FileReader reader = new FileReader(file)) {
                    JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
                    User user = new Gson().fromJson(jsonObject, User.class);
                    users.add(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("The folder is empty or does not exist.");
        }
        // Gibt das Array mit den Benutzern zurück
        return users;
    }

    public static List<Comment> loadCommentsFromJsonFiles() {
        List<Comment> comments = new ArrayList<>();
        File folder = new File(folderPathComment.toString());
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (FileReader reader = new FileReader(file)) {
                    JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
                    Comment comment = new Gson().fromJson(jsonObject, Comment.class);
                    comments.add(comment);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("The folder is empty or does not exist.");
        }

        // Gibt das Array mit den Kommentaren zurück
        return comments;
    }

    public static List<Ticket> loadTicketsFromJsonFiles() {
        List<Ticket> tickets = new ArrayList<>();
        File folder = new File(folderPathTicket.toString());
        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (FileReader reader = new FileReader(file)) {
                    JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
                    Ticket ticket = new Gson().fromJson(jsonObject, Ticket.class);
                    tickets.add(ticket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("The folder is empty or does not exist.");
        }

        // Gibt das Array mit den Tickets zurück
        return tickets;
    }
}

