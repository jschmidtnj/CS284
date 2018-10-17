package homework4;

public class PairInt {

	private int first;
	private int second;
	
	PairInt(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("(");
		result.append(Integer.toString(this.first));
		result.append(",");
		result.append(Integer.toString(this.second));
		result.append(")");
		return result.toString();
	}
}
