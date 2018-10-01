package stacks;

import java.util.EmptyStackException;

public class StackSLL<E> implements StackInt<E> {

	public class Node<F> {
		// Data Fields for Node
		private F data;
		private Node<F> next;

		public Node(F data) {
			super();
			this.data = data;
		}

		public Node(F data, Node<F> next) {
			super();
			this.data = data;
			this.next = next;
		}

	}

	// Data fields
	private Node<E> top;
	private int size;

	// Constructor
	StackSLL() {
		top = null;
		size = 0;
	}

	public void push(E item) {
		top = new Node<E>(item, top);
		size++;
	}

	public E peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public E pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		E temp = top.data;
		top = top.next;
		size--;
		return temp;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		Node<E> current = top;
		while (current != null) {
			s.append(current.data);
			current = current.next;
			if (current != null) {
				s.append("=>");
			}
		}
		return s.toString();
	}

	public static void main(String[] args) {
		StackSLL<Integer> s = new StackSLL<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println(s);
		System.out.println(s.peek());
		s.pop();
		System.out.println(s);
		
		//stack is an easy way of reversing a string
		//just push everything to a stack, and pop the stack to compare the elements
	}

}
