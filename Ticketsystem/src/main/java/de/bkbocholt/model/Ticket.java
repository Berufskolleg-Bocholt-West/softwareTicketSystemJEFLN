package de.bkbocholt.model;

import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    public int ticketID;
    public String title;
    public String description;
    public Date createdOn;
    public User createdBy;
    public User editor;
    public int priority;
    public int state;
    public ArrayList<User> assingedUsers;
    public ArrayList<Comment> comments;
    public ArrayList<File> attatchemtns;
    public ArrayList<String> history;

}
