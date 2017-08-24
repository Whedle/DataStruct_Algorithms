
package maps_example;

import arraylist_iterator_example.NodePositionList;
import arraylist_iterator_example.PositionList;
import exceptions_example.InvalidKeyException;

/* Class: HashTableMap
 * @author - Wade Hedlesky
 * Hash table that implements java.util.Map and uses Linear Probing (instead of separate chaining) and a Multiply-Add-Divide hash function.
 * A hash function can be thought of as consisting of two phases:
 * 		1: the mapping of the key k to the hash code (an integer) {this mapping operation does not necessarily become bounded by the capacity of the hash table}
 * 		2: the mapping of the integer hash code to an integer with the range of the indices in the bucket array (from 0 to N-1 for Java). This is the compression function.
 * The Java Collections Framework already provides a hash table implementation, but this implementation uses the separate chaining scheme. While separate chaining frequently
 * 		has better runtime performance, linear probing is an example of the Open Addressing scheme which does have at least one advantage. It odes not require the use of an
 * 		auxiliary data structure - a list - to hold entries with colliding keys. This can be extremely useful for certain types of applications where collisions absolutely
 * 		must be kept to zero, so the load factor of a Hash Table with Open Addressing should be at most 1.
 * 
 * @param <K>
 * @param <V>
 * 
 * Imports:		arraylist_iterator_example.NodePositionList
 * 				arraylist_iterator_example.PositionList
 * 				exceptions_example.InvalidKeyException
 */
public class HashTableMap<K, V> implements Map<K, V> {
	
	/**Class: HashEntry
	 * @author - Wade Hedlesky
	 * This static class is a helper class for HashTableMap. It implements the Entry interface and has additional methods
	 * setValue(..) and equals(..).
	 * @param <K>
	 * @param <V>
	 */
	public static class HashEntry<K, V> implements Entry<K, V> 
	{
		protected K key;
		protected V value;
		public HashEntry(K k, V v) { key = k; value = v; }
		public V getValue() { return value; }
		public K getKey() { return key; }
		public V setValue( V newValue ) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}
		
		/**
		 * Takes an input Object and tests if can be cast into HashEntry<K, V> safely.
		 * Throws exception ClassCastException if it cannot be cast into HashEntry<K, V>.
		 */
		@SuppressWarnings("unchecked")
		public boolean equals( Object obj ) {
			HashEntry<K, V> entry;
			try { entry = ( HashEntry<K, V> ) obj; }
			catch( ClassCastException ex ) {return false; }
			return ( ( entry.getKey() == key ) && ( entry.getValue() == value) );
		}
	}

	protected Entry<K, V> AVAILABLE = new HashEntry<K, V>( null, null );
	protected int n = 0;
	protected int prime, capacity;
	protected Entry<K, V>[] bucket;
	protected long scale, shift;
	
	/* 
	 * This is the default constructor for HashTableMap.
	 * This constructor calls this(8831, cap). 8831 is a prime number selected at random for the purpose of
	 * writing this code. 
	 */
	public HashTableMap( int cap ) 
	{ 
		this(8831, cap); 	
	}
	
	@SuppressWarnings("unchecked")
	public HashTableMap( int p, int cap ) 
	{
		prime = p;
		capacity = cap;
		bucket = ( Entry<K, V>[] ) new Entry[capacity];
		java.util.Random rand = new java.util.Random();
		scale = rand.nextInt( prime - 1 ) + 1;
		shift = rand.nextInt( prime );	
	}
	
	/*
	 * checkKey(k) Ensures that the key given to it is not null and meets any other implementation specific requirements.
	 * { If creating an extension of HashTableMap.java using the checkKey(K k), make sure to include additional requirements specification
	 * 		checks within this method. }
	 * @param k
	 * @throws InvalidKeyException
	 */
	protected void checkKey( K k ) throws InvalidKeyException {
		if( k == null ) throw new InvalidKeyException( "checkKey(k); key cannot be null." );
		return;
	}
	
	public void clear() {
		for( int i = 0; i < capacity; i++ )
			if( bucket[i] != null && bucket[i] != AVAILABLE ) {
				bucket[i] = null;
				bucket[i] = AVAILABLE;
			}
	}

	/*
	 * Returns Iterable collection containing all entries in the Hash Table. So entrySet().iterator() returns an iterator of keys.
	 * @return Iterable collection of all entries in Hash Table.
	 */
	public Iterable<Entry<K, V>> entrySet() {
		PositionList<Entry<K, V>> entries = new NodePositionList<Entry<K, V>>();
		for( int i = 0; i < capacity; i++ ) {
			if( bucket[i] != null && bucket[i] != AVAILABLE )
				entries.addLast(new HashEntry<K, V>(bucket[i].getKey(), bucket[i].getValue()));
		}
		return entries;
	}

	/*
	 * A helper function that returns the index of a found key or -(a + 1), where a is the index of the first
	 * empty or available slot found.
	 * @param key
	 * @return 
	 * @throws InvalidKeyException
	 */
	protected int findEntry( K key ) throws InvalidKeyException {
		int available = -1;
		checkKey(key);
		int i = hashValue(key);
		int j = i;
		do {
			Entry<K, V> entries = bucket[i];
			if( entries == null )
			{
				if (available < 0 )
					available = i;
				break;
			}
			if( key.equals( entries.getKey() ) ){
				return i;
			}
			if( entries == AVAILABLE ) {
				if(available < 0)
					available = i;
			}
			i = ( i + 1 ) % capacity;
		} while ( i != j );
		return -( available + 1 );
	}
	
	/*
	 * Tests whether Hash Table is empty.
	 * @return true if an empty Hash Table.
	 */
	public V get(K key) throws InvalidKeyException {
		int i = findEntry(key);
		if( i < 0 ) return null;
		return bucket[i].getValue();
	}

	/*
	 * hashValue A compression function that compresses the hash code using the MAD method.
	 * @param key
	 * @return int applies Multiply-Add-Divide Method. Mathematically: [(ai+b)mod p] mod N
	 */
	public int hashValue(K key) {
		return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity); 
	}
	
	/*
	 * Returns Iterable collection containing all keys in the Hash Table. So keySet().iterator() returns an iterator of keys.
	 * @return Iterable collection of all keys in Hash Table.
	 */
	public Iterable<K> keySet() {
		PositionList<K> keys = new NodePositionList<K>();
		for (int i = 0; i < capacity; i++)
			if (( bucket[i] != null) && (bucket[i] != AVAILABLE))
				keys.addLast(bucket[i].getKey());
		return keys;
	}

	/* Returns the number of entries in a Hash Table. */
	public boolean isEmpty() {
		return (n == 0);
	}

	/*
	 * If Hash Table does not have an entry with key k, then adds entry (key,value) to the Hash Table and returns null; 
	 * otherwise it replaces the old value with the new value and returns the old value.
	 * @param key
	 * @param value
	 * @return Either null or the old value, depending on if key maps to a value in this Hash Table.
	 */
	public V put(K key, V value) throws InvalidKeyException {
		int i = findEntry(key);
		if( i >= 0 )
			return (( HashEntry<K, V>) bucket[i]). setValue(value);
		if( n >= capacity/2 ) {
			rehash();
			i = findEntry(key);								// returns the index in form -(a + 1)
		}
		bucket[-i-1] = new HashEntry<K, V>(key, value);		// converts to proper index
		n++;
		return null;										// if there was no previous value.
	}
	
	/* Increases the capacity of the Hash Table; useful for keep load factor low. */
	@SuppressWarnings("unchecked")
	protected void rehash() {
		capacity = 2 * capacity;
		Entry<K, V>[] oldBucket = bucket;
		bucket = ( Entry<K, V>[] ) new Entry[capacity];		// Creates a new bucket that is larger than oldBucket.
		java.util.Random rand = new java.util.Random();
		scale = rand.nextInt( prime - 1 ) + 1;
		shift = rand.nextInt(prime);
		for( int i = 0; i < oldBucket.length; i++ ) {
			Entry<K, V> ent = oldBucket[i];
			if( ( ent != null ) && ( ent != AVAILABLE) ) {	// checks if a valid entry.
				int j = -1 - findEntry(ent.getKey());
				bucket[j] = ent;;
			}
		}
	}
	
	public V remove(K key) throws InvalidKeyException{
		int i = findEntry(key);
		if( i < 0 ) return null;
		V toReturn = bucket[i].getValue();
		bucket[i] = AVAILABLE;
		n--;
		return toReturn;
	}
	
	/* Returns the number of entries within the Hash Table. */
	public int size() {
		return n;
	}

	/*
	 * Returns Iterable collection containing all values in the Hash Table. So values().iterator() returns an iterator of values.
	 * @return Iterable collection of all values in Hash Table.
	 */
	public Iterable<V> values() {
		PositionList<V> values = new NodePositionList<V>();
		for( int i = 0; i < capacity; i++ )
			if( bucket[i] != null && bucket[i] != AVAILABLE)
				values.addLast(bucket[i].getValue());
		return values;
	}
}
