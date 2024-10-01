package com.fpdone.reservametaquest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;

import java.io.IOException;

public class ApplicationProgram extends Application {


    public static void main(String[] args) {

        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Group root = new Group();
        //Parent root = FXMLLoader.load(getClass().getResource("MainMenuView.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("RealizarReservaView.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("EliminarReservaView.fxml"));


        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MainMenuView.fxml"));

        Pane window = (Pane) fxmlLoader.load();

        Scene scene = new Scene(window, Color.DEEPSKYBLUE);

        //scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
        //String styleCSS = this.getClass().getResource("Styles.css").toExternalForm();
        //scene.getStylesheets().add(styleCSS);


        //Images
        Image icon = new Image("images/icon.png");



        //primaryStage.setWidth(1920);
        //primaryStage.setHeight(1080);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Reserva Meta Quest");
        primaryStage.show();

    }


}
