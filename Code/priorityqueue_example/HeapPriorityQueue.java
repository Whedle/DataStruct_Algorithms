
package priorityqueue_example;

import java.util.Comparator;

import arraylist_iterator_example.Position;
import binarytree_example.ArrayListCompleteBinaryTree;
import binarytree_example.CompleteBinaryTree;
import exceptions_example.EmptyPriorityQueueException;
import exceptions_example.InvalidKeyException;

/* Class: HeapPriorityQueue
 * @author - Wade Hedlesky
 * 
 * A heap is a binary tree T that stores a collection of entries at its nodes and that satisfies two additional properties: 
 * 1: a relational property defined in terms of the ways keys are stored in T; and 
 * 2: a structural property defined in terms of the nodes of T itself.
 * 
 * IMPORTANT:
 * This heap assumes T (a complete binary tree) is implemented using an array list. "comp" is a comparator that defines 
 * the total order relation among the keys. This heap implements a priority queue.
 * 
 * Heap-Order Property: In a heap T, for every node v other than the root, the key stored at v is greater than or equal 
 * to the key stored at v's parent.
 * 
 * Note: heap data structures of this type are not the same as the memory heap used in run-time environments.
 * 
 * Results of Heap-Order Property:
 * The keys encountered on a path from the root to an external node of T are in nondecreasing order.
 * A minimum key is always stored at the root of T.
 * 
 * The heap is more effective if the Tree has as small a height as possible. 
 * 
 * Complete Binary Tree Property: A heap T with height h is a complete binary tree if levels 0, 1, 2, ..., h-1 of T have 
 * the maximum number of nodes possible (namely, level i has 2^i nodes, for 0 <= i <+ h-1) and in level h-1, all the 
 * internal nodes are to the left of the external nodes and there is at most one node with one child, which must be 
 * a left child.
 * 
 * Results of Complete Binary Tree Property: The last node of the heap is the right most, deepest external node of T.
 * A heap T storing n entries has height h = [_log(n)_]. (From the fact that T is complete implying the number of nodes 
 * in T is 1+2+4+..+2^(h-1)+1 = 2^h.
 * 
 * An important consequence of the efficiency of the heap-based implementation is that it can speed up priority-queue 
 * sorting to be much faster than the list-based insertion-sort and selection-sort algorithms.
 * 
 * For further information, read chapter 8 in the book "Data Structures and Algorithms in Java".
 * 
 * Imports:		java.util.Comparator	
 * 				arraylist_iterator_example.Position
 * 				binarytree_example.ArrayListCompleteBinaryTree
 * 				binarytree_example.CompleteBinaryTree
 * 				exceptions_example.EmptyPriorityQueueException
 * 				exceptions_example.InvalidKeyException
 */
public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V>
{
	protected CompleteBinaryTree<PriorityQueueEntry<K,V>> heap;
	protected Comparator<K> comp;
	
	protected static class MyEntry<K,V> implements PriorityQueueEntry<K,V>
	{
		protected K key; 
		protected V value;
		public MyEntry(K k, V v) { key = k; value = v; }
		public K getKey() { return key;}
		public V getValue() {return value; }
		public String toString() {return "(" + key + "," + value + ")"; }
	}
	
	public HeapPriorityQueue()
	{
		heap = new ArrayListCompleteBinaryTree<PriorityQueueEntry<K, V>>();
		comp = new PriorityQueueComparator<K>();
	}
	
	public HeapPriorityQueue(Comparator<K> c)
	{
		heap = new ArrayListCompleteBinaryTree<PriorityQueueEntry<K, V>>();
		comp = c;
	}
	
	protected void checkKey(K key) throws InvalidKeyException{
		try { comp.compare(key, key);	}
		catch(Exception e) { throw new InvalidKeyException("Invalid key"); }
	}
	
	/** 
	 *  Performs down-heap bubbling
	 *  After a removal from T, T may violate the heap-order property.
	 *  In order to satisfy the heap-order property, down-heap bubbling occurs. A swap either resolves the violation of the heap-order property or
	 *  propagates it one level down in the heap. In the worst case, an entry moves all the way down to the bottom level. The worst case execution of removeMin()
	 *  is thus equal to the height of heap T, that is, it is [_logn_].
	 */
	public void downHeap(Position<PriorityQueueEntry<K,V>> r) {
		while(heap.isInternal(r))
		{
		Position<PriorityQueueEntry<K, V>> s;
		if(!heap.hasRight(r)) 
			s = heap.left(r);
		else if (comp.compare(heap.left(r).element().getKey(), heap.right(r).element().getKey()) <= 0)
			s = heap.left(r);
		else
			s = heap.right(r);
		if(comp.compare(s.element().getKey(), r.element().getKey()) < 0)
		{
			swap(r,s);
			r = s;
		}
		else
			break;
		}
	}

	/** 
	 * Inserts a key-value pair and returns the entry.
	 * @param key
	 * @param value
	 */
	public PriorityQueueEntry<K, V> insert(K key, V value) throws InvalidKeyException {
		checkKey(key);
		PriorityQueueEntry<K, V> entry = new MyEntry<K, V>(key, value);
		upHeap(heap.add(entry));
		return entry;
	}

	public boolean isEmpty() {
		return (heap.size() == 0);
	}

	/** 
	 * Returns but does not remove an entry with minimum key.
	 */
	public PriorityQueueEntry<K, V> min() throws EmptyPriorityQueueException {
		if(isEmpty()) throw new EmptyPriorityQueueException("Priority queue is empty");
		return heap.root().element();
	}

	/** Returns and removes an entry with minimum key */
	public PriorityQueueEntry<K, V> removeMin() throws EmptyPriorityQueueException {
		if(isEmpty()) throw new EmptyPriorityQueueException("Priority queue is empty");
		PriorityQueueEntry<K, V> min = heap.root().element();
		if(size() == 1) heap.remove();
		else {
			heap.replace(heap.root(), heap.remove());
			downHeap(heap.root());
		}
		return min;
	}

	public int size() {
		return heap.size();
	}
	
	/**
	 * Swaps x and y
	 * @param x
	 * @param y
	 */
	protected void swap(Position<PriorityQueueEntry<K, V>> x, Position<PriorityQueueEntry<K ,V>> y)
	{
		PriorityQueueEntry<K, V> temp = x.element();
		heap.replace(x,  y.element());
		heap.replace(y,  temp);
	}
	
	/** Text visualization for debugging/testing purposes. */
	public String toString()
	{
		return heap.toString();
	}
	
	/**
	 * Performs up-heap bubbling
	 * The upward movement of a newly inserted entry by means of swaps.
	 * @param v
	 */
	protected void upHeap(Position<PriorityQueueEntry<K,V>> v) {
		Position<PriorityQueueEntry<K, V>> u;
		while(!heap.isRoot(v)) {
			u = heap.parent(v);
			if(comp.compare(u.element().getKey(), v.element().getKey()) <= 0) break;
			swap(u, v);
			v = u;
		}
	}
}
