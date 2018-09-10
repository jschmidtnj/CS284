package classes;

public class MyList<E> {
	// Data Fields
	private E[] data;
	int free = 0;

	public MyList(int size) {
		//this.data = new E[]size; //this results in an error for whatever reason
		this.data = (E[]) new Object[size]; //just follow this blindly
		this.free = 0;
	}

	public void add(E item) {
		if (free == data.length) {
			// System.exit(1); //program should not just stop running, but should show a
			// message
			// System.out.println("add: list is full"); //not good practice
			throw new ArrayIndexOutOfBoundsException("add: list is full");
		} else {
			data[free] = item;
			free++;
		}
	}

	public E get(int index) {
		if (index >= free) {
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
		for (int i = 0; i < free; i++) {
			s.append(data[i].toString());
			if (i != free - 1) {
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

	}
}
