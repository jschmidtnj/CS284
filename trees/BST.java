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
		if (comp==0) {
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
			addOk = true;
			current.right = add(item, current.right);
		} else if (comp > 0) {
			addOk = true;
			current.left = add(item, current.left);
		} else {
			addOk = false;
		}
	}
	
	public Boolean add(E item) {
		root = add(item, root);
		return addOk;
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
