package classes;

public class Rectangle extends Shape {

	//for now, everything is packages and classes. that's it. there is some interface, but we'll go over that later

	//Data Fields
	//if you get an error with the types as Generics, use Integer instead of int (see bottom)
	private Integer base;
	private int height;
	
	private static int noOfRectanges; //not a property of an object or instance but of the class
	
	//if there is a constructor defined, default constructor of no arguments cannot be used
	
	//Constructor
	Rectangle(int h, int base, String color) {
		super(color); //calls calls the constructor of the superclass
		height = h;
		//cannot use base = base; because you are using 2 variables with the same name - one with the formal parameter
		this.base = base;
		//this.color = color;
		noOfRectanges++;
	}
	
	//overload constructor
	Rectangle(int height, int base) {
		this.base = base;
		this.base = base;
		this.color = "Silver";
		noOfRectanges++;
	}
	
	//Methods
	
	public void setHeight(int h) {
		height = h;
	}
	
	public void setBase(int b) {
		base = b;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getBase() {
		return base;
	}
	
	public int perimeter() {
		return 2 * base + 2 * height;
	}
	
	public double area() {
		return base * height;
	}
	
	//overloaded from the other class
	public void setColor(int i) {
		this.setColor("Green");
	}
	
	//overloaded from the other class
	public void setColor(double i) {
		this.setColor("Yellow");
	}
	
	public String m() {
		return "Rectangle";
	}
	
	@Override
	public String getInfo() {
		//System.out.println(super.super.toString()); //error
		return "I am a rectangle of base " + base + " and height " + height + " " + //"and color " + this.getColor();
				super.getInfo();
		
		//cannot call super.toString() for rectangle to get the object hash - need super.super.toString();
		//but this is not something you want to do
	}
	
	//another way to do the same thing:
	/*
	public String toString() {
		return "I am a rectangle of base " + base + " and height " + height + " " + //"and color " + this.getColor();
				super.toString();
	}
	*/
	
	//Integer is a class, int is a primitive type
	public Pair<Integer, Integer> baseAndHeight() {
		return new Pair(this.base, this.height);
	}
	
	public Pair<String, Integer> colorAndBase() {
		return new Pair(this.getColor(), base);
	}
	
	public static void main(String[] args) {
		Rectangle r = new Rectangle(2, 3, "red");
		Rectangle s = new Rectangle(7, 5, "green");
		r.setHeight(2);
		r.setBase(3);

		//cannot just do r.height because it is private - need to access inside the code itself - good programming practice
		System.out.println("The height of r is " + r.getHeight());
		System.out.println("The perimeter is " + r.perimeter());
		System.out.println("The area is " + r.area());

		System.out.println("The perimeter is " + s.perimeter());
		System.out.println("The area is " + s.area());
		
		System.out.println("The number of rectanges created is " + Rectangle.noOfRectanges);
	}
}
