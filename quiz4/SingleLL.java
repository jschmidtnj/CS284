package quiz4;

/*
 * I pledge my honor that I have abided by the Stevens Honor System.
 * Joshua Schmidt, Scott Borgstedt
 */

public class SingleLL<E> {

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

	public void addLast(E item) {
		if (this.size == 0) {
			this.add(item);
			return;
		}
		Node<E> newNode = new Node<E>(item);
		Node<E> current = this.head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		this.size++;
	}

	public SingleLL<Pair<E, Integer>> compress() {
		SingleLL<Pair<E, Integer>> newList = new SingleLL<Pair<E, Integer>>();
		if (this.size == 0) {
			return newList;
		}
		Node<E> current = this.head;
		E previousData = current.data;
		Integer datacount = new Integer(-1);
		while (current != null) {
			datacount++;
			if (!(previousData.equals(current.data))) {
				Pair<E, Integer> newData = new Pair<E, Integer>(previousData, datacount);
				newList.addLast(newData);
				previousData = current.data;
				datacount = 0;
			}
			current = current.next;
		}
		Pair<E, Integer> newData = new Pair<E, Integer>(previousData, datacount + 1);
		newList.addLast(newData);
		return newList;
	}

	public Boolean hasCycle() {
		Node<E> slow = this.head;
		Node<E> fast = this.head;
		while (fast != null && slow != null) {
			slow = slow.next;
			try {
				fast = fast.next.next;
			} catch (NullPointerException e) {
				return false;
			}
			if (fast == slow) {
				return true;
			}
		}
		return false;
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

	public static void main(String[] args) {
		SingleLL<Integer> l = new SingleLL<Integer>();

		for (int i = 10; i >= 0; i--) {
			l.add(i);
		}
		System.out.println(l);
		l.addLast(3);
		l.add(3, 3);
		System.out.println(l);
		System.out.println(l.compress());
		l.add(3, 3);
		System.out.println(l.compress());
		l.addLast(3);
		System.out.println(l.compress());
		SingleLL<Integer> l1 = new SingleLL<Integer>();
		System.out.println(l1.compress());
		l1.add(3);
		System.out.println(l1);
		System.out.println(l1.compress());
		l1.add(3);
		System.out.println(l1);
		System.out.println(l1.compress());

		System.out.println(l1.hasCycle());
		// build a list
		SingleLL<Integer> l2 = new SingleLL<Integer>();
		for (int i = 0; i < 5; i++) {
			l2.add(i);
		}
		// create a loop
		l2.head.next.next.next.next = l2.head;
		// test your code
		System.out.println(l2.hasCycle());
	}
}
