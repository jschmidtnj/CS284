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
			previous.next = next;
			return current.data;
		} else {
			//System.out.println("no next");
			if (previous != null) {
				previous.next = null;
				return previous.data;
			} else {
				//System.out.println("no previous");
				head = null;
				return null;
			}
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
		SingleLL<Integer> l2 = new SingleLL<Integer>();
		l2.add(1);
		System.out.println(l2);
		System.out.println(l2.remove(0));
		System.out.println(l2);
		l2.add(1);
		l2.add(2);
		System.out.println(l2);
		System.out.println(l2.remove(1));
		System.out.println(l2);
		System.out.println(l2.remove(0));
		System.out.println(l2);
	}
}
