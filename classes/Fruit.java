package classes;

//interface is implemented to get the getColor working...
public class Fruit implements Colorable {

	private String color;
	
	Fruit(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
