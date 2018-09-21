package linkedlist;

public class LinkedList<E> {
	private Node<E> head;
	
	private class Node<E>{
		private Node<E> next;
		private E data;

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public LinkedList() {
		this.head = null;
	}

	public String concatenate() {
		return concatenate(this.head);
	}
	
	public String concatenate(Node<E> head) {
		try {
			StringBuilder result = new StringBuilder();
			for (Node<E> current = head; current != null; current = current.next) {
				result.append(current.data);
			}
			return result.toString();
		} catch(Exception e) {
			throw new IllegalArgumentException("bad argument must be a String");
		}
	}
	
	public <E extends Number> Integer summation(Node<E> head) {
		try {
			int result = 0;
			for (Node<E> current = head; current != null; current = current.next) {
				result = result + current.data.intValue();
			}
			return result;
		} catch(Exception e) {
			throw new IllegalArgumentException("bad argument must be an int");
		}
	}
	
	public Node<E> reverse(Node<E> head) {
		Node current = head;
		Node previous = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}
