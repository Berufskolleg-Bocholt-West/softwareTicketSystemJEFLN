package de.bkbocholt.model;

public class Role {
    public int roleID;
    public String name;
    public String description;

    public void Role(int roleID, String name, String description) {
        this.roleID = roleID;
        this.name = name;
        this.description = description;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void ShowRoleFull() {
        System.out.println("ID:" + roleID + "\nName:" + name + "\nDescription:" + description);
    }
}
