package homework3;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class IDLList<E> {

	private class Node<E> {
		E data;
		Node<E> next;
		Node<E> prev;

		Node(E elem) {
			this.next = null;
			this.prev = null;
			this.data = elem;
		}

		Node(E elem, Node<E> prev, Node<E> next) {
			this.data = elem;
			this.prev = prev;
			this.next = next;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;
	private ArrayList<Node<E>> indices;

	public IDLList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.indices = new ArrayList<Node<E>>();
	}

	public boolean add(E elem) {
		Node<E> newelem = new Node<E>(elem);
		if (this.size == 0) {
			this.head = newelem;
			this.tail = newelem;
		} else {
			this.head.prev = newelem;
			newelem.next = this.head;
			this.head = newelem;
		}
		this.indices.add(0, newelem);
		this.size++;
		return true;
	}

	public boolean add(int index, E elem) {
		if (this.size == 0 || index > this.size - 1) {
			//throw new IllegalArgumentException("size is 0");
			return false;
		}
		if (index == 0) {
			this.add(elem);
			return true;
		}
		if (index == this.size - 1) {
			return this.append(elem);
		}
		Node<E> indexNode = this.indices.get(index);
		Node<E> newNode = new Node<E>(elem, indexNode.prev, indexNode);
		indexNode.prev.next = newNode;
		indexNode.prev = newNode;
		this.size++;
		this.indices.add(index, newNode);
		return true;
	}

	public boolean append(E elem) {
		if (this.size == 0) {
			return this.add(elem);
		}
		Node<E> newNode = new Node<E>(elem);
		Node<E> currentTail = this.tail;
		currentTail.next = newNode;
		this.tail = newNode;
		this.tail.prev = currentTail;
		this.size++;
		this.indices.add(newNode);
		return true;
	}

	public E get(int index) {
		return this.indices.get(index).data;
	}

	public E getHead() {
		return this.head.data;
	}

	public E getLast() {
		return this.tail.data;
	}

	public int size() {
		return this.size;
	}

	public E remove() {
		if (this.size == 0) {
			throw new IllegalArgumentException("size is 0");
		} else {
			E currentheaddata = this.head.data;
			if (size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			this.size--;
			this.indices.remove(0);
			return currentheaddata;
		}
	}

	public E removeLast() {
		if (this.size == 0) {
			throw new IllegalArgumentException("size is 0");
		} else {
			E currenttaildata = this.tail.data;
			if (size == 1) {
				this.head = null;
				this.tail = null;
			} else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			this.size--;
			this.indices.remove(this.indices.size() - 1);
			return currenttaildata;
		}
	}

	public E removeAt(int index) {
		if (this.size == 0 || index > this.size - 1) {
			throw new IllegalArgumentException("size is 0");
		}
		if (index == 0) {
			return this.remove();
		}
		if (index == this.size - 1) {
			return this.removeLast();
		}
		Node<E> elem = this.indices.get(index);
		E elemdata = elem.data;
		if (elem.next == null) {
			elem.prev.next = null;
		} else {
			elem.prev.next = elem.next;
			elem.next.prev = elem.prev;
		}
		this.size--;
		this.indices.remove(index);
		return elemdata;
	}

	public boolean remove(E elem) {
		if (this.size == 0) {
			//throw new IllegalArgumentException("size is 0");
			return false;
		}
		Node<E> current = this.head;
		int indexcount = 0;
		while (current != null && current.data != elem) {
			current = current.next;
			indexcount++;
		}
		if (current == null) {
			return false;
		}
		if (indexcount == size - 1) {
			this.removeLast();
			return true;
		}
		if (indexcount == 0) {
			this.remove();
			return true;
		}
		current.prev.next = current.next;
		current.next.prev = current.prev;
		size--;
		this.indices.remove(indexcount);
		return true;
	}

	public String toString() {
		Node<E> current = this.head;
		StringBuilder s = new StringBuilder();
		s.append("[");
		while (current != null) {
			s.append(current.data);
			current = current.next;
			if (current != null) {
				s.append(",");
			}
		}
		s.append("]");
		return s.toString();
	}
}
