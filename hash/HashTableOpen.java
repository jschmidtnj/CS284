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
		/*
		 * Find the first table element that is empty or the table element that contains
		 * the key. if (an empty element was found) return null. Key was found. Remove
		 * this table element by setting it to reference DELETED, increment numDeletes,
		 * and decrement numKeys. Return the value associated with this key.
		 */
		
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