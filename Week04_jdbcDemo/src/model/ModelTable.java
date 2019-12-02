package model;

public class ModelTable {
	
	String PATIENT_ID, GENDER, FNAME, LNAME;

	public ModelTable(String patientID, String gender, String fname, String lname) {
		this.PATIENT_ID = patientID;
		this.GENDER = gender;
		this.FNAME = fname;
		this.LNAME = lname;
		
	}

	public String getPATIENT_ID() {
		return PATIENT_ID;
	}

	public void setPATIENT_ID(String PATIENT_ID) {
		this.PATIENT_ID = PATIENT_ID;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String GENDER) {
		this.GENDER = GENDER;
	}

	public String getFNAME() {
		return FNAME;
	}

	public void setFNAME(String FNAME) {
		this.FNAME = FNAME;
	}

	public String getLNAME() {
		return LNAME;
	}

	public void setLNAME(String LNAME) {
		this.LNAME = LNAME;
	}
	
	
	
}
