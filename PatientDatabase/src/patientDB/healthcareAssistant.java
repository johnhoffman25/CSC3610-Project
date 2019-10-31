package patientDB;

public class healthcareAssistant extends healthcareUser{
	
	String doctor;

	public healthcareAssistant(String userID, String pw, String firstName, String lastName, String doctor) {
		super(userID, pw, firstName, lastName);
		this.doctor = doctor;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
}
