module de.bkbocholt.ticketsystem {
    requires javafx.controls;
    requires javafx.fxml;
/

    opens de.bkbocholt.ticketsystem to javafx.fxml;
    exports de.bkbocholt.ticketsystem;
}