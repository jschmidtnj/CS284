package homework5;

import java.util.Random;
import java.util.Stack;

public class Treap<E extends Comparable<E>> {

	private static class Node<E> {

		// Data Fields

		public E data; // key for search
		public int priority; // random heap priority
		public Node<E> left;
		public Node<E> right;

		public Node(E data, int priority) {
			this.data = data;
			this.priority = priority;
			left = null;
			right = null;
		}

		public Node<E> rotateRight() {
			if (this.left == null) {
				// cannot rotate around anything so return
				return null;
			}
			Node<E> currentRoot = this;
			Node<E> newRoot = currentRoot.left;
			currentRoot.left = newRoot.right;
			newRoot.right = currentRoot;
			return newRoot;
		}

		public Node<E> rotateLeft() {
			if (this.right == null) {
				// cannot rotate around anything so return
				return null;
			}
			Node<E> currentRoot = this;
			Node<E> newRoot = currentRoot.right;
			currentRoot.right = newRoot.left;
			newRoot.left = currentRoot;
			return newRoot;
		}
	}

	// Data Fields

	private Random priorityGenerator;
	private Node<E> root;

	public Treap() {
		root = null;
		priorityGenerator = new Random();
	}

	public Treap(long seed) {
		root = null;
		priorityGenerator = new Random(seed);
	}

	public Node<E> reheap(Stack<Node<E>> nodeChain) {
		Boolean finished = false;
		System.out.println("starting chain");
		Node<E> newRoot = null;
		while (!(finished)) {
			Node<E> childNode = nodeChain.pop();
			if (nodeChain.isEmpty()) {
				finished = true;
				newRoot = childNode;
			} else {
				Node<E> parentNode = nodeChain.peek();
				if (childNode.priority < parentNode.priority) {
					finished = true;
				} else {
					if (parentNode.left == childNode) {
						// child node on left so rotate right
						System.out.println("rotate right");
						childNode = parentNode.rotateRight();
					} else {
						// child node on right so rotate left
						System.out.println("rotate left");
						childNode = parentNode.rotateLeft();
					}
				}
			}
		}
		return newRoot;
	}

	private boolean add(E key, Node<E> current, Stack<Node<E>> nodeChain) {
		// if greater go left, if less than go right, add when null
		int compcurrent = current.data.compareTo(key);
		if (compcurrent == 0) {
			return false;
		} else if (compcurrent < 1) {
			nodeChain.add(current);
			if (current.right == null) {
				// add node to the right
				Node<E> newNode = new Node<E>(key, priorityGenerator.nextInt());
				current.right = newNode;
				nodeChain.add(newNode);
				return true;
			} else {
				// else go right
				return add(key, current.right, nodeChain);
			}
		} else {
			nodeChain.add(current);
			if (current.left == null) {
				Node<E> newNode = new Node<E>(key, priorityGenerator.nextInt());
				current.left = newNode;
				nodeChain.add(newNode);
				return true;
			} else {
				// else go left
				return add(key, current.left, nodeChain);
			}
		}
	}

	public boolean add(E key) {
		if (root == null) {
			root = new Node<E>(key, priorityGenerator.nextInt());
			return true;
		}
		Stack<Node<E>> nodeChain = new Stack<Node<E>>();
		Boolean result = add(key, root, nodeChain);
		//if (result)
		//	this.root = reheap(nodeChain);
		return result;
	}

	public boolean add(E key, int priority) {
		if (root == null) {
			root = new Node<E>(key, priority);
			return true;
		} else {
			// if greater go left, if less than go right, add when null
			// max heap - root has highest priority
			Node<E> current = root;
			Stack<Node<E>> nodeChain = new Stack<Node<E>>();
			Boolean result = null;
			while (result == null) {
				int compcurrent = current.data.compareTo(key);
				if (compcurrent == 0) {
					result = false;
				} else if (compcurrent < 1) {
					nodeChain.add(current);
					if (current.right == null) {
						// add node to the right
						Node<E> newNode = new Node<E>(key, priority);
						current.right = newNode;
						nodeChain.add(newNode);
						result = true;
					} else {
						// else go right
						current = current.right;
					}
				} else {
					nodeChain.add(current);
					if (current.left == null) {
						Node<E> newNode = new Node<E>(key, priority);
						current.left = newNode;
						nodeChain.add(newNode);
						result = true;
					} else {
						// else go left
						current = current.left;
					}
				}
			}
			//if (result)
			//	this.root = reheap(nodeChain);
			return result;
		}
	}

	private void delete(Node<E> parentNode, Node<E> nodeToDelete) {
		if (parentNode.left == nodeToDelete) {
			// delete from left
			parentNode.left = null;
		} else {
			// delete from right
			parentNode.right = null;
		}
	}

	public boolean delete(E key) {
		if (root == null) {
			return false;
		}
		Stack<Node<E>> path = new Stack<Node<E>>();
		boolean foundNode = findNode(root, key, path);
		if (foundNode == false) {
			return false;
		}
		Node<E> nodeToDelete = path.peek();
		Node<E> parentNode = path.peek();
		while (!(nodeToDelete.left == null && nodeToDelete.right == null)) {
			if (nodeToDelete.left != null && nodeToDelete.right != null) {
				if (nodeToDelete.left.priority > nodeToDelete.right.priority) {
					// rotate the left side first
					nodeToDelete.left.rotateRight();
				} else {
					nodeToDelete.right.rotateLeft();
				}
			} else if (nodeToDelete.left != null) {
				nodeToDelete.left.rotateRight();
			} else if (nodeToDelete.right != null) {
				nodeToDelete.right.rotateLeft();
			}
		}
		// remove Node
		this.delete(parentNode, nodeToDelete);
		return true;
	}

	private boolean findNode(Node<E> current, E key, Stack<Node<E>> path) {
		if (current == null) {
			return false;
		}
		path.add(current);
		int comp = current.data.compareTo(key);
		if (comp == 0) {
			return true;
		}
		if (comp < 1) {
			return findNode(current.right, key, path);
		}
		return findNode(root.left, key, path);
	}

	private Boolean find(Node<E> root, E key) {
		if (root == null) {
			return false;
		}
		int comp = root.data.compareTo(key);
		if (comp == 0) {
			return true;
		}
		if (comp < 1) {
			return find(root.right, key);
		}
		return find(root.left, key);
	}

	public boolean find(E key) {
		if (root == null) {
			return false;
		}
		return find(root, key);
	}

	public String toString(Node<E> current, int i) {
		// print out tree in preorder
		StringBuilder s = new StringBuilder();
		for (int j = 0; j < i; j++) {
			s.append("  ");
		}
		if (current == null) {
			s.append("null");
			return s.toString();
		}
		s.append("(key=" + current.data.toString() + ", priority=" + Integer.toString(current.priority) + ")\n");
		s.append(toString(current.left, i + 1));
		s.append("\n");
		s.append(toString(current.right, i + 1));
		return s.toString();
	}

	public String toString() {
		return toString(root, 0);
	}

	public static void main(String[] args) {
		Treap<Integer> t1 = new Treap<Integer>();
		t1.add(3);
		System.out.println(t1);
		System.out.println(t1.add(3));
		System.out.println(t1.add(7));
		System.out.println(t1.add(4));
		System.out.println(t1);
		// System.out.println(t1.add(5));
		System.out.println("adding 4");
		System.out.println(t1.add(4, 363636));
		System.out.println(t1);
		System.out.println(t1.add(5, 999999999));
		System.out.println(t1);
	}

}