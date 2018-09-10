package classes;

public class Square extends Rectangle {
	
	private int base;

	Square(int base, String color) {
		super(base, base, color);
		this.base = base;
	}
	Square(int base) {
		super(base, base, "Red");
		this.base = base;
	}
	
	public String toString() {
		return "I am a square of base " + base + " and color " + this.getColor();
	}
}
