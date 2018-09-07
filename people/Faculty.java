package people;

public class Faculty extends Person {
	
	private int facultyid;

	Faculty(String name, int age, String address, int facultyid) {
		super(name, age, address);
		this.facultyid = facultyid;
	}
	
	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}
	
	@Override
	public String getCredentials() {
		return super.getCredentials() + ", facultyid: " + facultyid;
	}
}
