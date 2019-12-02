package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TableController implements Initializable {

	@FXML
	private TableView<Patient> table;
	@FXML
	private TableColumn<Patient, String> col_id;
	@FXML
	private TableColumn<Patient, String> col_fn;
	@FXML
	private TableColumn<Patient, String> col_ln;
	@FXML
	private TableColumn<Patient, String> col_dob;
	@FXML
    private Button logoutBtn;
	@FXML
	private Button selectBtn;
	
	String UserID;

	ObservableList<Patient> oblist = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		final String DB_URL = "jdbc:mysql://localhost:3306/Spartan_Healthcare?serverTimezone=UTC";
		final String SELECT_QUERY = "SELECT PATIENT_ID, GENDER, FNAME, LNAME FROM PATIENTS";
		
		try {
			Connection con = DBConnector.getConnection();

			ResultSet rs = con.createStatement().executeQuery("SELECT * FROM PATIENTS");
			
			while (rs.next()) {
				oblist.add(new Patient(rs.getString("PATIENT_ID"), rs.getString("GENDER"), rs.getString("DOB"), rs.getString("FNAME"), rs.getString("LNAME"),
						rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIPCODE"), rs.getString("EMAIL"),
						rs.getString("INSURANCE"), rs.getString("PHONE"), rs.getString("USER_ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		col_id.setCellValueFactory(new PropertyValueFactory<>("PATIENT_ID"));
		col_fn.setCellValueFactory(new PropertyValueFactory<>("GENDER"));
		col_ln.setCellValueFactory(new PropertyValueFactory<>("FNAME"));
		col_dob.setCellValueFactory(new PropertyValueFactory<>("LNAME"));
		
		
		table.setItems(oblist);

	}
	
	@FXML
    void logout(ActionEvent event) throws IOException {
		System.out.println("Back to Login Screen!");
    	FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "loginScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		AnchorPane loginParent = (AnchorPane) loader.load(fxmlStream);
    	
    	Scene loginScene = new Scene (loginParent);
    	
    	loginController loginCon = loader.getController();
    	
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(loginScene);
    	window.show();
    }
	
	@FXML
	void changeToPtScreen(ActionEvent event) throws IOException {
		
		System.out.println("Change to Patient Screen!");
    	FXMLLoader loader = new FXMLLoader();
		String fxmlDocPath = "patientScreen.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		AnchorPane loginParent = (AnchorPane) loader.load(fxmlStream);
    	
    	Scene loginScene = new Scene (loginParent);
    	
		patientScreenController ptcon = loader.getController();
		ptcon.initData(table.getSelectionModel().getSelectedItem());
    	    	
    	Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	window.setScene(loginScene);
    	window.show();
	}

}
