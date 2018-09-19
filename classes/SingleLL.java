package classes;

public class SingleLL<E> {

	public class Node<F> {
		// Data Fields for Node
		private F data;
		private Node<F> next;

		public Node(F data) {
			super();
			this.data = data;
		}

		public Node(F data, SingleLL<E>.Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	// Data fields for SingleLL

	private Node<E> head;
	private int size = 0;
	
	public int getSize() {
		return this.size;
	}

	SingleLL() {
		head = null;
		size = 0;
	}

	public void add(E item) {
		head = new Node<E>(item, head);
		size++;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append('[');
		Node<E> current = head;
		// keep running until you reach a node with no link to another node
		while (current != null) {
			s.append(current.data.toString());
			current = current.next;
			if (current != null) {
				s.append(',');
			}
		}
		s.append(']');
		return s.toString();
	}

	public E get(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("get: index not found");
		}
		Node<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.data;
	}

	public void removeFirst() {
		if (head == null) {
			throw new IllegalArgumentException("removefirst: cannot remove from empty list");
		}
		head = head.next;
		size--;
	}

	public Boolean member(E item) {
		Node<E> current = head;
		// comparison from left to right - short circuit vs long circuit
		// just & or | result in long circuit, && and || result in short circuit
		while (current != null && current.data != item) { // if these two are switched, you get a null pointer exception
															// (example of short circuit)
			current = current.next;
		}
		return current != null; // do it this way instead of if else statements (duh)
	}

	public void add(E item, int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("add: cannot add at this index");
		}
		// operation reused at beginning
		if (index == 0) {
			this.add(item);
		} else {
			Node<E> previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
			}
			Node<E> next = previous.next;
			Node<E> newNode = new Node<E>(item, next);
			previous.next = newNode;
			size++;
		}
	}

	public E remove(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("get: index not found");
		}
		Node<E> current = head;
		Node<E> previous = null;
		for (int i = 0; i < index; i++) {
			if (i == index - 1) {
				previous = current;
			}
			current = current.next;
		}
		Node<E> next = current.next;
		size--;
		if (next != null) {
			if (previous != null) {
				previous.next = next;
				return current.data;
			} else {
				head = next;
				return next.data;
			}
		} else {
			// System.out.println("no next");
			if (previous != null) {
				previous.next = null;
				return previous.data;
			} else {
				// System.out.println("no previous");
				head = null;
				return null;
			}
		}
	}
	
	public E hisremove(int index) {
		if (index < 0 || index > size - 1) {
			throw new ArrayIndexOutOfBoundsException("get: index not found");
		}
		if (index == 0) {
			E temp = head.data;
			head = head.next;
			size--;
			return temp;
		} else {
			Node<E> current = head;
			for (int i=0; i<index-1; i++) {
				current = current.next;
			}
			//current points to index at index - 1
			E temp = current.next.data;
			current.next = current.next.next;
			size--;
			return temp;
		}
	}
	
	/**
	 * indicates whether the list l2 is included in the recipient list
	 * list l2 included in l1 if every element of l2 is a member of l1
	 * @param l2
	 * @return
	 */
	public Boolean included(SingleLL<E> l2) {
		int l2size = l2.getSize();
		if (l2size <= this.getSize()) {
			Node<E> current = l2.head;
			for (int i=0; i < l2size; i++) {
				if (!(this.member(current.data))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		SingleLL<Integer> l = new SingleLL<Integer>();

		for (int i = 0; i < 10; i++) {
			l.add(i);
		}

		System.out.println(l);
		System.out.println(l.get(4));
		l.removeFirst();
		System.out.println(l);
		System.out.println(l.remove(3));
		System.out.println(l);
		System.out.println(l.member(2));
		System.out.println(l.member(12));
		l.add(24, 0);
		System.out.println(l);
		l.add(50, 7);
		System.out.println(l);
		//l.add(24, 30); //error
		l.add(40, 10);
		System.out.println(l);
		SingleLL<Integer> l2 = new SingleLL<Integer>(); l2.add(1);
		System.out.println(l2); 
		System.out.println(l2.remove(0));
		System.out.println(l2); 
		l2.add(1); 
		l2.add(2); 
		System.out.println(l2);
		System.out.println(l2.remove(0)); 
		System.out.println(l2);
		System.out.println(l2.remove(0)); 
		System.out.println(l2);
		l2.add(1); 
		l2.add(2);
		l2.add(3);
		l2.add(5);
		l2.add(7);
		l2.add(3);
		System.out.println(l2);
		System.out.println(l2.hisremove(0)); 
		System.out.println(l2);
		System.out.println(l2.hisremove(4)); 
		System.out.println(l2);
		
	}
}
