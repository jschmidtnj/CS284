package trees;

public class BTree<E> {

	public static class Node<F> {
		private F data;
		private Node<F> left;
		private Node<F> right;

		public Node(F data) {
			this.data = data;
			left = null;
			right = null;
		}

		public Node(F data, Node<F> left, Node<F> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public F getData() {
			return data;
		}

		public void setData(F data) {
			this.data = data;
		}

		public Node<F> getLeft() {
			return left;
		}

		public void setLeft(Node<F> left) {
			this.left = left;
		}

		public Node<F> getRight() {
			return right;
		}

		public void setRight(Node<F> right) {
			this.right = right;
		}

	}

	private Node<E> root;
	private int size;

	public BTree() {
		root = null;
		size = 0;
	}

	public BTree(E data) {
		size = 1;
		root = new Node<E>(data);
	}

	public BTree(E data, BTree<E> leftTree, BTree<E> rightTree) {
		size = leftTree.size + rightTree.size + 1;
		root = new Node<E>(data, leftTree.root, rightTree.root);
	}

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString(Node<E> current, int i) {
		// print out tree in preorder
		StringBuilder s = new StringBuilder();
		for (int j = 0; j < i; j++) {
			s.append("---");
		}
		if (current == null) {
			s.append("null");
			return s.toString();
		}
		s.append(current.data.toString());
		s.append("\n");
		s.append(toString(current.left, i + 1));
		s.append("\n");
		s.append(toString(current.right, i + 1));
		s.append("\n");
		return s.toString();
	}

	public String toString() {
		return toString(root, 0);
	}

	public static void main(String[] args) {
		BTree<Integer> leaf1 = new BTree<Integer>(5);
		BTree<Integer> leaf2 = new BTree<Integer>(10);
		BTree<Integer> bt = new BTree<Integer>(12, leaf1, leaf2);

		System.out.println(bt);
	}
}
