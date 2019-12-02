package model;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class adminController {

	@FXML
	private Button signOutBtn;
	
	@FXML
	private Button addUserBtn;

	@FXML
	void changeToLogin(ActionEvent event) throws IOException {
		System.out.println("Back to Login Screen!");
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "loginScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		AnchorPane loginParent = (AnchorPane) loader.load(fxmlStream);

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();

	}

	@FXML
	void changeToNewUser(ActionEvent event) throws IOException {
		System.out.println("Add New User!");
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "newUserScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		AnchorPane loginParent = (AnchorPane) loader.load(fxmlStream);

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();
	}

}
