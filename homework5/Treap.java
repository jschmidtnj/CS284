package homework5;

import java.util.Random;

public class Treap<T extends Comparable> {
	
	private static class Node<T extends Comparable> {
        public Node<T> right, left;
        public int priority;
        public T data;

        public Node(T data, int priority) {
			this.data = data;
			this.priority = priority;
			this.left = null;
			this.right = null;
		}

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + data +
                    ", priority=" + priority +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
        
        private Node<T> rotateRight(Node<T> node) {
            Node<T> lnode = node.left;
            node.left = lnode.right;
            lnode.right = node;
            return lnode;
        }

        private Node<T> rotateLeft(Node<T> node) {
            Node<T> rnode = node.right;
            node.right = rnode.left;
            rnode.left = node;
            return rnode;
        }
    }
	

	private Random priorityGenerator;
    private Node<T> root;

    public boolean add(T data) {
        root = add(root, data, priorityGenerator.nextInt());
        return true;
    }
    
    public boolean add(T data, int priority) {
        root = add(root, data, priority);
        return true;
    }

    private Node<T> add(Node<T> node, T data, int priority) {
        if (node == null) {
        	Node<T> newNode = new Node<T>(data, priority);
        	return newNode;
        }

        int compare = data.compareTo(node.data);
        if (compare < 0) {
            node.left = add(node.left, data, priority);
            if (node.priority < node.left.priority)
                return node.rotateRight(node);
        } else if (compare > 0) {
            node.right = add(node.right, data, priority);
            if (node.priority < node.right.priority)
                return node.rotateLeft(node);
        }
        return node;
    }

    public boolean remove(T data) {
        root = remove(root, data);
        return true;
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node != null) {
            int compare = data.compareTo(node.data);
            if (compare < 0) {
                node.left = remove(node.left, data);
            } else if (compare > 0) {
                node.right = remove(node.right, data);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    node.data = first(node.right);
                    node.right = remove(node.right, node.data);
                }
            }
        }
        return node;
    }

    public boolean contains(T data) {
        Node<T> node = root;
        while (node != null) {
            int compare = data.compareTo(node.data);
            if (compare < 0) node = node.left;
            else if (compare > 0) node = node.right;
            else return true;
        }
        return false;
    }

    public T first() {
        return first(root);
    }

    private T first(Node<T> searchNode) {
        Node<T> node = searchNode;
        while (node.left != null) node = node.left;
        return node.data;
    }

    @Override
    public String toString() {
        return "Treap{" +
                "root=" + root +
                '}';
    }
    
    public static void main(String[] args) {
    	Treap<Integer> testTree = new Treap<Integer>();
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
		System.out.println(testTree.contains(0));
		System.out.println("test");
		System.out.println(testTree.remove(1));
		System.out.println(testTree);
    }
}
