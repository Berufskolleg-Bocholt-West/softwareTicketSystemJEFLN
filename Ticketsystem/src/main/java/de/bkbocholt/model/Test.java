package de.bkbocholt.model;

public class Test {
    public static void main(String[] args) {
        Role AlphaMale = new Role();
        AlphaMale.roleID = 1;
        AlphaMale.name = "AlphaMale";
        AlphaMale.description = "Nur für Echte Rizzler";

        System.out.println(AlphaMale.roleID+""+AlphaMale.name+""+AlphaMale.description);
    }
}
