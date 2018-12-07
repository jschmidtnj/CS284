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
	
	public static void main(String[] args) {
		HashTableChain<String, String> table1 = new HashTableChain<String, String>();
		System.out.println(table1.size());
		System.out.println(table1.put("Josh", "is cool"));
		System.out.println(table1.size());
		System.out.println(table1.get("Josh"));
		System.out.println(table1.get("23rasdf"));
		System.out.println(table1.remove("Josh"));
		System.out.println(table1.get("Josh"));
		System.out.println(table1.size());
	}
}
