package people;

public class Person {
	
	//Data fields
	private String name;
	private int age;
	private String address;
	
	//"protected" used in package, not just class
	//protected int test;
	
	/**
	 * Constructor for a Person, which has the following parameters:
	 * @param name String
	 * @param age int
	 * @param address String
	 */
	Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	/**
	 * Getter for name
	 * @return name String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for age
	 * @return age String
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Setter for age
	 * @param age int
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Getter for address
	 * @return address String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for address
	 * @param address String
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * get the credentials override
	 * @return String
	 */
	public String getCredentials() {
		return "name: " + name + ", age: " + age + ", address: " + address;
	}
	
	public static void main(String[] args) {
		//Create a new person Josh, and get his info
		Person p1 = new Person("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030");
		System.out.println("Name of p1 is " + p1.getName());
		System.out.println("Age of p1 is " + p1.getAge());
		System.out.println("Address of p1 is " + p1.getAddress());
		System.out.println(p1.getCredentials());
		/*
		 * Create a second new person Annika, and print her info
		 */
		Person p2 = new Person("Annika", 17, "71 Valleyview Rd Watchung NJ 07069");
		System.out.println("Name of p2 is " + p2.getName());
		System.out.println("Age of p2 is " + p2.getAge());
		System.out.println("Address of p2 is " + p2.getAddress());
		System.out.println(p2.getCredentials());
	}
	
}
