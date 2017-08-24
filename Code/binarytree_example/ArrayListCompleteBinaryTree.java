
package binarytree_example;

import java.util.ArrayList;
import java.util.Iterator;

import arraylist_iterator_example.NodePositionList;
import arraylist_iterator_example.Position;
import arraylist_iterator_example.PositionList;
import exceptions_example.BoundaryViolationException;
import exceptions_example.EmptyTreeException;
import exceptions_example.InvalidPositionException;

/* Class: ArrayListCompleteBinaryTree
 * @author - Wade Hedlesky
 * This class implements the CompleteBinaryTree interface, which extends the BinaryTree interface. BinaryTree extends the Tree interface.
 * This particular class was created with the intention of being complementary to the class HeapPriorityQueue, that can be
 * found with the priorityqueue_example package (one of the packages I originally uploaded to GitHub for my students/colleagues).
 * If you are seeing this class but do not have access to the priorityqueue_example package, I recommend either finding the original
 * documentation and packages, or looking in the textbook "Algorithms and Data Structures in Java" by Michael T. Goodrich and
 * Roberto Tamassia. While the entire class is not covered in the text, most of the data structures for building it is discussed
 * in great detail and the book includes examples and most of the code required to program similar data structures, including priority
 * queues designed for heap sorting.
 * 
 * @param <E>
 * 
 * Imports:		java.util.ArrayList
 * 				java.util.Iterator
 * 				arraylist_iterator_example.NodePositionList
 * 				arraylist_iterator_example.Position
 * 				arraylist_iterator_example.PositionList
 * 				exceptions_example.BoundaryViolationException
 * 				exceptions_example.EmptyTreeException
 * 				exceptions_example.InvalidPositionException
 */
public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> 
{
	/* 
	 * (non-Javadoc)
	 * An array list of the static helper class BTPos (binary tree position).
	 */

	protected ArrayList<BTPos<E>> T;
	
	/* Class: BTPos
	 * (non-Javadoc)
	 * This is a static, helper class that implements Position and is contained within the ArrayListCompleteBinaryTree class.
	 * 
	 * @param <E> 
	 * 
	 * Dependency:	arraylist_iterator_example.Position
	 */
	protected static class BTPos<E> implements Position<E>
	{
		E element;
		int index;
		public BTPos(E elem, int i)
		{
			element = elem;
			index = i;
		}

		public E element() {
			return element;
		}
		
		public int index() {
		return index;
		}
		
		public E setElement(E elem) {
			E temp = element;
			element = elem;
			return temp;
		}
	}

	/* 
	 * (non-Javadoc)
	 * This is the only constructor for ArrayListCompleteBinaryTree in this version. 
	 */
	public ArrayListCompleteBinaryTree()
	{
		T = new ArrayList<BTPos<E>>();
		T.add(0, null);
	}
	
	/*
	 * (non-Javadoc)
	 *  This method adds a new element to the binary tree. 
	 */
	public Position<E> add(E elem) {
		int i = size() + 1;
		BTPos<E> p = new BTPos<E>(elem,i);
		T.add(i,p);
		return p;
	}
	
	/* 
	 * (non-Javadoc)
	 * checkPostion(..) tests to see if the input Position v is null or not an instance of the static helper class BTPos. 
	 * If either of these is true, checkPosition(..) throws InvalidPositionException(..).
	 */
	public BTPos<E> checkPosition(Position<E> v) throws InvalidPositionException {
		if(v == null || !(v instanceof BTPos)) throw new InvalidPositionException("Position is invalid");
		return (BTPos<E>) v;
	}
	
	/* 
	 * (non-Javadoc)
	 * Returns a PositionList of the children of an input Position v */
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		PositionList<Position<E>> children = new NodePositionList<Position<E>>();
		if (hasLeft(v)) children.addLast(left(v));;
		if (hasRight(v)) children.addLast(right(v));;
		return children;
	}
	
	/* 
	 * (non-Javadoc)
	 * Calls checkPosition(v) on the input position and returns the left child if the position is valid. 
	 * hasLeft(..) throws InvalidPositionException if the Position is not valid.
	 */
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return (2*vv.index() <= size());
	}

	/* 
	 * (non-Javadoc)
	 * Calls checkPosition(v) on the input position and returns the left child if the position is valid. 
	 * hasRight(..) throws InvalidPositionException if the Position is not valid.
	 * @see binarytree_example.BinaryTree#hasRight(arraylist_iterator_example.Position)
	 */
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return (2*vv.index() + 1 <= size());
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		return hasLeft(v);
	}

	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return (vv.index() == 1);
	}
	
	/*
	 * (non-Javadoc)
	 * @see binarytree_example.Tree#iterator()
	 */
	public Iterator<E> iterator() {
		ArrayList<E> list = new ArrayList<E>();
		Iterator<BTPos<E>> iter = T.iterator();
		iter.next();
		while(iter.hasNext()) 
			list.add(iter.next().element());
		return list.iterator();
	}
	
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		if(!hasLeft(v)) throw new BoundaryViolationException("No left child");
		BTPos<E> vv = checkPosition(v);
		return T.get(2*vv.index());
	}
	
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		if(isRoot(v)) throw new BoundaryViolationException("No parent");
		BTPos<E> vv = checkPosition(v);
		return T.get(vv.index()/2);
	}
	
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
		if(size()!=0) preorderPositions(root(),positions);
		return positions;
	}
	
	public E remove() {
		if(isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.remove(size()).element();
	}
	
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPos<E> vv = checkPosition(v);
		return vv.setElement(e);
	}
	
	private void preorderPositions(Position<E> v, PositionList<Position<E>> pos) {
		pos.addLast(v);
		if(hasLeft(v)) preorderPositions(left(v), pos);
		if(hasRight(v)) preorderPositions(right(v), pos);
	}
	
	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		if(!hasRight(v)) throw new BoundaryViolationException("No right child");
		BTPos<E> vv = checkPosition(v);
		return T.get(2*vv.index() + 1);
	}
	
	public Position<E> root() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.get(1);
	}
		
	public int size() {
		return T.size() - 1;
	}
}
