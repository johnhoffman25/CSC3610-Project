package model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class patientScreenController {

	private Patient selectedPatient;
	
    @FXML
    private Label cityLabel;

    @FXML
    private Label streetAddressLabel;

    @FXML
    private Label stateLabel;

    @FXML
    private Label zipLabel;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button editPtInfoBtn;

    @FXML
    private Button makePmtBtn;

    @FXML
    private Label fnameLabel;

    @FXML
    private Label lnameLabel;

    @FXML
    private Label dobLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label pmtResult;

    @FXML
    private Button addCCBtn;

    @FXML
    void addCreditCardInfo(ActionEvent event) {

    }

    @FXML
    void changeToLogin(ActionEvent event) {

    }

    @FXML
    void editPtInfo(ActionEvent event) {

    }

    @FXML
    void makePayment(ActionEvent event) {

    }
    
    public void initData (Patient patient) {
    	selectedPatient = patient;
    	fnameLabel.setText(selectedPatient.getFNAME());
    	lnameLabel.setText(selectedPatient.getLNAME());
    	dobLabel.setText(selectedPatient.getDOB());
    	genderLabel.setText(selectedPatient.getGENDER());
    	phoneLabel.setText(selectedPatient.getPHONE());
    	emailLabel.setText(selectedPatient.getEMAIL());
    	
    }

}
