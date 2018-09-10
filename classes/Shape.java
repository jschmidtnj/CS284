package classes;

//abstract = cannot initialize stuff of type shape
//interface is implemented to get the getColor working...
public abstract class Shape implements Colorable {

	// Every object has Object as Superclass, but not really
	// Superclass generally refers to the parent class of whatever node you are
	// talking about
	// Rectangle, Circle => Shape

	// Shape - Datafields: color
	// Rectangle - Datafields: base, height, numberOfRectangles; Circle -
	// Datafields: radius

	// Data fields
	protected String color; // allows this.color in all private classes (you can't use this color in
							// subclasses)

	// Constructor
	/**
	 * Constructs a new shape given a color
	 * 
	 * @param color String color of shape
	 */

	Shape(String color) {
		this.color = color;
	}

	// need this for protected this.color set (See Rectangle Class)
	Shape() {

	}

	// Methods
	/**
	 * This is a java-doc This method returns the color of the shape
	 * 
	 * @return The color of the shape
	 */

	public String getColor() {
		return color;
	}

	/**
	 * This is an example of overloading
	 */
	public void setColor() {
		this.color = "Orange";
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String m() {
		return "Shape";
	}

	// This below results in an error
	/*
	 * @Override public String doesNotExistInSuperClass() { return "Hello"; }
	 */

	/**
	 * The @Override tells Eclipse the method is being over-ridden - it doesn't
	 * change anything otherwise
	 */
	@Override
	public String toString() {
		return "Object info is " + this.getInfo(); // this is a rectangle or a circle so go to getInfo in that class
	}

	public String getInfo() {
		return "Color is " + color;
	}

	public static String testPolymorphism(Shape s) {
		return "polymorphism: " + s.toString();
	}

	public abstract double area(); // do not have to write code for abstract methods
}
