package classes;

import java.lang.Math;

public class Circle extends Shape {

	//Data Fields
	private double radius;
	
	//Constructors
	Circle(double r){
		super("Blue");
		radius = r;
	}
	
	Circle(double r, String color) {
		super(color); //runs the constructor of Shapes
		radius = r;
	}

	public double getRadius() {
		return radius;
	}

	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getCircumference() {
		return 2 * Math.PI * radius;
	}
	
	public String m() {
		return "Circle";
	}
	
	public String toString() {
		return "I am a circle of radius " + radius + ". " + super.toString();
	}
}
