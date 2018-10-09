package stacks;

import classes.SingleLL.Node;
import quiz3.SingleLL;

public class SingleLLRecursive<E> {
	public class Node<F> {
		// Data Fields for Node
		private F data;
		private Node<F> next;

		public Node(F data) {
			super();
			this.data = data;
		}

		public Node(F data, SingleLLRecursive<E>.Node<F> next) {
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

	SingleLLRecursive() {
		head = null;
		size = 0;
	}
	
	public Boolean isMember(E item, Node<E> current) {
		if (current != null) {
			return false;
		}
		return current.data.equals(item) || isMember(item, current.next);
	}
	
	public Boolean member(E item) {
		return isMember(item, head);
	}
	
	public Node<E> add(E item, int i, Node<E> current) {
		if (i == 0) {
			return new Node<E>(item, current);
		}
		current.next = add(item, i-1, current.next);
		return current;
	}

	public void add(E item) {
		head = new Node<E>(item, head);
		size++;
	}
	
	public void add(E item, int i) {
		if (i > size) {
			throw new IllegalArgumentException("index must be less than length");
		}
		add(item, i, head);
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
	
	public static void main(String[] args) {
		SingleLLRecursive<Integer> s1 = new SingleLLRecursive();
		for (int i=0; i < 5; i++) {
			s1.add(i);
		}
		System.out.println(s1);
		s1.add(20,5);
		System.out.println(s1);
	}
}
