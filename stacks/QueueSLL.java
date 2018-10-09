package stacks;

import java.util.NoSuchElementException;

public class QueueSLL<E> {

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

	private Node<E> front;
	private Node<E> rear;
	private int size;

	QueueSLL() {
		front = null;
		rear = null;
		size = 0;
	}

	public boolean offer(E item) {
		rear = new Node<E>(item, rear);
		if (front == null) { //queue is empty
			front = rear;
		}
		size++;
		return true;
		//return false if there is a size limit and the limit has been reached
	}
	
	public E element() {
		//returns item at the head of the queue
		if (size == 0) {
			throw new NoSuchElementException();
		}
		return front.data;
	}
	
	//QUEUE
	//  rear ->        -> front
	//goes into once side (the rear), goes out from another side (the front) (coffee shop served in front, goes into line at rear)
	
	public E remove() {
		//pulls the item out of the stack
		if (size == 0) {
			throw new NoSuchElementException();
		}
		E elemdata = this.element();
		if (size == 1) {
			front = rear = null;
		} else {
			Node<E> current = rear;
			while (current.next != front) {
				current = current.next;
			}
			current.next = null;
			front = current;
		}
		size--;
		return elemdata;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		Node<E> current = rear;
		while (current != null) {
			s.append(current.data);
			current = current.next;
			if (current != null) {
				s.append("=>");
			}
		}
		s.append("]");
		return s.toString();
	}
	
	public static void main(String[] args) {
		QueueSLL<Integer> q1 = new QueueSLL<Integer>();
		for (int i=0; i<5; i++) {
			q1.offer(i);
		}
		System.out.println(q1);
		q1.remove();
		System.out.println(q1);
		q1.remove();
		q1.remove();
		System.out.println(q1);
		q1.remove();
		q1.remove();
		System.out.println(q1);
	}
}
