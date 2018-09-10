package classes;

public class Pair<E, F> {
	//what if you don't have ints? define it as Object? Then you lose information about the type.
	//use Generics instead
	//private int first;
	//private Object second;
	
	//generic classes are defined by E and F
	private E first;
	private F second;
	
	Pair(E first, F second) {
		//super();
		//you don't need that super I don't know why it's there
		this.first = first;
		this.second = second;
	}
	
	public E getFirst() {
		return first;
	}
	public void setFirst(E first) {
		this.first = first;
	}
	public F getSecond() {
		return second;
	}
	public void setSecond(F second) {
		this.second = second;
	}
	
	
}
