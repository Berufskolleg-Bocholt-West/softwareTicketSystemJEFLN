package de.bkbocholt.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty alter;

    public Person(String name, int alter) {
        this.name = new SimpleStringProperty(name);
        this.alter = new SimpleIntegerProperty(alter);
    }

    public String getName() { return name.get(); }
    public int getAlter() { return alter.get(); }
}

