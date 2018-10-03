package stacks;

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
		if (rear == null) { //queue is empty
			front = rear;
		}
		size++;
		return true;
		//return false if there is a size limit and the limit has been reached
	}
}
