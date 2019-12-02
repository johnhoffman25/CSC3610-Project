package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main is the entry point of our application.
 * This is a JavaFX App example connecting to a MySQL database
 * Requirements: 
 * - installed MySQL Server on the local host.
 * - provide name of database
 * - provide a user and password
 * - and should create student.properties file that contains:- username/password
 * 
 */

public class Main2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/new_user.fxml"));
        primaryStage.setTitle("Enter New User");
        Scene scene = new Scene(root, 500, 350);
        scene.getStylesheets().add(getClass().getResource("../view/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
