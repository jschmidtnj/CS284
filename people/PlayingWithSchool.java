package people;

public class PlayingWithSchool {

	public static void main(String[] args) {
		// create student
		Student s1 = new Student("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646);
		System.out.println("Name of s1 is " + s1.getName());
		System.out.println("Age of s1 is " + s1.getAge());
		System.out.println("Address of s1 is " + s1.getAddress());
		System.out.println("CWID of s1 is " + s1.getCwid());
		System.out.println(s1.getCredentials());
		//Person s2 = new Student("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646);
		//System.out.println(s2.getCwid());
		

		// create undergrad
		Undergraduate u1 = new Undergraduate("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646, 4.0);
		System.out.println("Name of u1 is " + u1.getName());
		System.out.println("Age of u1 is " + u1.getAge());
		System.out.println("Address of u1 is " + u1.getAddress());
		System.out.println("CWID of u1 is " + u1.getCwid());
		System.out.println("GPA of u1 is " + u1.getGpa());
		System.out.println(u1.getCredentials());

		// create undergrad with overload
		//use Student u2 = new Undergraduate("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646, 4.0);
		//but then this doesn't work because it's a student at runtime type check. so overloading works, but doesn't use all the methods...
		//System.out.println("GPA of u2 is " + u2.getGpa());
		Undergraduate u2 = new Undergraduate("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646, 4.0);
		System.out.println("Name of u2 is " + u2.getName());
		System.out.println("Age of u2 is " + u2.getAge());
		System.out.println("Address of u2 is " + u2.getAddress());
		System.out.println("CWID of u2 is " + u2.getCwid());
		System.out.println("GPA of u2 is " + u2.getGpa());
		System.out.println(u2.getCredentials());

		// create graduate
		Graduate g1 = new Graduate("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646, 4.0, "Computer Engineering");
		System.out.println("Name of g1 is " + g1.getName());
		System.out.println("Age of g1 is " + g1.getAge());
		System.out.println("Address of g1 is " + g1.getAddress());
		System.out.println("CWID of g1 is " + g1.getCwid());
		System.out.println("GPA of g1 is " + g1.getGpa());
		System.out.println("Major of g1 is " + g1.getMajor());
		System.out.println(g1.getCredentials());

		// create faculty
		Faculty f1 = new Faculty("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646);
		System.out.println("Name of f1 is " + f1.getName());
		System.out.println("Age of f1 is " + f1.getAge());
		System.out.println("Address of f1 is " + f1.getAddress());
		System.out.println("Faculty id of f1 is " + f1.getFacultyid());
		System.out.println(f1.getCredentials());

		// create non-tenured faculty
		NonTenured nt1 = new NonTenured("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646, 99999);
		System.out.println("Name of nt1 is " + nt1.getName());
		System.out.println("Age of nt1 is " + nt1.getAge());
		System.out.println("Address of nt1 is " + nt1.getAddress());
		System.out.println("Faculty id of nt1 is " + nt1.getFacultyid());
		System.out.println("Salary of nt1 is " + nt1.getSalary());
		System.out.println(nt1.getCredentials());

		// create tenured faculty
		Tenured t1 = new Tenured("Josh", 19, "1 Castle Point Terr Hoboken NJ 07030", 10428646, 99999, 5);
		System.out.println("Name of t1 is " + t1.getName());
		System.out.println("Age of t1 is " + t1.getAge());
		System.out.println("Address of t1 is " + t1.getAddress());
		System.out.println("Faculty id of t1 is " + t1.getFacultyid());
		System.out.println("Salary of nt1 is " + t1.getSalary());
		System.out.println("Years tenured of t1 is " + t1.getYearsTenured());
		System.out.println(t1.getCredentials());
		
		Person[] people = new Person[3];
		people[0] = t1;
		people[1] = f1;
		people[2] = nt1;
		
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].getName());
		}
	}
}
