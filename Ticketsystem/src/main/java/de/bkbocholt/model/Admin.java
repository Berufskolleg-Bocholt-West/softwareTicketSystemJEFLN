package de.bkbocholt.model;

public class Admin extends User{
    private Integer persmission;
    
    public Admin(String firstName, String lastName, String eMail, String password, Integer persmission ) {
        super(firstName, lastName, eMail, password);
        this.persmission = persmission;
    }
}
