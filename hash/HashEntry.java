package hash;

public class HashEntry<K, V> {

	private K key;
	private V value;
	
	HashEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	HashEntry() {
		this.key = null;
		this.value = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}
