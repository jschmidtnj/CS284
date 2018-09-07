package people;

public class Tenured extends Faculty {

	private double salary;

	private int yearsTenured;

	Tenured(String name, int age, String address, int facultyid, double salary, int yearsTenured) {
		super(name, age, address, facultyid);
		this.salary = salary;
		this.yearsTenured = yearsTenured;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getYearsTenured() {
		return yearsTenured;
	}

	public void setYearsTenured(int yearsTenured) {
		this.yearsTenured = yearsTenured;
	}
	
	@Override
	public String getCredentials() {
		return super.getCredentials() + ", salary: " + salary + ", years tenured: " + yearsTenured;
	}
}
