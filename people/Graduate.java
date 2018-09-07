package people;

public class Graduate extends Student {
	
	private double gpa;

	private String major;

	Graduate(String name, int age, String address, int cwid, double gpa, String major) {
		super(name, age, address, cwid);
		this.gpa = gpa;
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Override
	public String getCredentials() {
		return super.getCredentials() + ", gpa: " + gpa + ", major " + major;
	}
}
