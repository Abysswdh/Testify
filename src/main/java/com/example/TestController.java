package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TestController {

    @FXML
    private Label statusLabel;

    private int clickCount = 0;

    @FXML
    private void handleTestClick() {
        clickCount++;
        statusLabel.setText("JavaFX template is working! Button clicked " + clickCount + (clickCount == 1 ? " time." : " times."));
    }

    @FXML
    private void openPrimary() throws IOException {
        App.setRoot("primary");
    }
}
