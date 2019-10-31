package patientDB;

public class healthcarePatient extends healthcareUser{
	
	String DOB;
	String address;
	String city;
	String State;
	int zipcode;
	String email;
	String insurance;
	String phoneNum;
	String PCP;
	int creditCard;
	int expiration;
	int secCode;
	String gender;
	String [] medication;
	String [] allergies;
	
	public healthcarePatient(String userID, String pw, String firstName, String lastName, String dOB, String address,
			String city, String state, int zipcode, String email, String insurance, String phoneNum, String pCP,
			int creditCard, int expiration, int secCode, String gender, String[] medication, String[] allergies) {
		super(userID, pw, firstName, lastName);
		DOB = dOB;
		this.address = address;
		this.city = city;
		State = state;
		this.zipcode = zipcode;
		this.email = email;
		this.insurance = insurance;
		this.phoneNum = phoneNum;
		PCP = pCP;
		this.creditCard = creditCard;
		this.expiration = expiration;
		this.secCode = secCode;
		this.gender = gender;
		this.medication = medication;
		this.allergies = allergies;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPCP() {
		return PCP;
	}

	public void setPCP(String pCP) {
		PCP = pCP;
	}

	public int getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}

	public int getExpiration() {
		return expiration;
	}

	public void setExpiration(int expiration) {
		this.expiration = expiration;
	}

	public int getSecCode() {
		return secCode;
	}

	public void setSecCode(int secCode) {
		this.secCode = secCode;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getMedication() {
		return medication;
	}

	public void setMedication(String[] medication) {
		this.medication = medication;
	}

	public String[] getAllergies() {
		return allergies;
	}

	public void setAllergies(String[] allergies) {
		this.allergies = allergies;
	}
	
	
	
}