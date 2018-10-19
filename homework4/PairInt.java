package homework4;

//import java.lang.ClassCastException;

public class PairInt {

	private int x;
	private int y;
	
	PairInt(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object p) {
		PairInt theObject;
		try {
			theObject = (PairInt)p;
		} catch (Exception e) {
			//throw new ClassCastException("Error casting to PairInt");
			return false;
		}
		if (theObject.x == this.x && theObject.y == this.y) {
			return true;
		} else {
			return false;
		}
	}
	
	public PairInt copy() {
		return new PairInt(this.x, this.y);
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("(");
		result.append(Integer.toString(this.x));
		result.append(",");
		result.append(Integer.toString(this.y));
		result.append(")");
		return result.toString();
	}
	
	public static void main(String[] args) {
		PairInt test1 = new PairInt(3,4);
		int test2 = 3;
		System.out.println(test1.equals(test2));
		PairInt test3 = new PairInt(3,4);
		System.out.println(test1.equals(test3));
		PairInt test4 = new PairInt(2,4);
		System.out.println(test1.equals(test4));
	}
}
