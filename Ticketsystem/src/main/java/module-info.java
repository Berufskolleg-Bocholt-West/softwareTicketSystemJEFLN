module de.bkbocholt.ticketsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    opens de.bkbocholt.model to com.fasterxml.jackson.databind;
    opens de.bkbocholt.ticketsystem to javafx.fxml;
    exports de.bkbocholt.ticketsystem;
    exports de.bkbocholt.model to javafx.graphics;
    exports de.bkbocholt.model.core to javafx.graphics;
    opens de.bkbocholt.model.core to com.fasterxml.jackson.databind;
}