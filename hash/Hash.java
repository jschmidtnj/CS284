package hash;

public class Hash {

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
	 */

}
