package classes;

import java.util.Arrays;

public class PlayingWithShapes {

	public static void myPrint(Shape s) {
		// runtime class of s is either rectangle or circle, which is why s.m() works
		System.out.println(s.toString() + " type: " + s.m());
	}

	//Shape replaced with Colorable (interface) to work with Fruit also
	public static void printColors(Colorable[] ss) {
		for (Colorable s : ss) {
			System.out.println(s.getColor());
		}
	}

	public static void main(String[] args) {
		Rectangle r = new Rectangle(3, 5, "Blue");
		Circle c = new Circle(3.5, "Red");
		Circle c2 = new Circle(3.5);

		System.out.println("The height of r is " + r.getHeight());
		System.out.println("The color of r is " + r.getColor());
		System.out.println("The radius of c is " + c.getRadius());
		System.out.println("Circumference of c2: " + c2.getCircumference());
		System.out.println("The color of c2 is " + c2.getColor());
		System.out.println("Area of c2: " + c2.area());

		System.out.println(r);
		// Lots of overloading here
		r.setColor();
		System.out.println(r);
		r.setColor("Purple");
		System.out.println(r);
		r.setColor(3);
		System.out.println(r);
		r.setColor(5.0);
		System.out.println(r);
		System.out.println(c);

		// overload constructor
		System.out.println("Overload Constructor\n\n\n");
		Rectangle r2 = new Rectangle(3, 7);
		System.out.println(r2);
		r2.setColor("Red");
		myPrint(r2);
		myPrint(c);

		// testing overriding with AClass and AnotherClass
		AClass obj = new AnotherClass();
		System.out.println(obj.setValue(3));

		AnotherClass obj2 = new AnotherClass();
		System.out.println(obj2.setValue(3.0));

		// Error
		// AClass obj3 = new AnotherClass();
		// System.out.println(obj3.setValue(3.0));

		/**
		 * Override = same name same parameters. Overload = same name different
		 * parameters. SetValue is overloaded, readFile is overridden
		 */

		// polymorphism = putting a circle in the argument as shape
		System.out.println(Shape.testPolymorphism(c2));
		System.out.println(Shape.testPolymorphism(r));

		Shape[] ss = new Shape[4];
		ss[0] = c;
		ss[1] = c2;
		ss[2] = r;
		ss[3] = new Square(3, "Blue");

		// Shape s = new Shape(); - now abstract

		for (Shape s : ss) {
			System.out.println(s + ", area: " + s.area());
		}

		int[] a = new int[3];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		System.out.println(Arrays.toString(a));

		System.out.println(r.baseAndHeight().getFirst());
		System.out.println(r.colorAndBase().getFirst());

		printColors(ss);
		
		//now for Fruit for whagtever reason
		
		Fruit[] fs = new Fruit[3];
		fs[0] = new Apple("Red", 3);
		fs[1] = new Orange("Orange", 2);
		fs[2] = new Apple("Green", 4);
		
		//error without interface - need interface so your formal parameter does not have type problems
		System.out.println("\n");
		printColors(fs);
		
		//interface is to allow for cross-cut hierarchy - so you do not have to add a class to the Object class, or create a new super parent
		//class. works with things completely unrelated

	}
}
