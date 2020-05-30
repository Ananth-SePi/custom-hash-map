package com.sepi.custommap;

/**
 * @author Ananth-SePi
 * Class to hold the key value pair.
 */

public class HashEntry<K,V>{
	public K key;
	public V value;
	public HashEntry<K, V> next;

	public HashEntry(K key, V value){
		this(key, value, null);
	}

	public HashEntry(K key, V value, HashEntry<K, V> next){
		this.key = key;
		this.value = value;
		this.next = next;
	}
}
