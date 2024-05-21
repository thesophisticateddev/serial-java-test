package com.example.serialtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(HelloApplication.class);

    private final LogRecordService logRecordService;
    public HelloController(LogRecordService logRecordService){
        this.logRecordService = logRecordService;
    }
    @FXML
    private Label welcomeText;

    @FXML
    private Button onButton;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onButtonClicked(ActionEvent event) {
        logRecordService.save("Button Event");

        logger.info("On Button Clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.debug("Initialized Hello Controller");
        onButton.setOnAction(this::onButtonClicked);
    }
}