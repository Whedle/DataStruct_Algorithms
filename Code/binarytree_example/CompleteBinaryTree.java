
package binarytree_example;

import arraylist_iterator_example.Position;

/* Interface: CompleteBinaryTree
 * @author - Wade Hedlesky
 * The existence of two additional methods, add and remove, to the BinaryTree Interface allows for the Complete Binary Tree Property
 * of a heap to be more efficiently implemented. Complete Binary Trees are ADTs that have all the methods of BinaryTree as well as these two
 * methods, and that uses only these update operations so as to guarantee that the binary tree remains complete.
 * 
 * @param <E>
 * 
 * Imports:		arraylist_iterator_example.Position
 */
public interface CompleteBinaryTree<E> extends BinaryTree<E> {
	public Position<E> add(E elem);
	public E remove();
}
