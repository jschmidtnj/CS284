package people;

public class Student extends Person {

	private int cwid;

	Student(String name, int age, String address, int cwid) {
		super(name, age, address);
		this.cwid = cwid;
	}

	public int getCwid() {
		return cwid;
	}

	public void setCwid(int cwid) {
		this.cwid = cwid;
	}
	
	@Override
	public String getCredentials() {
		return super.getCredentials() + ", cwid: " + cwid;
	}
}
