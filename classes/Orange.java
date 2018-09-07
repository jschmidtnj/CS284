package classes;

public class Orange extends Fruit {

	private Integer juciness;

	public Orange(String color, Integer juciness) {
		super(color);
		this.juciness = juciness;
	}

	public Integer getJuciness() {
		return juciness;
	}

	public void setJuciness(Integer juciness) {
		this.juciness = juciness;
	}

}
