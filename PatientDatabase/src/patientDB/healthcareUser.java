package patientDB;

public class healthcareUser {
	
	String userID;
	String pw;
	String firstName;
	String lastName;
	
	public healthcareUser(String userID, String pw, String firstName, String lastName) {
		super();
		this.userID = userID;
		this.pw = pw;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	

}
