# CS 284 Endterm

used [this](https://www.markdowntopdf.com/) to convert to a pdf.  

## Binary Trees

* Full - every node has 0 or 2 children
* Complete - all levels are completely filled except the last level (complete to left)
* Perfect - all nodes have 2 children and leaves are at same level

### Binary Tree

```java

package trees;

import java.util.ArrayList;
import java.lang.Math;

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
	
	private ArrayList<E> preorder(Node<E> current) {
		ArrayList<E> result = new ArrayList<E>();
		if (current == null) {
			return new ArrayList<E>();
		}
		result.add(current.data);
		result.addAll(preorder(current.left));
		result.addAll(preorder(current.right));
		return result;
	}
	
	public ArrayList<E> preorder() {
		return preorder(root);
	}
	
	private void mirror_image(Node<E> current) {
		if (current == null) {
			return;
		}
		Node<E> temp = current.left;
		current.left = current.right;
		current.right = temp;
		mirror_image(current.left);
		mirror_image(current.right);
	}
	
	public void mirror_image() {
		mirror_image(root);
	}
	
	private int size(Node<E> current) {
		if (current == null) {
			return 0;
		}
		return 1 + size(current.left) + size(current.right);
	}
	
	
	public int size() {
		return size(root);
	}
	
	public boolean isFull(Node<E> current) {
		if (current == null) {
			return true;
		}
		if (current.left == null && current.right == null) {
			return true;
		}
		if (current.left != null && current.right == null) {
			return false;
		}
		if (current.right != null && current.left == null) {
			return false;
		}
		return isFull(current.left) && isFull(current.right);
	}
	
	public boolean isFull() {
		return isFull(root);
	}
	
	private int height(Node<E> current) {
		if (current == null) {
			return 0; //this can be -1 (depends on definition)
		}
		return 1 + Math.max(height(current.left), height(current.right));
	}
	
	
	public int height() {
		return height(root);
	}
	
	private boolean isComplete(Node<E> current, int index, int size) {
		if (index >= size) {
			return false;
		}
		if (current == null) {
			return true;
		}
        return isComplete(current.left, index * 2 + 1, size) 
            && isComplete(current.right, index * 2 + 2, size);
	}
	
	
	public boolean isComplete() {
		return isComplete(root, 0, this.size());
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
		System.out.println(bt.isLeaf());
	}
}

```

### BST

```java
package trees;

public class BST<E extends Comparable<E>> extends BTree<E> {

	// data fields inherited from BTree
	private boolean addOk;
	
	private E deletedItem;

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

	private Node<E> add(E item, Node<E> current) {
		if (current == null) {
			addOk = true;
			return new Node<E>(item);
		}
		int comp = current.data.compareTo(item);
		if (comp == 0) {
			addOk = false;
			return current;
		}
		if (comp < 1) {
			current.right = add(item, current.right);
			return current;
		} else {
			current.left = add(item, current.left);
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
	
	private E find_and_remove_max(Node<E> current) {
		E result;
		if (current.right.right == null) { // found the max elem
			result = current.right.data;
			current.right = current.right.left;
			return result;
		} else {
			return find_and_remove_max(current.right);
		}
    }
	
	private Node<E> hisremove(E key, Node<E> current) {
		if (current == null) { // item not found
			return null;
		}
		int comp = key.compareTo(current.data);
		if (comp < 0) {
			//key is in left subtree
			current.left = hisremove(key, current.left);
			return current;
		}
		if (comp > 0) {
			current.right = hisremove(key, current.right);
			return current;
		}
		if (comp == 0) {
			deletedItem = current.data;
			// now what
			if (current.isLeaf()) {
				return null;
			} 
			if (current.right == null) {
				return current.left;
			}
			if (current.left == null) {
				return current.right;
			}
			
			//current has 2 children
			if (current.left.right == null) {
				current.data = current.left.data;
				current.left = current.left.left;
				return current;
			}
			current.data = find_and_remove_max(current.left);
			return current;
		}
		return null;
		
	}
	
	public E hisremove(E key) {
		root = hisremove(key, root);
		return deletedItem;
	}

	// Methods
	public static void main(String[] args) {
		BST<Integer> bst1 = new BST<Integer>();
		bst1.add(3);
		bst1.add(7);
		System.out.println(bst1);
	}
}

```

## Sorting

### Complexity

* O(n^2)
    * selection
    * insertion
* O(nlogn)
    * heap
    * merge
* O(n^2) - better in practice
    * quick sort

### Code

```java

package sorting;

import java.util.Arrays;

public class Sorting {

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void selection(int[] a) {
		// swap with min elements
		int posMin;
		for (int fill = 0; fill < a.length - 2; fill++) {
			posMin = fill;
			for (int i = fill; i <= a.length - 1; i++) {
				if (a[i] < a[posMin])
					posMin = i;
			}
			swap(a, fill, posMin);
		}
	}

	public static void bubble(int[] a) {
		// swap adjacent elements
		int n = a.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (a[j] > a[j + 1])
					swap(a, j, j + 1);
	}

	public static void insertion(int[] a) {
		// find spot in list and insert there
		for (int nextPos = 1; nextPos < a.length; nextPos++) {
			int nextVal = a[nextPos];
			int current = nextPos;
			while (current - 1 >= 0 && a[current - 1] > nextVal) {
				a[current] = a[current - 1];
				current--;
			}
			a[current] = nextVal;
		}
	}

	private static int[] merge(int[] a, int[] b, int[] c) {
		// O(n) or O(n + m)
		int indexa = 0;
		int indexb = 0;
		int indexc = 0;
		while (indexa < a.length && indexb < b.length) {
			if (a[indexa] < b[indexb]) {
				c[indexc] = a[indexa];
				indexa++;
			} else {
				c[indexc] = b[indexb];
				indexb++;
			}
			indexc++;
		}
		while (indexa < a.length) {
			c[indexc] = a[indexa];
			indexc++;
			indexa++;
		}
		while (indexb < b.length) {
			c[indexc] = b[indexb];
			indexc++;
			indexb++;
		}
		return c;
	}

	public static void mergesort(int[] a) {
		if (a.length <= 1)
			return;

		int size = a.length / 2;
		int[] left = Arrays.copyOfRange(a, 0, size);
		int[] right = Arrays.copyOfRange(a, size, a.length);
		mergesort(left);
		mergesort(right);
		a = merge(left, right, a);
	}

	public static void countingsort(int[] a) {
		// [5,3,7,1,4,5]
		// 2, 1, 1, 1, 1
		// counts every element and then spits them out
		int max = a[0];
		for (int i = 0; i < a.length; i++)
			if (a[i] > max)
				max = a[i];

		// System.out.println(max);

		int[] counts = new int[max + 1];
		for (int i = 0; i < a.length; i++)
			counts[a[i]]++;

        for (int i = 0, resultindex = 0; i < counts.length 
            && resultindex < a.length; i++)
			if (counts[i] != 0)
				for (int j = 0; j < counts[i] && j < a.length; j++, resultindex++)
					a[resultindex] = i;
	}

	private static void buildHeap(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int current = i;
			int parent = (current - 1) / 2;
			while (parent >= 0 && a[current] > a[parent]) {
				swap(a, current, parent);
				current = parent;
				parent = (current - 1) / 2;
			}
		}
	}

	private static void deconstructHeap(int[] a) {

		for (int size = a.length - 1; size > 0; size--) {
			swap(a, 0, size);
			int parent = 0;
			int leftChild, rightChild, maxChild;
			while (true) {
				leftChild = (parent * 2) + 1;
				rightChild = leftChild + 1;
				// determine minimum child
				if (leftChild > size - 1) { // reached a leaf!
					break;
				}
				maxChild = leftChild;
				if (rightChild < size && a[rightChild] > a[leftChild]) {
					maxChild = rightChild;
				}
				// minChild points to the smallest of the children
				if (a[parent] > a[maxChild]) {
					break; // no more swappings necessary
				}
				swap(a, parent, maxChild);
				parent = maxChild;
			}

		}

	}

	public static void heapSort(int[] a) {
		buildHeap(a);
		// System.out.println(Arrays.toString(a));
		deconstructHeap(a);
	}

	public static int partition(int[] a, int left, int right) {
		// O(n)
		int pivot = left, up = left, down = right;
		do {
			while (a[up] <= a[pivot] && up < right)
				up++;
			while (a[down] > a[pivot])
				down--;
			if (up < down)
				swap(a, up, down);
		} while (up < down);
		swap(a, down, pivot);
		return down;
	}

	public static void quicksorthelp(int[] a, int left, int right) {
		if (left < right) {
			int pivot_index = partition(a, left, right);
			quicksorthelp(a, left, pivot_index - 1);
			quicksorthelp(a, pivot_index + 1, right);
		}
	}

	public static void quicksort(int[] a) {
		// O(n^2)
		quicksorthelp(a, 0, a.length - 1);
	}

	public static void main(String[] args) {
		int[] a = { 35, 65, 30, 60, 20 };
		System.out.println(Arrays.toString(a));
		selection(a);
		//...
	}
}

```

## Hashing

### Hash Table Open Addressing - Linear Probing

```java

package hash;

public class HashTableOpen<K, V> implements KWHashMap<K, V> {

	// Data Fields
	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);

	// Constructor
	public HashTableOpen() {
		table = new Entry[START_CAPACITY];
	}

	// Insert inner class Entry<K, V> here.
	private static class Entry<K, V> {

		private K key;
		private V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}
	}

	public int size() {
		return numKeys;
	}

	public boolean isEmpty() {
		return numKeys == 0;
	}

	private int find(Object key) {

		// Calculate the starting index.
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length; // Make it positive.

		// Increment index until an empty slot is reached

		// or the key is found.
		while ((table[index] != null) && (!key.equals(table[index].key))) {
			index++;

			// Check for wraparound.
			if (index >= table.length)
				index = 0; // Wrap around.
		}

		return index;
	}

	public V get(Object key) {
		// Find the first table element that is empty

		// or the table element that contains the key.
		int index = find(key);

		// If the search is successful, return the value.

		if (table[index] != null)
			return table[index].value;
		else
			return null; // key not found.

	}

	public V put(K key, V value) {

		int index = find(key);
		// If an empty element was found, insert new entry.

		if (table[index] == null) {
			table[index] = new Entry<K, V>(key, value);
			numKeys++;

			// Check whether rehash is needed.

			double loadFactor = (double) (numKeys + numDeletes) / table.length;

			if (loadFactor > LOAD_THRESHOLD)
				rehash();
			return null;
		}

		// assert: table element that contains the key was found.
		// Replace value for this key.

		V oldVal = table[index].value;
		table[index].value = value;

		return oldVal;
	}

	private void rehash() {
		// Save a reference to oldTable.

		Entry<K, V>[] oldTable = table;
		// Double capacity of this table.

		table = new Entry[2 * oldTable.length + 1];

		// Reinsert all items in oldTable into expanded table.
		numKeys = 0;

		numDeletes = 0;
		for (int i = 0; i < oldTable.length; i++) {

			if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
				// Insert entry in expanded table

				put(oldTable[i].key, oldTable[i].value);
			}

		}
	}

	public V remove(Object key) {
		if (this.isEmpty())
			return null;

		int index = find(key);
		if (table[index] == null)
			return null; // key not found.
		V value = table[index].getValue();
		table[index] = DELETED;
		numDeletes++;
		numKeys--;
		return value;
	}

	public static void main(String[] args) {
		HashTableOpen<String, String> table1 = new HashTableOpen<String, String>();
	}
}

```

### Hash Table Chaining (or Bucketing)

```java

package hash;

import java.util.LinkedList;

public class HashTableChain<K, V> implements KWHashMap<K, V> {
	/** The table */
	private LinkedList<Entry<K, V>>[] table;

	/** The number of keys */
	private int numKeys;

	/** The capacity */

	private static final int CAPACITY = 101;

	/** The maximum load factor */

	private static final double LOAD_THRESHOLD = 3.0;

	// Insert inner class Entry<K, V> here.
	private static class Entry<K, V> {
        //...
	}

	// Constructor
	public HashTableChain() {
		table = new LinkedList[CAPACITY];
	}

	public int size() {
		return numKeys;
	}

	public boolean isEmpty() {
		return numKeys == 0;
	}

	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if (table[index] == null)
			return null; // key is not in the table.

		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			if (nextItem.key.equals(key))
				return nextItem.value;
		}

		// assert: key is not in the table.
		return null;
	}

	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if (table[index] == null) {
			// Create a new linked list at table[index].
			table[index] = new LinkedList<Entry<K, V>>();
		}

		// Search the list at table[index] to find the key.
		for (Entry<K, V> nextItem : table[index]) {
			// If the search is successful, replace the old value.
			if (nextItem.key.equals(key)) {
				// Replace value for this key.
				V oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
		}

		// assert: key is not in the table, add new item.
		table[index].addFirst(new Entry<K, V>(key, value));
		numKeys++;
		if (numKeys > (LOAD_THRESHOLD * table.length))
			rehash();
		return null;
	}
	
	private void rehash() {
		// Save a reference to oldTable.

		LinkedList<Entry<K, V>>[] oldTable = table;
		// Double capacity of this table.

		table = new LinkedList[2 * oldTable.length + 1];

		// Reinsert all items in oldTable into expanded table.
		numKeys = 0;

		for (int i = 0; i < oldTable.length; i++) {

			if ((oldTable[i] != null)) {
				// Insert entry in expanded table
				for (Entry<K, V> ent: oldTable[i])
					put(ent.getKey(), ent.getValue());
			}

		}
	}
	
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index = index + table.length;
		if (table[index] == null)
			return null;
		for (Entry<K, V> elem: table[index]) {
			if (elem.getKey() == key) {
				V val = elem.getValue();
				table[index].remove(elem);
				numKeys--;
				if(table[index].isEmpty())
					table[index] = null;
				return val;
			}
		}
		return null;
	}
}

```

## AVL Trees

* balance  = h(right) - h(1eft), -1 <= balance <= 1
* LR or RL is 2 rotations, RR and LL is 1 rotation
