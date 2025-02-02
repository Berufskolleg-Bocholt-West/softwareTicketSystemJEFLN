module com.example.mainpagegui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.mainpagegui to javafx.fxml;
    exports com.example.mainpagegui;
}