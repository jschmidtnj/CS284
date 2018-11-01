package homework5;

import java.util.Random;
import java.util.Stack;

public class OldTreap<E extends Comparable<E>> {

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

	public OldTreap() {
		root = null;
		priorityGenerator = new Random();
	}

	public OldTreap(long seed) {
		root = null;
		priorityGenerator = new Random(seed);
	}

	private Node<E> reheap(Stack<Node<E>> nodeChain) {
		Boolean finished = false;
		Node<E> newRoot = null;
		Node<E> childNode = null;
		Node<E> oldparentNode = null;
		Node<E> parentNode = null;
		Node<E> grandparentNode = null;
		while (!(finished)) {
			childNode = nodeChain.pop();
			System.out.println(childNode.priority);
			if (nodeChain.isEmpty()) {
				finished = true;
			} else {
				parentNode = oldparentNode = nodeChain.pop();
				if (childNode.priority < parentNode.priority) {
					System.out.println("priority is less");
					if (nodeChain.isEmpty()) {
						newRoot = parentNode;
						finished = true;
					} else {
						grandparentNode = nodeChain.peek();
						newRoot = grandparentNode;
					}
				} else {
					if (parentNode.left == childNode) {
						// child node on left so rotate right
						System.out.println("rotate right");
						parentNode = parentNode.rotateRight();
					} else {
						// child node on right so rotate left
						System.out.println("rotate left");
						parentNode = parentNode.rotateLeft();
					}
					if (nodeChain.isEmpty()) {
						newRoot = parentNode;
						finished = true;
					} else {
						grandparentNode = nodeChain.peek();
						if (grandparentNode.right == oldparentNode) {
							grandparentNode.right = parentNode;
						} else {
							grandparentNode.left = parentNode;
						}
						if (grandparentNode.priority >= parentNode.priority) {
							newRoot = grandparentNode;
						} else {
							System.out.println("flip grandparent and parent");
							if (grandparentNode.right == parentNode) {
								System.out.println("on right so rotate left");
								newRoot = grandparentNode.rotateLeft();
							} else {
								System.out.println("on left so rotate right");
								newRoot = grandparentNode.rotateRight();
							}
						}
					}
				}
			}
		}
		return newRoot;
	}

	private boolean add(E key, Node<E> current, Stack<Node<E>> nodeChain, int maxPriority) {
		// if greater go left, if less than go right, add when null
		int compcurrent = current.data.compareTo(key);
		if (compcurrent == 0) {
			return false;
		} else if (compcurrent < 1) {
			nodeChain.add(current);
			if (current.right == null) {
				// add node to the right
				Node<E> newNode = new Node<E>(key, priorityGenerator.nextInt(maxPriority));
				current.right = newNode;
				nodeChain.add(newNode);
				return true;
			} else {
				// else go right
				return add(key, current.right, nodeChain, maxPriority);
			}
		} else {
			nodeChain.add(current);
			if (current.left == null) {
				Node<E> newNode = new Node<E>(key, priorityGenerator.nextInt(maxPriority));
				current.left = newNode;
				nodeChain.add(newNode);
				return true;
			} else {
				// else go left
				return add(key, current.left, nodeChain, maxPriority);
			}
		}
	}

	public boolean add(E key) {
		int maxPriority = 100;
		if (root == null) {
			root = new Node<E>(key, priorityGenerator.nextInt(maxPriority));
			return true;
		}
		Stack<Node<E>> nodeChain = new Stack<Node<E>>();
		Boolean result = add(key, root, nodeChain, maxPriority);
		if (result) {
			this.root = reheap(nodeChain);
		}
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
			Boolean result = false;
			Boolean foundresult = false;
			while (foundresult == false) {
				//System.out.println(current.data);
				int compcurrent = current.data.compareTo(key);
				if (compcurrent == 0) {
					result = false;
					foundresult = true;
				} else if (compcurrent < 1) {
					nodeChain.add(current);
					if (current.right == null) {
						// add node to the right
						Node<E> newNode = new Node<E>(key, priority);
						current.right = newNode;
						nodeChain.add(newNode);
						result = true;
						foundresult = true;
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
						foundresult = true;
					} else {
						// else go left
						current = current.left;
					}
				}
			}
			if (result) {
				this.root = reheap(nodeChain);
			}
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
		@SuppressWarnings("unchecked")
		Stack<Node<E>> copypath = (Stack<Node<E>>)path.clone();
		Node<E> nodeToDelete = path.pop();
		Node<E> parentNode = null;
		Boolean hasParent = true;
		Node<E> newRoot = null;
		if (path.isEmpty()) {
			//System.out.println("no parent");
			hasParent = false;
		} else {
			parentNode = path.pop();
		}
		Boolean hasgrandparent = true;
		Node<E> grandparentNode = null;
		if (path.isEmpty()) {
			//System.out.println("no grandparent");
			hasgrandparent = false;
		} else {
			grandparentNode = path.pop();
		}
		while (!(nodeToDelete.left == null && nodeToDelete.right == null)) {
			if (nodeToDelete.left != null && nodeToDelete.right != null) {
				if (nodeToDelete.left.priority > nodeToDelete.right.priority) {
					// rotate the left side first
					nodeToDelete.left.rotateRight();
				} else {
					nodeToDelete.right.rotateLeft();
				}
			} else {
				//System.out.println("update parent & rotate");
				if (nodeToDelete.left != null) {
					//System.out.println("rotate right");
					copypath.add(nodeToDelete.left);
					parentNode = nodeToDelete.rotateRight();
					//System.out.println(parentNode.data);
					nodeToDelete = parentNode.right;
					//System.out.println(nodeToDelete.data);
				} else if (nodeToDelete.right != null) {
					//System.out.println("rotate left");
					copypath.add(nodeToDelete.right);
					parentNode = nodeToDelete.rotateLeft();
					nodeToDelete = parentNode.left;
				}
				if (!(hasParent)) {
					if (newRoot == null) {
						newRoot = parentNode;
						if (newRoot.right == nodeToDelete) {
							newRoot.right = null;
						} else {
							newRoot.left = null;
						}
					}
					parentNode = null;
				}
				else if (!(hasgrandparent) && nodeToDelete.left == null && nodeToDelete.right == null) {
					// this only occurs if key is in the middle of a three - level tree
					grandparentNode = root;
					hasgrandparent = true;
				}
				if (hasgrandparent) {
					//System.out.println("update grandparent");
					if (grandparentNode.right == nodeToDelete) {
						grandparentNode.right = parentNode;
					} else {
						grandparentNode.left = parentNode;
					}
				}
			}
		}
		// remove Node
		//System.out.println(parentNode.data);
		//System.out.println(nodeToDelete.data);
		if (!(hasParent)) {
			this.root = newRoot;
		} else {
			this.delete(parentNode, nodeToDelete);
		}
		this.root = reheap(copypath);
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
		return findNode(current.left, key, path);
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
		/*
		OldTreap<Integer> t1 = new OldTreap<Integer>();
		//System.out.println(t1);
		System.out.println(t1.add(3, 2));
		//System.out.println(t1);
		System.out.println(t1.add(7, 6));
		//System.out.println(t1.root.data);
		//System.out.println(t1);
		System.out.println(t1.add(4, 7));
		System.out.println(t1.add(5, 7));
		//System.out.println(t1);
		//System.out.println(t1.find(1));
		//System.out.println(t1.delete(1));
		System.out.println(t1);
		System.out.println(t1.delete(5));
		System.out.println(t1);
		t1.delete(5);
		System.out.println(t1);
		t1.delete(7);
		System.out.println(t1);
		t1.delete(4);
		System.out.println(t1);
		t1.delete(3);
		System.out.println(t1);
		// System.out.println(t1.add(5));
		System.out.println("adding 4");
		System.out.println(t1.add(4));
		System.out.println(t1);
		System.out.println(t1.add(5));
		System.out.println(t1.add(7));
		System.out.println(t1.add(15));
		System.out.println(t1.add(12));
		System.out.println(t1);
		System.out.println(t1.find(5));
		System.out.println(t1.find(1));
		*/
		OldTreap<Integer> testTree = new OldTreap<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		System.out.println(testTree);
		//testTree.add(7, 26);
		//System.out.println(testTree);
	}

}