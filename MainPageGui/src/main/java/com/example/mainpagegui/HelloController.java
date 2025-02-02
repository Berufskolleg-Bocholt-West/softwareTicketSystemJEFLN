package com.example.mainpagegui;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private VBox AufmachenButton;

    @FXML
    private VBox menuDrawer;

    @FXML
    private Button MenueZUButton;

    private boolean menuVisible = false;

    @FXML
    public void initialize() {

        AufmachenButton.setOnMouseClicked(event -> MenuAuf());


        MenueZUButton.setOnAction(event -> MenuZU());
    }

    private void MenuAuf() {
        TranslateTransition transition = new TranslateTransition(Duration.millis(300), menuDrawer);
        if (menuVisible) {
            transition.setToX(-200);
        } else {
            transition.setToX(200);
        }
        transition.play();
        menuVisible = !menuVisible;
    }

    private void MenuZU() {
        if (menuVisible) {
            TranslateTransition transition = new TranslateTransition(Duration.millis(300), menuDrawer);
            transition.setToX(-200);
            transition.play();
            menuVisible = false;
        }
    }
}
