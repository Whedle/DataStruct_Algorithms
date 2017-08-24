
package binarytree_example;

import java.util.Iterator;

import arraylist_iterator_example.Position;
import exceptions_example.BoundaryViolationException;
import exceptions_example.EmptyTreeException;
import exceptions_example.InvalidPositionException;

/* Interface: Tree
 * @author - Wade Hedlesky
 * An interface for a tree where nodes can have an arbitrary number of children.
 * In other words, the number of children of a node is not specified.
 * 
 * @param <E>
 * 
 * Imports:		arraylist_iterator_example.Position
 * 				exceptions_example.BounaryViolationException
 * 				exceptions_example.EmptyTreeException
 * 				exceptions_example.InvalidPositionException
 */
public interface Tree<E> {
	/**Returns an iterable collection of the children of a given node
	 * @param Position<E> v
	 * @return iterable collection of the children of the node at position v.
	 * @throws InvalidPositionException
	 */
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;
	/**Returns true if node is external; false otherwise.
	 * @param Position<E> v
	 * @return true if node is external; false otherwise.
	 * @throws InvalidPositionException
	 */
	public boolean isExternal(Position<E> v) throws InvalidPositionException;
	/**Returns true if node is internal; false otherwise.
	 * @param Position<E> v
	 * @return true if node is internal; false otherwise.
	 * @throws InvalidPositionException
	 */
	public boolean isInternal(Position<E> v) throws InvalidPositionException;
	/**Returns true if node is the root node; false otherwise
	 * @param Position<E> v
	 * @return true if the node is the root node; false otherwise.
	 * @throws InvalidPositionException
	 */
	public boolean isRoot(Position<E> v) throws InvalidPositionException;
	/**Returns whether the tree is empty or not.
	 * @return true if tree is empty; false if tree is not empty.
	 */
	public boolean isEmpty();	
	/**Returns an iterator of the elements stored in the tree.
	 * An iterator is a software design pattern that abstracts the process of scanning through a collection of elements one element at a time.
	 * @return iterator of elements in tree.
	 */
	public Iterator<E> iterator();
	/**Returns the parent of a given node
	 * @param Position <E> v
	 * @return the parent of the node at position v.
	 * @throws BoundaryViolationException, InvalidPositionException
	 */
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	/**Returns an iterable collection of the nodes.
	 * @return iterable collection of nodes.
	 */
	public Iterable<Position<E>> positions();
	/** Returns the number of nodes in the tree.
	 * @return int number of nodes in tree.
	 */
	public E replace(Position<E> v, E e) throws InvalidPositionException;
	/**Returns the root of the tree.
	 * @return root of the tree.
	 */
	public Position<E> root() throws EmptyTreeException;
	/** Returns the number of nodes in the tree.
	 * @return int number of nodes in tree.
	 */
	public int size();
}
