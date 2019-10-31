package patientDB;

public class healthcareDoctor extends healthcareUser{
	
	String specialty;
	String assistant;
	Appointments [] appts;
	
	public healthcareDoctor(String userID, String pw, String firstName, String lastName, String specialty,
			String assistant, Appointments[] appts) {
		super(userID, pw, firstName, lastName);
		this.specialty = specialty;
		this.assistant = assistant;
		this.appts = appts;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public Appointments[] getAppts() {
		return appts;
	}

	public void setAppts(Appointments[] appts) {
		this.appts = appts;
	}
	
	
	
	
}
