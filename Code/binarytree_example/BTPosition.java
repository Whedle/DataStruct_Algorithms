package binarytree_example;

import arraylist_iterator_example.Position;

/* Interface: BTPosition
 * @author - Wade Hedlesky
 * This interface extends the Position interface used in the arraylist_iterator_example package. This particular interface specifies additional
 * methods that will be required to create binary tree nodes. For instance, the class BTNode implements this interface.
 * 
 * @param <E>
 * 
 * Imports:		arraylist_iterator_example.Position
 */
public interface BTPosition<E> extends Position<E> {
	/**Sets the element stored at this position.
	 * @param e
	 */
	public void setElement(E e);
	/**Sets the left child of this position.
	 * @param v
	 */
	public void setLeft(BTPosition<E> v);
	/**Sets the right child of this position.
	 * @param v
	 */
	public void setRight(BTPosition<E> v);
	/**Sets the parent of this position.
	 * @param v
	 */
	public void setParent(BTPosition<E> v);
	/**Returns the left child of this position.
	 * @return left child of node
	 */
	public BTPosition<E> getLeft();
	/**Returns the right child of this position.
	 * @return right child of node
	 */
	public BTPosition<E> getRight();
	/**Returns the parent of this position.
	 * @return parent of node
	 */
	public BTPosition<E> getParent();
}
