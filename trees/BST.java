package trees;

public class BST<E extends Comparable<E>> extends BTree<E> {

	// data fields inherited from BTree
	private boolean addOk;

	// Constructor
	BST() {
		super();
	}

	BST(E data) {
		super(data);
	}

	BST(E data, BST<E> left, BST<E> right) {
		super(data, left, right);
	}

	private Boolean find(E data, Node<E> current) {
		if (current == null) {
			return false;
		}
		int comp = current.data.compareTo(data);
		if (comp == 0) {
			return true;
		}
		if (comp < 1) {
			return find(data, current.right);
		}
		return find(data, current.left);
	}

	public Boolean find(E data) {
		return find(data, root);
	}

	public Node<E> add(E item, Node<E> current) {
		if (current == null) {
			addOk = true;
			return new Node<E>(item);
		}
		int comp = current.data.compareTo(item);
		if (comp < 0) {
			current.right = add(item, current.right);
			return current;
		} else if (comp > 0) {
			current.left = add(item, current.left);
			return current;
		} else {
			// item = a node data in tree
			addOk = false;
			return current;
		}
	}

	public Boolean add(E item) {
		root = add(item, root);
		return addOk;
	}

	// works for BST
	private E minimum(Node<E> current) {
		if (current.left == null) {
			return current.data;
		} else {
			return minimum(current.left);
		}
	}

	public E minimum() {
		if (root == null) {
			return null;
		}
		return minimum(root);
	}
	
	public Node<E> maximum(Node<E> current) {
		if (current.right == null) {
			return current;
		} else {
			return maximum(current);
		}
	}
	
	public Node<E> maximum() {
		if (root == null) {
			return null;
		}
		return maximum(root);
	}

	private void remove(E key, Node<E> current) {
		if (current == null) {
			throw new IllegalArgumentException("key not found in bst");
		}
		int currentcomp = current.data.compareTo(key);
		if (currentcomp == 0) {
			if (current.left != null) {
				// traverse down left side and get node to the far right of the left, then
				// delete that and make it's value current
				
			} else {
				current = null;
			}
		}
		int leftelemcomp = current.left.data.compareTo(key);
		if (leftelemcomp < 1) {
			remove(key, current.right);
		}
		remove(key, current.left);
	}

	public void remove(E key) {
		remove(key, root);
	}

	// Methods
	public static void main(String[] args) {
		BST<Integer> leaf1 = new BST<Integer>(12);
		BST<Integer> leaf2 = new BST<Integer>(33);
		BST<Integer> bst = new BST<Integer>(23, leaf1, new BST<Integer>(44, leaf2, new BST<Integer>()));

		System.out.println(bst);

		System.out.println(bst.find(3));
		System.out.println(bst.find(33));
	}
}
