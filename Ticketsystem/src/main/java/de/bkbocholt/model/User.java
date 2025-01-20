package de.bkbocholt.model;

import java.util.ArrayList;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<Role> assingedRoles;

    public User(int userId, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.assingedRoles = new ArrayList<>();
    }

    public int getUserId() {return userId;}
    public void setUserId() {this.userId = userId;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public ArrayList<Role> getAssingedRoles() {return assingedRoles;}
    public void setAssingedRoles(ArrayList<Role> assingedRoles) {this.assingedRoles = assingedRoles;}

    public void saveToFile() {

    }

    public void readFromFile() {

    }
}


