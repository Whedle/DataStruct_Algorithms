
package arraylist_iterator_example;

import java.util.Iterator;

import exceptions_example.BoundaryViolationException;
import exceptions_example.EmptyListException;
import exceptions_example.InvalidPositionException;

/* Class: NodePositionList: 
 * @author - Wade Hedlesky
 * This is a variant on the class NodePositionList covered in "Data Structures and Algorithms in Java".
 * A variant of this class was also used in the neural-net program I presented in December of 2016. 
 * I mention this because many students who are first introduced to data structures may be under the impression 
 * that simple classes and structures are not valuable (because more advanced topics like AI are considered more 
 * exciting). It is important to note that many times it is the reconfiguring and reuse of code and standard 
 * data structures and algorithms that produces the best software with the least work and cost, and that complex
 * systems are typically combinations and variations of the simple data structures and algorithms we use everyday.
 * 
 * Students who have taken Software Engineering I or later will recognize this this concept as software reuse.
 * In "Software Engineering" by "Ian Sommerville", the process "Integration and Configuration" is first discussed
 * in chapter 2, and then in more detail for chapter 7, and 15.
 * 
 * Another important concept that should be noted is that avoiding rework is extremely important within engineering
 * as a whole. Just as optimizing an algorithm by avoiding unnecessary operations is a major focus of computer science,
 * so to is optimizing software processes and software production.
 * 
 * Imports:		java.util.Iterator
 * 				exceptions_example.BounaryViolationException
 * 				exceptions_example.EmptyListException
 * 				exceptions_example.InvalidPositionException
 */
public class NodePositionList<E> implements PositionList<E> {

	protected int numElemInList;
	protected DNode<E> header, trailer; // sentinel nodes keep track of the ends of the list.
		
	public NodePositionList() {
		numElemInList = 0;
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(header, null, null);
		header.setNext(trailer);
	}
		
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElemInList++;
		DNode<E> newNode = new DNode<E>(v, v.getNext(), element);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
	}
	
	public void addBefore(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElemInList++;
		DNode<E> newNode = new DNode<E>(v.getPrev(), v, element);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
	}
	
	public void addFirst(E element) {
		numElemInList++;
		DNode<E> newNode = new DNode<E>(header, header.getNext(), element);
		header.getNext().setPrev(newNode);;
		header.setNext(newNode);
	}

	public void addLast(E element) {
		numElemInList++;
		DNode<E> newNode = new DNode<E>(trailer, null, element);
		trailer.setNext(newNode);
		trailer = newNode;
	}
	
	protected DNode<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if (p == null)
			throw new InvalidPositionException("Null position passed to NodeList");
		if (p == header)
			throw new InvalidPositionException("The header node is not a valid position");
		if (p == trailer)
			throw new InvalidPositionException("The trailer node is not a valid position");
		try {
			DNode<E> temp = (DNode<E>) p;
			if ((temp.getPrev() == null) || (temp.getNext() == null))
				throw new InvalidPositionException("Position does not belong to a valid NodeList");
			return temp;
		}
		catch (ClassCastException e) {
			throw new InvalidPositionException("Position is wrong type for this list");
		}
	}

	public Position<E> first() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException ("List is empty");
		return header.getNext();
	}
	
	public boolean isEmpty() {
		return (numElemInList == 0);
	}
	
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}
	
	public Position<E> last() {
		return trailer;
	}

	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v = checkPosition(p);
		DNode<E> next = v.getNext();
		if(next == trailer)
			throw new BoundaryViolationException("Cannot advance past the end of the list.");
		return next;
	}

	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNode<E> v = checkPosition(p);
		DNode<E> prev = v.getPrev();
		if (prev == header)
			throw new BoundaryViolationException("Cannot advance past the beginning of the list.");
		return prev;
	}
	
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> P = new NodePositionList<Position<E>>();
		if(!isEmpty()) {
			Position<E> p = first();
			while (true) {
				P.addLast(p);;
				if(p == last())
					break;
				p = next(p);
			}
		}
		return P;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		numElemInList--;
		DNode<E> vPrev = v.getPrev();
		DNode<E> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		E vElem = v.element();
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNode<E> v = checkPosition(p);
		E oldElement = v.element();
		v.setElement(element);
		return oldElement;
	}	
	
	public int size() {
		return numElemInList;
	}
}
