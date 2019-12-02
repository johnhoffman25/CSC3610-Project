package model;

public class Patient {
	
	String PATIENT_ID;
	String GENDER;
	String DOB;
	String FNAME;
	String LNAME;
	String ADDRESS;
	String CITY;
	String STATE;
	String ZIPCODE;
	String EMAIL;
	String INSURANCE;
	String PHONE;
	String USER_ID;
	
	public Patient(String pATIENT_ID, String gENDER, String dOB, String fNAME, String lNAME, String aDDRESS,
			String cITY, String sTATE, String zIPCODE, String eMAIL, String iNSURANCE, String pHONE, String uSER_ID) {
		PATIENT_ID = pATIENT_ID;
		GENDER = gENDER;
		DOB = dOB;
		FNAME = fNAME;
		LNAME = lNAME;
		ADDRESS = aDDRESS;
		CITY = cITY;
		STATE = sTATE;
		ZIPCODE = zIPCODE;
		EMAIL = eMAIL;
		INSURANCE = iNSURANCE;
		PHONE = pHONE;
		USER_ID = uSER_ID;
	}

	public String getPATIENT_ID() {
		return PATIENT_ID;
	}

	public void setPATIENT_ID(String pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getFNAME() {
		return FNAME;
	}

	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}

	public String getLNAME() {
		return LNAME;
	}

	public void setLNAME(String lNAME) {
		LNAME = lNAME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getZIPCODE() {
		return ZIPCODE;
	}

	public void setZIPCODE(String zIPCODE) {
		ZIPCODE = zIPCODE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getINSURANCE() {
		return INSURANCE;
	}

	public void setINSURANCE(String iNSURANCE) {
		INSURANCE = iNSURANCE;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}
}