
package arraylist_iterator_example;

import java.util.Iterator;

import exceptions_example.NoSuchElementException;

/* Class: ElementIterator
 * @author - Wade Hedlesky
 * An abstract iterator class that implements java.util.Iterator and throws an exception if a list uses null
 * in the place of the desired element <E>.
 * 
 * @param <E>
 * 
 * Imports:		java.util.Iterator
 * 				exceptions_example.NoSuchElementException
 */
public class ElementIterator<E> implements Iterator<E> 
{
	protected PositionList<E> list;
	protected Position<E> cursor;
	
	/**
	 * Constructor for ElementIterator. Sets variable list = L. The cursor is set to null if an empty list, 
	 * or to the first position in the list if the list has positions already within it.
	 * @param L
	 */
	public ElementIterator(PositionList<E> L)
	{
		list = L;
		cursor = (list.isEmpty())? null : list.first();
	}
	
	/**
	 * Checks if the position of the iterator (where the cursor is) is a valid position. If the cursor
	 * is null, it returns false, else it returns true.
	 */
	public boolean hasNext() {
		return (cursor!= null);
	}
	
	public E next() throws NoSuchElementException {
		if (cursor == null)
			throw new NoSuchElementException("No next element");
		E toReturn = cursor.element();
		cursor = (cursor == list.last())? null : list.next(cursor);
		return toReturn;
	}
}
