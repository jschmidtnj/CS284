package quiz6;

import java.util.ArrayList;

public class BTree<E> {

	public static class Node<F> {
		protected F data;
		protected Node<F> left;
		protected Node<F> right;

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

		public Boolean isLeaf() {
			return this.left == null && this.right == null;
		}

	}

	protected Node<E> root;
	protected int size;

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

	public BTree(Node<E> thenode, int size) {
		size = this.size;
		root = thenode;
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

	public boolean isLeaf() {
		return root != null && root.isLeaf();
	}

	public int no_of_leaves() {
		return no_of_leaves(root);
	}

	public int no_of_leaves(Node<E> current) {
		if (current == null) {
			return 0;
		}
		if (current.isLeaf()) {
			return 1;
		}
		return no_of_leaves(current.left) + no_of_leaves(current.right);
	}

	private int height(Node<E> current) {
		if (current == null) {
			return 0; // this can be -1 (depends on definition)
		}
		return 1 + Math.max(height(current.left), height(current.right));
	}

	public int height() {
		return height(root);
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

	public int size(Node<E> current) {
		if (current == null) {
			return 0;
		}
		return 1 + size(current.left) + size(current.right);
	}

	private Node<E> clone(Node<E> current) {
		if (current == null)
			return null;
		Node<E> newNode = new Node<E>(current.data);
		newNode.left = clone(current.left);
		newNode.right = clone(current.right);
		return newNode;
	}

	private void st(Node<E> current, ArrayList<BTree<E>> result) {
		int thesize = size(current.left) + size(current.right) + 1;
		Node<E> rootNode = clone(current);
		BTree<E> currentTree = new BTree<E>(rootNode, thesize);
		result.add(currentTree);
		if (current.left != null) {
			st(current.left, result);
		}
		if (current.right != null) {
			st(current.right, result);
		}
	}

	public ArrayList<BTree<E>> st() {
		ArrayList<BTree<E>> result = new ArrayList<BTree<E>>();
		st(root, result);
		return result;
	}

	public static void main(String[] args) {
		BTree<Integer> leaf1 = new BTree<Integer>(5);
		BTree<Integer> leaf2 = new BTree<Integer>(10);
		BTree<Integer> leaf3 = new BTree<Integer>(14);
		BTree<Integer> leaf4 = new BTree<Integer>(15);
		BTree<Integer> bt = new BTree<Integer>(12, leaf1, leaf2);
		BTree<Integer> bt2 = new BTree<Integer>(20, leaf3, leaf4);
		BTree<Integer> bt3 = new BTree<Integer>(50, bt, bt2);
		System.out.println(bt3.st());
	}
}
