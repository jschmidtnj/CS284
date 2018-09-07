package people;

public class Undergraduate extends Student {
	
	private double gpa;

	Undergraduate(String name, int age, String address, int cwid, double gpa) {
		super(name, age, address, cwid);
		this.gpa = gpa;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String getCredentials() {
		return super.getCredentials() + ", gpa: " + gpa;
	}
}
