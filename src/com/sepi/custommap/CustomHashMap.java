package com.sepi.custommap;

import com.sepi.exception.DuplicateKeyException;

/**
 * @author Ananth-SePi
 * Custom hash map supports operation put, get and remove.
 */

import com.sepi.exception.KeyNotFoundException;

public class CustomHashMap<K, V> {

	private Integer tableSize;
	private HashEntry<K, V>[] table;

	public CustomHashMap(Integer tableSize) {
		this.tableSize = tableSize;
		table = new HashEntry[this.tableSize];
		for(int i = 0; i < table.length; i++) {
			table[i] = null;
		}
	}

	/**
	 * Inserts the value in the index of key hashcode.
	 * @param key
	 * @param value
	 * @return value
	 * @throws DuplicateKeyException
	 */
	public V put(K key, V value) throws DuplicateKeyException {
		int keyIndex = getHashCode(key);
		if(table[keyIndex] == null) {
			table[keyIndex] = new HashEntry<K, V>(key, value);
		} else {
			HashEntry<K, V> temp = table[keyIndex];
			while(temp != null) {
				if(temp.key.equals(key)) {
					throw new DuplicateKeyException();
				}
			}
			table[keyIndex] = new HashEntry<K, V>(key, value, table[keyIndex]);
		}
		return table[keyIndex].value;
	}

	/**
	 * Get the hash entry that is associated with the given key.
	 * @param key
	 * @return value
	 * @throws KeyNotFoundException
	 */
	public V get(K key) throws KeyNotFoundException {
		int keyIndex = getHashCode(key);
		if(table[keyIndex] == null) {
			throw new KeyNotFoundException();
		}
		HashEntry<K, V> temp = table[keyIndex];
		while(temp != null) {
			if(temp.key.equals(key)) {
				return temp.value;
			}
			temp = temp.next;
		}
		throw new KeyNotFoundException();
	}

	/**
	 * Removes the hash entry that is associated with the given key.
	 * @param key
	 * @return value
	 * @throws KeyNotFoundException
	 */
	public V remove(K key) throws KeyNotFoundException {
		V tempValue = null;
		int keyIndex = getHashCode(key);
		if(table[keyIndex] == null) {
			throw new KeyNotFoundException();
		}
		HashEntry<K, V> temp = table[keyIndex];
		if (temp != null && temp.key.equals(key)) {
			tempValue = temp.value;
			table[keyIndex] = null;
			return tempValue;
		}
		while(temp.next != null) {
			if(temp.next.key.equals(key)) {
				tempValue = temp.next.value;
				temp.next = null;
				return tempValue;
			}
			temp = temp.next;
		}
		throw new KeyNotFoundException();
	}
	
	/**
	 * Prints the element in the custom map.
	 * @return
	 */
	public String print() {
		String mapString = "[";
		for (Integer keyIndex = 0; keyIndex < this.tableSize; keyIndex++) {
			HashEntry<K, V> temp = table[keyIndex];
			while(temp != null) {
				mapString += temp.key + "=>" + temp.value + ", ";
				temp = temp.next;
			}
		}
		if (mapString.endsWith(", ")) {
			mapString = mapString.substring(0, mapString.length() - 2);
		}
		mapString += "]";
		return mapString;
	}

	/**
	 * Finds the index by the given key's hashcode.
	 * @param key
	 * @return index
	 */
	public int getHashCode(K key) {
		return key.hashCode() % this.tableSize;
	}
}
