package hash;

import java.util.*;

public class Hash<K, V> { // key-value pairs

	/*
	 * access an entry based on key, not location
	 * access is O(1) - constant time
	 * 
	 * the hash class needs to convert from a key to a hash that corresponds to an index in an array
	 * hash function to get key. index calculation needs to be very very fast
	 * the index calculation is split into 2 phases - hash code and modulus (modulus ensures you don't move
	 * over the end of the array). we are not interested in coming up with hash functions (this is for math people)
	 * Distribution of keys needs to be good, there cannot be bias, and the all need to be injective (no double keys)
	 * 
	 * collisions occur if the index ends up in the same place as one that is already taken - this needs to be
	 * dealt with - the first is open-chaining and the second is bucketing that we'll be looking at
	 * 
	 * hashCode()
	 * 
	 * if collision you wrap around and go down until you get to an open spot (linear probing) - hash
	 * stays the same. but linear probing makes the table clustered.  not good because find operation turns
	 * into O(n) operation instead of O(1)
	 * 
	 * don't occupy the table. when you get to 75% full or something, enlarge the table
	 * 
	 * find(key)
	 * 	index = key.hashCode % table.size
	 * 	compare keys to make sure that the key in the index is the same as the one you're looking for -
	 * 	this avoids collision
	 * 	while (e[index] != null && e[index][key] != key) {
	 * 	  index = (index + 1) % t.size
	 * 	}
	 * 
	 * Under special conditions the hash find is O(1). but in worst case with bad implementation it can be
	 * O(n). like with linear probing...
	 * 
	 * 
	 * new day 11/26/18
	 * Create a table:
	 * keys | (key, value)
	 * 
	 * huffman tree - based on frequencies
	 * 
	 * bucketting - linked list in each index = not that much room for collision
	 * linear probing - insertion adds to any open slot - creates room for collision
	 * 
	 */
	
	private List<HashEntry<K,V>> table;
	private static final double LOADFACTOR = 0.75; //how much of table can be full before rehash / refactor
	private int size;
	private int used;
	
	public Hash() {
		size = 100;
		table = new ArrayList<HashEntry<K,V>>(size);
		used = 0;
	}
	
	public void rehash() {
		//TODO
	}
	
	public void add(K key, V value) {
		add(new HashEntry<K, V>(key, value));
	}
	
	public void add(HashEntry<K,V> e) {
		// compute the hashcode of the key
		int index = e.getKey().hashCode();
		HashEntry<K,V> position = table.get(index);
		if (position != null) {
			table.add(e);
			used++;
		}
		if (used > (size * LOADFACTOR)) {
			rehash();
		}
	}
	
	public boolean delete(K key) {
		int index = key.hashCode() % size;
		HashEntry<K,V> position = table.get(index);
		if (position == null) {
			return false;
		}
		for (HashEntry<K,V> e: table) {
			if (e.getKey().equals(key)) {
				//V temp = e.getValue();
				table.remove(e);
				return true;
			}
		}
		return false;
	}
	
	public V find(K key) {
		int index = key.hashCode() % size;
		HashEntry<K,V> position = table.get(index);
		if (position == null) {
			return null;
		}
		for (HashEntry<K,V> e: table) {
			if (e.getKey().equals(key)) {
				return e.getValue();
			}
		}
		return null;
		
	}
	
	public static void main(String[] args) {
		
	}

}
