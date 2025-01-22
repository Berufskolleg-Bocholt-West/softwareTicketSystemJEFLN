module de.bkbocholt.ticketsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires json;

    opens de.bkbocholt.model to javafx.fxml;
    opens view to javafx.fxml; // Öffne das Paket, in dem die FXML-Datei liegt

    exports de.bkbocholt.model;
}
