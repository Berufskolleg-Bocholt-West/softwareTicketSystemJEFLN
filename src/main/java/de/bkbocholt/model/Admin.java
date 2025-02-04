package de.bkbocholt.model;

public class Admin extends User{
    private String persmission;
    
    public Admin(String firstName, String lastName, String eMail, String password, Integer persmission ) {
        super(firstName, lastName, eMail, password);
        if (persmission == 0) {
            this.persmission = "Admin";
        } else if (persmission == 1) {
            this.persmission = "User";
        } else {
            this.persmission = "Guest";
        }
    }
}
