package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class newUserController {

	@FXML
	private TextField userTxtField;

	@FXML
	private TextField pwTxtField;

	@FXML
	private Button registerBtn;

	@FXML
	private Label resultLabel;

	@FXML
	private Button backBtn;

	@FXML
	void goToLogin(ActionEvent event) throws IOException {
		System.out.println("Back to Login Screen!");
		FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "admin2.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		TitledPane loginParent = (TitledPane) loader.load(fxmlStream);

		Scene loginScene = new Scene(loginParent);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(loginScene);
		window.show();

	}

	@FXML
	void registerNewUser(ActionEvent event) {

		ArrayList<User> userList = ConnectDisplayUsers.generateUserList();

		String userInput = userTxtField.getText();
		String pwInput = pwTxtField.getText();

		for (User user : userList) {
			if (userInput.equals(user.getUserID())) {
				resultLabel.setText("Error: User ID already created, please try a new User ID");
			} else if (pwInput.equals(user.getPassword())) {
				resultLabel.setText("Error: Password already created, please try a new Password");
			} else if (userInput.length() != 5) {
				resultLabel.setText("Error: User ID must be 5 digits in length");
			} else {
				try (Connection connection = DBConnector.getConnection()) {

					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO USERS(USER_ID, PASSWORD)" + " VALUES ('" + userInput + "', '"
									+ pwInput + "' )");
					preparedStatement.execute();
					System.out.print("\nConnected to database!\nNew user was added successfully\n");
					resultLabel.setText("New User Added Succesfully!");
					// lblDisplay.setText();
				} catch (SQLException e) {
					System.out.print(e.getMessage());
				}
			}
		}
	}

}
