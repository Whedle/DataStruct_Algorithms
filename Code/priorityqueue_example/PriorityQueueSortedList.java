
package priorityqueue_example;

import java.util.Comparator;

import arraylist_iterator_example.NodePositionList;
import arraylist_iterator_example.Position;
import arraylist_iterator_example.PositionList;
import exceptions_example.EmptyPriorityQueueException;
import exceptions_example.InvalidKeyException;

/* Class: PriorityQueueSortedList
 * @author - Wade Hedlesky
 * Useful for referencing a priority queue ADT algorithm when attempting to create one in less familiar language. Those who are familiar with
 * Java can easily transfer this structure and associated algorithms into other Object-Oriented languages. When referencing, keep in mind that
 * ArrayList and Vector in Java have different growth rates than many other languages, and therefore the optimal (or sub-optimal) run-times 
 * may be altered.
 * 
 * "A priority queue is an abstract data type for storing a collection of prioritized elements that supports arbitrary element insertion but 
 * supports removal of elements in order of priority, that is, the element with first priority can be removed at any time."
 * 
 * Key  					an object that is assigned to an element as a specific attribute for that element, which can be used to 
 * 							identify or weigh that element (i.e. product-key).
 * Reflexive Property 		k <= k
 * Antisymmetric Property 	if k1 <= k2 and k2 <= k1, then k1  = k2.
 * Transitive Property 		If k1 <= k2 and k2 <= k3, then k1 <= k3.
 * 
 * Phase 1		Insertions 
 * Phase 2		Selections (typically using removeMin();)
 * 
 * If P is implemented with an unsorted list, then Phase 1 of PriorityQueueUnsortedList takes O(n) time. Element insertions are O(1) 
 * time each. In Phase 2, the running time of each removeMin() operation is proportional to the size of P. Thus, the bottleneck 
 * computation is the repeated "selection" of the minimum element in phase 2. By convention, this is algorithm is called
 * the Selection-Sort algorithm, because the selection operations are the bottleneck. Because the complexity in Phase 2 is 
 * proportional to the size of P and as Phase 2 is executed, the size of P decreases towards 0, the total time complexity needed 
 * for phase two is O(n + n-1 + n-2 + ... + n-n+2 + 1) = O(n^2).
 * 
 * If P is implemented with a sorted list, then Phase 1 of PriorityQueueSortedList takes O(n^2) time, and Phase 2 takes O(n) time. This algorithm is called Insertion Sort.
 * 
 * These two implementations of PriorityQueue suggest a possible mechanism for optimizing the algorithms, and the solution to this optimization 
 * problem is realized in a data structure called a heap.
 * 
 * Imports:		java.util.Comparator
 * 				arraylist_iterator_example.NodePositionList
 * 				arraylist_iterator_example.Position
 * 				arraylist_iterator_example.PositionList
 * 				exceptions_example.EmptyPriorityQueueException
 * 				exceptions_example.InvalidKeyException
 */
public class PriorityQueueSortedList<K, V> implements PriorityQueue <K, V>
{
	
	protected PositionList<PriorityQueueEntry<K,V>> entries;
	protected Comparator<K> comp;
	protected Position<PriorityQueueEntry<K, V>> actionPos;
	
	protected static class MyEntry<K, V> implements PriorityQueueEntry<K, V> 
	{
		protected K k; // the "Key"
		protected V v; // the "value"
		
		public MyEntry(K key, V value) 
		{
			k = key;
			v = value;
		}
	
		public K getKey() { 
			return k; 
		}

		public V getValue() { 
			return v; 
		}
	
	}
	
	public PriorityQueueSortedList () 
	{
		entries = new NodePositionList<PriorityQueueEntry<K, V>>();
		comp = new PriorityQueueComparator<K>();
	}
	
	public PriorityQueueSortedList (Comparator<K> c)
	{
		entries = new NodePositionList<PriorityQueueEntry<K, V>>();
		comp = c;
	}

	protected void checkKey(K key) throws InvalidKeyException{
		try { 
			comp.compare(key, key); 
		}
		catch(Exception e) { 
			throw new InvalidKeyException("Invalid key"); 
		}
	}

	public PriorityQueueEntry<K, V> insert(K k, V v) throws InvalidKeyException {
		checkKey(k);
		PriorityQueueEntry<K, V> entry = new MyEntry<K, V>(k, v);
		insertEntry(entry);
		return entry;
	}
	
	protected void insertEntry(PriorityQueueEntry<K, V> e) {
		if (entries.isEmpty()) {
			entries.addFirst(e);
			actionPos = entries.first();
		} else if (comp.compare(e.getKey(), entries.last().element().getKey()) > 0) {
			entries.addLast(e);;
			actionPos = entries.last();
		}
		else {
			Position<PriorityQueueEntry<K, V>> curr = entries.first();
			while (comp.compare(e.getKey(), curr.element().getKey())> 0) {
				curr = entries.next(curr);
				}
		entries.addBefore(curr, e);
		actionPos = entries.prev(curr);
		}
	}
	
	public boolean isEmpty() {
		
		return false;
	}
	
	public PriorityQueueEntry<K, V> min() throws EmptyPriorityQueueException {
		if(entries.isEmpty())
			throw new EmptyPriorityQueueException("EXCEPTION: PriorityQueueSortedList.min(); threw EmptyPriorityQueueException; CAUSE: isEmpty() returned true.");
		else
			return entries.first().element();
	}

	public PriorityQueueEntry<K, V> removeMin() throws EmptyPriorityQueueException {
		if (entries.isEmpty())
			throw new EmptyPriorityQueueException("EXCEPTION: PriorityQueueSortedList.removeMin(); threw EmptyPriorityQueueException; CAUSE: isEmpty() returned true.");
		else
			return entries.remove(entries.first());
	}	
	
	public int size() {
		return entries.size();
	}
}
