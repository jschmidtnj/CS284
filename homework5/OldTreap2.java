package homework5;

import java.util.Random;

/**
 * OldTreap2 Class
 * 
 * @author Joshua Schmidt I pledge my honor that I have abided by the Stevens
 *         Honor System
 * @param <E> datatype for OldTreap2
 */

public class OldTreap2<E extends Comparable<E>> {

	/**
	 * OldTreap2 Node class
	 * 
	 * @param <E>
	 */

	private static class Node<E> {

		// Data fields

		public E data;
		public int priority;
		public Node<E> left;
		public Node<E> right;

		/**
		 * constructor for OldTreap2 Node
		 * 
		 * @param data is data in Node
		 * @param      priority, priority of the node
		 */
		public Node(E data, int priority) {
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}

		/**
		 * rotates node to right
		 * 
		 * @return the new root for rotated node
		 */
		private Node<E> rotateRight() {
			Node<E> newroot = this.left;
			this.left = newroot.right;
			newroot.right = this;
			return newroot;
		}

		/**
		 * rotates node to left
		 * 
		 * @return the new root for rotated node
		 */
		private Node<E> rotateLeft() {
			Node<E> newroot = this.right;
			this.right = newroot.left;
			newroot.left = this;
			return newroot;
		}

	}

	// Data fields

	private Node<E> root;
	private Random priorityGenerator;

	/**
	 * constructor for OldTreap2 (no seed)
	 */
	public OldTreap2() {
		this.root = null;
		this.priorityGenerator = new Random();
	}

	/**
	 * constructor for OldTreap2 (wuth seed seed)
	 * 
	 * @param seed (long)
	 */
	public OldTreap2(long seed) {
		root = null;
		priorityGenerator = new Random(seed);
	}

	/**
	 * reheap the OldTreap2 so it is in the form of a max heap
	 * 
	 * @param          key, Node data
	 * @param current  - root of current OldTreap2
	 * @param priority - Node priority
	 * @return New root Node after addition
	 */
	private Node<E> reheap(E key, int priority, Node<E> current) {
		if (current == null) {
			return new Node<E>(key, priority);
		}
		int comp = key.compareTo(current.data);
		if (comp < 0) {
			current.left = reheap(key, priority, current.left);
			if (current.left.priority > current.priority) {
				current = current.rotateRight();
			}

		} else if (comp > 0) {
			current.right = reheap(key, priority, current.right);
			if (current.right != null && current.right.priority > current.priority) {
				current = current.rotateLeft();
			}
		} else {
			return null;
		}
		return current;
	}

	/**
	 * add new Node with given priority
	 * 
	 * @param key, the data in the node
	 * @param priority, the priority of the node
	 * @return true if it can be added and false otherwise
	 */
	public boolean add(E key, int priority) {
		if (this.find(key)) {
			return false;
		}
		Node<E> result = reheap(key, priority, root);
		root = result;
		return true;
	}

	/**
	 * add a new Node with random priority
	 * 
	 * @param key - data in Node
	 * @return true if added else false
	 */
	public boolean add(E key) {
		// makes priorities between 0 and 100
		int numPriorities = 100;
		return add(key, priorityGenerator.nextInt(numPriorities));
	}

	/**
	 * helper function for delete that locates the soon to be deleted node
	 * 
	 * @param key, the data of the node to be deleted
	 * @param current, root of the current OldTreap2
	 * @return the new root after deletion of the node
	 */
	private Node<E> delete(E key, Node<E> current) {
		if (current != null) {
			int comp = key.compareTo(current.data);
			if (comp == 0) {
				if (current.left == null && current.right == null) {
					current = null;
				} else if (current.left == null) {
					return current.left;
				} else if (current.right == null) {
					return current.right;
				} else if (current.left.priority > current.right.priority) {
					current = delete(key, current.rotateRight());
				} else {
					current = delete(key, current.rotateLeft());
				}
			} else if (comp > 0) {
				current.right = delete(key, current.right);
			} else {
				current.left = delete(key, current.left);
			}
		}
		return current;
	}
	
	/**
	 * deletes a node from the OldTreap2
	 * 
	 * @param key, data of the node to be deleted
	 * @return true if it can be deleted and false if not
	 */
	public boolean delete(E key) {
		if (this.find(key)) {
			root = delete(key, root);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * finds if Node is in a tree
	 * 
	 * @param current - current Node root of OldTreap2
	 * @param key     - key for Node to be found
	 * @return true if found, else false
	 */
	private boolean find(Node<E> current, E key) {
		while (current != null) {
			int comp = key.compareTo(current.data);
			if (comp > 0) {
				current = current.right;
			} else if (comp < 0) {
				current = current.left;
			} else {
				// the key is found
				return true;
			}
		}
		return false;
	}

	/**
	 * finds Node with given key
	 * 
	 * @param key - data of Node that needs to be found
	 * @return true if found, else false
	 */
	public boolean find(E key) {
		return find(root, key);
	}

	/**
	 * creates a String for the OldTreap2
	 * 
	 * @param current - the current root Node
	 * @param level   - current level of the OldTreap2
	 * @return String OldTreap2
	 */
	private String toString(Node<E> current, int level) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < level; i++) {
			result.append("  ");
		}
		if (current == null) {
			result.append("null");
		} else {
			result.append("(key=" + current.data.toString() + ", priority=" + Integer.toString(current.priority) + ")");
			result.append("\n");
			result.append(toString(current.left, level + 1));
			result.append("\n");
			result.append(toString(current.right, level + 1));
		}
		return result.toString();

	}

	/**
	 * creates a OldTreap2 String
	 * 
	 * @return String-ed OldTreap2
	 */
	public String toString() {
		return toString(root, 0);
	}

	public static void main(String[] args) {
		OldTreap2<Integer> testTree = new OldTreap2<Integer>();
		testTree.add(4, 19);
		testTree.add(2, 31);
		testTree.add(6, 70);
		testTree.add(1, 84);
		testTree.add(3, 12);
		testTree.add(5, 83);
		testTree.add(7, 26);
		System.out.println(testTree);
		System.out.println(testTree.add(5, 7));
		System.out.println(testTree);
		System.out.println(testTree.add(9, 7));
		System.out.println(testTree);
		System.out.println(testTree.find(1));
		System.out.println("test");
		System.out.println(testTree.delete(1));
		System.out.println(testTree);
	}
}
