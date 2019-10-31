package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.StudentDAO;
import model.StudentDAO_Test;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for main operations
 **
 */

//TODO Remove my user name password database name from properties.

public class Controller implements Initializable {

	private StudentDAO_Test studentDAO_Test;

	/**
	 * Use this to set up the table for the database.
	 * 
	 * @param location  url passed in.
	 * @param resources resource bundle passed in.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Calling here to check if table exists.
		studentDAO_Test = new StudentDAO_Test();
		studentDAO_Test.createIfNone();
	}

	@FXML
	private TextField patientID;

	@FXML
	private TextField fname;

	@FXML
	private TextField lname;

	@FXML
	private TextField email;

	@FXML
	private TextField address;

	@FXML
	private TextField phone;

	@FXML
	private TextField dob;

	@FXML
	private Label lblDisplay;

	@FXML
	public void myAction() {
		studentDAO_Test.addNewPatient(patientID.getText(), fname.getText(), lname.getText(), email.getText(), address.getText(), phone.getText(), dob.getText());
		// lblDisplay.setText(arg0);
	}

}
