module de.bkbocholt.ticketsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    requires json;



    opens de.bkbocholt.model to javafx.fxml;
    opens view to javafx.fxml; // Öffne das Paket, in dem die FXML-Datei liegt


//    exports de.bkbocholt.model;
    exports de.bkbocholt.model to javafx.graphics, com.fasterxml.jackson.databind;
    exports de.bkbocholt.model.guihandler to com.fasterxml.jackson.databind, javafx.graphics;
    opens de.bkbocholt.model.guihandler to javafx.fxml;
}
