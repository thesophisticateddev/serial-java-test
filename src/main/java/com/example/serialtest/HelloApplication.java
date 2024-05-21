package com.example.serialtest;

import app.supernaut.fx.ApplicationDelegate;
import app.supernaut.fx.FxLauncher;
import app.supernaut.logging.JavaLoggingSupport;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Singleton
public class HelloApplication implements ApplicationDelegate {

    private static final Logger logger = LoggerFactory.getLogger(HelloApplication.class);

//    @Inject
//    private LogRecordService logRecordService;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        fxmlLoader.setController(new HelloController(logRecordService));
        Scene scene = new Scene(fxmlLoader.load(), 980, 640);
        stage.setTitle("TestPGM");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        JavaLoggingSupport.configure(HelloApplication.class, "com.example.serialtest");
        logger.info("Logging Configured");
        FxLauncher.find().launch(args, HelloApplication.class);
    }
}