package quiz3;

/*
 * I pledge my honor that I have abided by the Stevens Honor System.
 * Joshua Schmidt, Anthony Quattrocchi
 */

public class SingleLL<E extends Comparable<E>> {

	public class Node<F> {
		// Data Fields for Node
		private F data;
		private Node<F> next;

		public Node(F data) {
			this.data = data;
		}

		public Node(F data, SingleLL<E>.Node<F> next) {
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
	
	public boolean sorted() {
		Node<E> current = this.head;
		if (size <= 1) {
			return true;
		}
		while (current.next != null) {
			if (current.data.compareTo(current.next.data) > 0) {
				return false;
			}
			current = current.next;
		}
		return true;
	}
	
	public void stutter() {
		Node<E> current = this.head;
		if (size == 0) {
			return;
		}
		while (current != null) {
			Node<E> newNode = new Node<E>(current.data, current.next);
			current.next = newNode;
			current = newNode.next;
			this.size++;
		}
	}

	public static void main(String[] args) {
		SingleLL<Integer> l = new SingleLL<Integer>();

		for (int i = 10; i >= 0; i--) {
			l.add(i);
		}
		System.out.println(l);
		System.out.println(l.sorted());
		SingleLL<Integer> l1 = new SingleLL<Integer>();
		for (int i = 0; i < 10; i++) {
			l1.add(i);
		}
		System.out.println(l1);
		System.out.println(l1.sorted());
		l1.stutter();
		System.out.println(l1);
	}
}
