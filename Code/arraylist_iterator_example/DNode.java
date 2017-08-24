
package arraylist_iterator_example;

import exceptions_example.InvalidPositionException;

/* Class: DNode
 * @author - Wade Hedlesky
 * In "Data Structures & Algorithms in Java" by Michael T. Goodrich and Roberto Tamassia, this example of a DNode
 * for a doubly linked list is discussed thoroughly. It is a standard abstract class used by many organizations and
 * engineers (though typically a subclass is used that includes additional methods and specifications for the particular
 * project). 
 * 
 * If you are a student, please ask me if you are having difficulty understanding this conceptually.
 * 			-Wade
 * 
 * It may be helpful to imagine a doubly linked list as the following:
 * 
 * 		[ null (head) | (data) | pointer ] <-> [ pointer | (data) | pointer ] <-> ... <-> [ pointer | (data) | null (tail) ]
 * 
 * where "data" is the element of type <E> (an abstract type). I recommend looking at chapter 3, 6, and 7 in the textbook for
 * more clarification. If you are not one of my students, I highly recommend either asking your professor/instructor or purchasing 
 * and reading the book. 
 * 
 * @param <E>
 * 
 * Imports:		exceptions_example.InvalidPositionException.java
 */
public class DNode<E> implements Position<E> {
	private DNode<E> prev, next;
	private E element;
	
	/**
	 * Constructor for DNode. sets variables prev = newPrev, next = newNext, and element = elem.
	 * @param newPrev
	 * @param newNext
	 * @param elem
	 */
	public DNode(DNode <E> newPrev, DNode<E> newNext, E elem) {
		prev = newPrev;
		next = newNext;
		element = elem;
	}
	
	public E element() throws InvalidPositionException {
		if ((prev == null) && (next == null))
			throw new InvalidPositionException("Position is no tin a list");
		return element;
	}
	
	// Accessor methods
	public DNode<E> getNext() {
		return next; 
	}
	
	public DNode<E> getPrev() { 
		return prev; 
	}
	
	// Mutator methods
	/**
	 * Sets the variable next to the input DNode<E> newNext.
	 * @param newNext
	 */
	public void setNext(DNode<E> newNext) { 
		next = newNext; 
	}
	
	/**
	 * Sets the variable prev to the input DNode<E> newPrev.
	 * @param newPrev
	 */
	public void setPrev(DNode<E> newPrev) { 
		prev = newPrev; 
	}
	
	/**
	 * Sets element to the input E newElement.
	 * @param newElement
	 */
	public void setElement(E newElement) { 
		element = newElement; 
	}

}
