package classes;

import java.util.*;

public class MyList<E> {
	// Data Fields
	final static int INIT_CAPACITY = 20; //final = cannot be changed
	private E[] data;
	int capacity;
	int size;

	public MyList() {
		//this.data = new E[]size; //this results in an error for whatever reason
		this.data = (E[]) new Object[INIT_CAPACITY]; //just follow this blindly
		this.capacity = INIT_CAPACITY;
		this.size = 0;
	}
	
	public MyList(int capacity) {
		//this.data = new E[]size; //this results in an error for whatever reason
		this.data = (E[]) new Object[capacity]; //just follow this blindly
		this.capacity = capacity;
		this.size = 0;
	}
	
	private void resize() {
		capacity *= 2;
		data = Arrays.copyOf(data, capacity);
	}

	//O(n)
	public void add(E item) {
		if (size == data.length) {
			// System.exit(1); //program should not just stop running, but should show a
			// message
			// System.out.println("add: list is full"); //not good practice
			//throw new ArrayIndexOutOfBoundsException("add: list is full");
			//got rid of array index out of bounds error
			resize();
		} else {
			data[size] = item;
			size++;
		}
	}
	
	//O(n)
	public void add(E item, int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException("add: index out of bounds");
		} else {
			if (size == data.length) {
				resize();
			}
			for (int i=size; i > index; i--) {
				data[i] = data[i-1];
			}
			data[index] = item;
			size++;
		}
	}
	
	//O(n)
	//worst case index 0
	public void remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("remove: index out of bounds");
		} else {
			for (int i=index; i <size; i++) {
				data[i] = data[i+1];
			}
			size--;
		}
	}

	//O(1)
	public E get(int index) {
		if (index >= size) {
			throw new ArrayIndexOutOfBoundsException("get: index is null");
		} else {
			return data[index];
		}
	}

	public String toString() {
		// used when building large strings - better than "" because Strings are
		// immutable
		StringBuilder s = new StringBuilder();
		s.append('[');
		for (int i = 0; i < size; i++) {
			s.append(data[i].toString());
			if (i != size - 1) {
				s.append(", ");
			}
		}
		s.append(']');
		return s.toString();
	}

	public static void main(String[] args) {
		String s = "hello";
		s = s + "bye"; // there is still a copy of s lying around in the heap (reclaimed by garbage
						// collector eventually
		// but Stringbuilder is better for this reason - Strings are built dynamically

		MyList<Integer> l = new MyList<Integer>(5);
		l.add(1);
		l.add(2);
		l.add(3);
		System.out.println(l);
		// need class type, not primitive type (class types are capitalized), or it
		// results in an error
		MyList<Integer> j = new MyList<Integer>(2);
		System.out.println(j);
		l.add(4);
		l.add(5);
		// l.add(6); //this results in an error without type check
		try {
			l.add(6); // this results in an error without type check
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Could not add 6");
		}
		System.out.println(l);

		MyList<String> l2 = null;
		// l2.add("hello"); //results in an error - null pointer exception

		MyList<Shape> l3 = new MyList<Shape>(10);
		l3.add(new Rectangle(4, 5));
		l3.add(new Circle(4.5));
		l3.add(new Rectangle(2, 3));
		l3.add(new Square(5));
		l3.add(new Circle(3.4));
		System.out.println(l3);

		// System.out.println(l3.get(7)); //returns null now because the rest of the
		// elements are null

		// System.out.println(l3.get(7).toString()); //gets an error because there is no
		// method toString for null
		try {
			System.out.println(l3.get(7));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("get: index is null");
		}
		
		//New day (9/17/18)
		MyList<Integer> l1 = new MyList<Integer>();
		for (int i=0; i < 10; i++) {
			l1.add(i);
		}
		System.out.println(l1);
		l1.add(24,3);
		System.out.println(l1);
		l1.remove(5);
		System.out.println(l1);
	}
}
