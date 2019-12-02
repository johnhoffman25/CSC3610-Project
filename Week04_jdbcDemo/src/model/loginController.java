package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class loginController {

	@FXML
	private TextField userTextField;

	@FXML
	private PasswordField passwordText;

	@FXML
	private Button adminLoginBtn;

	@FXML
	private Button loginBtn;

	@FXML
	private Label loginResult;

	@FXML
	void changeToPtLookup(ActionEvent event) throws IOException {

		ArrayList<User> userList = ConnectDisplayUsers.generateUserList();

		System.out.println("Log into user account!");

		String username = userTextField.getText();
		String pass = passwordText.getText();

		for (User user : userList) {
			if (username.equals(user.getUserID()) && pass.equals(user.getPassword())) {
				FXMLLoader loader = new FXMLLoader();
				String fxmlDocPath = "db.fxml";
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

				AnchorPane tableParent = (AnchorPane) loader.load(fxmlStream);

				Scene ptLookupScene = new Scene(tableParent);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(ptLookupScene);
				window.show();
			} else if (username.equals("admin") && pass.equals("password")) {
				FXMLLoader loader = new FXMLLoader();
				String fxmlDocPath = "db.fxml";
				FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

				AnchorPane tableParent = (AnchorPane) loader.load(fxmlStream);

				Scene ptLookupScene = new Scene(tableParent);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(ptLookupScene);
				window.show();
			} else if (userTextField.getText().isEmpty() || passwordText.getText().isEmpty()) {
				if (userTextField.getText().isEmpty()) {
					loginResult.setText("Please enter username");
				} else {
					loginResult.setText("Please enter password");
				}
			} else {
				loginResult.setText("Wrong username or password");
			}
		}

	}

	@FXML
	void changeToAdmin(ActionEvent event) throws IOException {
		// System.out.println("Switched to Admin Screen!");

		String username = userTextField.getText();
		String pass = passwordText.getText();
		System.out.println("You are " + username);

		if (username.equals("admin") && pass.equals("password")) {
			FXMLLoader loader = new FXMLLoader();
			String fxmlDocPath = "admin2.fxml";
			FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

			TitledPane adminParent = (TitledPane) loader.load(fxmlStream);

			Scene adminScene = new Scene(adminParent);

			// adminController adminCon = loader.getController();

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(adminScene);
			window.show();
		} else if (userTextField.getText().isEmpty() || passwordText.getText().isEmpty()) {
			if (userTextField.getText().isEmpty()) {
				loginResult.setText("Please enter username");
			} else {
				loginResult.setText("Please enter password");
			}
		} else {
			System.out.print("Wrong username or password");
			loginResult.setText("Wrong username or password");
		}

//		FXMLLoader loader = new FXMLLoader();
//		String fxmlDocPath = "Admin.fxml";
//		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
//
//		BorderPane adminParent = (BorderPane) loader.load(fxmlStream);
//
//		Scene adminScene = new Scene(adminParent);
//
//		adminController adminCon = loader.getController();
//
//		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//		window.setScene(adminScene);
//		window.show();
	}

}