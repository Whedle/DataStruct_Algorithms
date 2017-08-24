package binarytree_example;

import java.util.Iterator;

import arraylist_iterator_example.NodePositionList;
import arraylist_iterator_example.Position;
import arraylist_iterator_example.PositionList;
import exceptions_example.BoundaryViolationException;
import exceptions_example.EmptyTreeException;
import exceptions_example.InvalidPositionException;
import exceptions_example.NonEmptyTreeException;

/* Class: LinkedBinaryTree
 * @author - Wade Hedlesky
 * This class implements the BinaryTree interface. LinkedBinaryTree is implemented so as to create a binary tree data structure
 * using a nodes of type BTNode (included within the binarytree_example package). If you are having trouble understanding the 
 * LinkedBinaryTree class, I recommend viewing the comments and documentation of the BinaryTree interface.
 * This abstract data structure is covered in Chapter 7 of "Algorithms and Data Structures in Java" by Michael T. Goodrich and Roberto
 * Tamassia. I recommend reading chapter 3, then chapter 5, and then chapters 6 and 7 if you want an in depth understanding of
 * binary trees. Trees, and in particular binary trees, are used extensively in software engineering and computer science. All
 * computer science and software engineering students should be able to implement code similar to this and be able to explain what a
 * binary tree is. The BinaryTree and Tree interfaces have many comments, are well documented, and can help students who are having 
 * difficulty understanding the purpose of the methods in the LinkedBinaryTree class.
 * 
 * 		Conceptually, it may be helpful to picture the following:
 * 
 * 																	["root": 
 * 												(element, parent = null, children = {child 1, child 2}) ]
 * 
 * 									["child 1": 												["child 2":
 * 		(element, parent = root, children = {child 3, child 4}) ]	 		(element, parent = root, children = {child 5, child 6}) ]
 * 			["child 3":	...]			["child 4":	 ...]						["child 1":	...]			["child 1": ...]
 * 
 * 		Imagine that the list of children contains the nodes child 1 and child 2 (or for C programmers, that it is a list of pointers).
 * 
 * @param <E>
 * 
 * Imports:		java.util.Iterator
 * 				arraylist_iterator_example.NodePositionList
 * 				arraylist_iterator_example.Position
 * 				arraylist_iterator_example.PositionList
 * 				exceptions_example.BounaryViolationException
 * 				exceptions_example.EmptyTreeException
 * 				exceptions_example.InvalidPositionException
 * 				exceptions_example.NonEmptyTreeException
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {
	protected BTPosition<E> root;
	protected int size;
	
	/* This is the only constructor for this implementation of LinkedBinaryTree. */
	public LinkedBinaryTree()
	{
		root = null;
		size = 0;
	}

	public Position<E> addRoot(E e) throws NonEmptyTreeException{
		if(!isEmpty()) throw new NonEmptyTreeException("Tree already has a root");
		size = 1;
		root = createNode(e, null, null, null);
		return root;
	}
	
	public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		if (isInternal(v)) throw new InvalidPositionException("cannot attach from internal node");
		int newSize = size + T1.size() + T2.size();
		if(!T1.isEmpty()) {
			BTPosition<E> r1 = checkPosition(T1.root());
			vv.setLeft(r1);;
			r1.setParent(vv);
		}
		if(!T2.isEmpty() ) {
			BTPosition<E> r2 = checkPosition(T2.root());
			vv.setRight(r2);
			r2.setParent(vv);
		}
		size = newSize;
	}
	
	private BTPosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
		if (v == null || !(v instanceof BTPosition)) throw new InvalidPositionException("The position is invalid");
		return (BTPosition<E>) v;
	}
	
	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
		PositionList<Position<E>> children = new NodePositionList<Position<E>>();
		if (hasLeft(v)) children.addLast(left(v));;
		if (hasRight(v)) children.addLast(right(v));;
		return children;
	}
	
	public BTPosition<E> createNode(E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
		return new BTNode<E>(element, parent, left, right);
	}

	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		return (vv.getLeft() != null);
	}

	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		return (vv.getRight() != null);
	}
	
	public Position<E> insertLeft(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> leftPos = vv.getLeft();
		if(leftPos != null) throw new InvalidPositionException("Node already has a left child");
		BTPosition<E> ww = createNode(e, vv, null, null);
		vv.setLeft(ww);;
		size++;
		return ww;
	}
	
	public Position<E> insertRight(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> rightPos = vv.getRight();
		if(rightPos != null) throw new InvalidPositionException("Node already has a right child");
		BTPosition<E> ww = createNode(e, vv, null, null);
		vv.setRight(ww);;
		size++;
		return ww;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (!hasLeft(v) && !hasRight(v));
	}

	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root());
	}
	
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root());
	}
	
	public Iterator<E> iterator() {
		Iterable<Position<E>> positions = positions();
		PositionList<E> elements = new NodePositionList<E>();
		for (Position<E> pos: positions) elements.addLast(pos.element());
		return elements.iterator();
	}

	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> leftPos = vv.getLeft();
		if(leftPos == null) throw new BoundaryViolationException("No left child");
		return leftPos;
	}
	
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> parentPos = vv.getParent();
		if(parentPos == null) throw new BoundaryViolationException("No parent");
		return parentPos;
	}
	
	private void preorderPositions(Position<E> v, PositionList<Position<E>> pos) {
		pos.addLast(v);
		if(hasLeft(v)) preorderPositions(left(v), pos);
		if(hasRight(v)) preorderPositions(right(v), pos);
	}

	public Iterable<Position<E>> positions() throws InvalidPositionException {
		PositionList<Position<E>> positions = new NodePositionList<Position<E>>();
		if(size!=0) preorderPositions(root(),positions);
		return positions;
	}

	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		E temp = v.element();
		vv.setElement(e);
		return temp;
	}
	
	public E remove(Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> leftPos = vv.getLeft();
		BTPosition<E> rightPos = vv.getRight();
		if(leftPos != null && rightPos != null) throw new InvalidPositionException("Cannot remove node with two children");
		BTPosition<E> ww;
		if(leftPos != null)
			ww = leftPos;
		else if (rightPos != null)
			ww = rightPos;
		else
			ww = null;
		
		if(vv == root) {
			if(ww != null)
				ww.setParent(null);
			root = ww;
		}
		size--;
		return v.element();
	}
	
	public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		Position<E> rightPos = vv.getRight();
		if(rightPos == null) throw new BoundaryViolationException("No right child");
		return rightPos;
	}
	
	public Position<E> root() throws EmptyTreeException {
		if(root == null) throw new EmptyTreeException("The tree is empty");
		return root;
	}
	
	public Position<E> sibling(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> parentPos = vv.getParent();
		if(parentPos!=null) {
			BTPosition<E> sibPos;
			BTPosition<E> leftPos = parentPos.getLeft();
			if(leftPos == v) sibPos = parentPos.getRight();
			else sibPos = parentPos.getLeft();
			if(sibPos != null) return sibPos;
		}
		throw new InvalidPositionException("No sibling");
	}
	
	public int size() {
		return size;
	}
}
