module de.bkbocholt.ticketsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    opens de.bkbocholt.ticketsystem to javafx.fxml;
    exports de.bkbocholt.ticketsystem;
}