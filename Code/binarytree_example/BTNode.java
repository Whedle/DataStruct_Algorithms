package binarytree_example;

/* Class: BTNode
 * @author - Wade Hedlesky
 * A Binary Tree Node that implements the interface BTPosition<E>. This is a useful class for creating binary trees, though
 * in practice it is better to use a subclass (a class that extends this class). Binary tress are discussed in chapters 7 and 8
 * of the textbook "Data Structures and Algorithms in Java" by Michael T. Goodrich and Roberto Tamassia. If you are taking a data
 * structures and algorithms course, or alternatively, if you are attempting to learn some Java best programming practices, I
 * highly recommend reading through it. Another good book for students and professionals learning Java is "Big Java: Early Objects"
 * by Cay Horstmann.
 *
 * @param <E>
 */
public class BTNode<E> implements BTPosition<E> {
	private E element;
	private BTPosition<E> left, right, parent;
	
	public BTNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) 
	{
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}
	
	public E element() {
		return element;
	}
	
	public BTPosition<E> getLeft() {
		return left;
	}
	
	public BTPosition<E> getRight() {
		return right;
	}
	
	public BTPosition<E> getParent() {
		return parent;
	}
	
	public void setElement(E e) {
		element = e;
	}
	
	public void setRight(BTPosition<E> v) {
		right = v;
	}
	
	public void setLeft(BTPosition<E> v) {
		left = v;
	}
	
	public void setParent(BTPosition<E> v) {
		parent = v;
	}
}
