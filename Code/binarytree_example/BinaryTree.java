
package binarytree_example;

import arraylist_iterator_example.Position;
import exceptions_example.BoundaryViolationException;
import exceptions_example.InvalidPositionException;

/* Interface: Binary Tree
 * 
 * @author - Wade Hedlesky
 * This interface specifies additional methods that allow for a tree to have 0, 1, or 2 child nodes. It is implemented
 * by both the ArrayListCompleteBinaryTree class and the LinkedBinaryTree class. It extends the Tree interface.
 * 
 * @param <E>
 * 
 * Imports:		arraylist_iterator_example.Position
 * 				exceptions_example.BounaryViolationException
 * 				exceptions_example.InvalidPositionException
 */
public interface BinaryTree<E> extends Tree<E>{
	/**Returns the left child of a given node.
	 * @param Position<E> v
	 * @return left child of node.
	 * @throws InvalidPositionException
	 * @throws BoundaryViolationException
	 */
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	/**Returns the right child of a given node.
	 * @param Position<E> v
	 * @return right child of node.
	 * @throws InvalidPositionException
	 * @throws BoundaryViolationException
	 */
	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException;
	/**Returns true if the node has a left child.
	 * @param Position<E> v
	 * @return true if node has a left child; false otherwise.
	 * @throws InvalidPositionException
	 */
	public boolean hasLeft(Position<E> v) throws InvalidPositionException;
	/**Returns true if the node has a right child.
	 * @param Position<E> v
	 * @return true if node had a right child; false otherwise.
	 * @throws InvalidPositionException
	 */
	public boolean hasRight(Position<E> v) throws InvalidPositionException;
}