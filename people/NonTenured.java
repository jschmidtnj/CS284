package people;

public class NonTenured extends Faculty {
	
	private double salary;

	NonTenured(String name, int age, String address, int facultyid, double salary) {
		super(name, age, address, facultyid);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String getCredentials() {
		return super.getCredentials() + ", salary: " + salary;
	}
}
