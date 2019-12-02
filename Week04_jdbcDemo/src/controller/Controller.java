package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.StudentDAO_Test2;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for main operations
 **
 */

//TODO Remove my user name password database name from properties.

public class Controller implements Initializable {

	private StudentDAO_Test2 studentDAO_Test2;

	/**
	 * Use this to set up the table for the database.
	 * 
	 * @param location  url passed in.
	 * @param resources resource bundle passed in.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Calling here to check if table exists.
		studentDAO_Test2 = new StudentDAO_Test2();
		studentDAO_Test2.createIfNone();
	}

	@FXML
	private TextField userID;

	@FXML
	private TextField password;

	@FXML
	public void myAction() {
		studentDAO_Test2.addNewUser(userID.getText(), password.getText());
		// lblDisplay.setText(arg0);
	}

}
