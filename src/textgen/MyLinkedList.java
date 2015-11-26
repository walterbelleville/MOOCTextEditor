package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	
	LLNode<E> head = new LLNode<E>(null);
	LLNode<E> tail = new LLNode<E>(null);
	//E data;
	int size = 0;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		
		//head.next = tail;
		//tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException("Null elements not permitted in List.");
		} else {
			LLNode<E> node = new LLNode <E>(element);
			if(tail.data == null) {
				head = tail = node;
			} else {
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
			size++;
			return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		E o = null;
		
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
		
			LLNode<E> node = new LLNode<E>(o);
			node = head;
			while(index > 0) {
				node = node.next;
				index--;
			}
			return node.data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		else if (element == null) {
			throw new NullPointerException("Null elements not permitted");
		}
		else if (index == 0) {
			LLNode<E> node = new LLNode<E>(element);
			node.next = head;
			head.prev = node;
			head = node;
			size++;
		}
		else if (index == size) {
			LLNode<E> node = new LLNode<E>(element);
			tail.next = node;
			node.prev = tail;
			tail = node;
			size++;
		} else {
			LLNode<E> node = new LLNode<E>(element);
			LLNode<E> nextone = new LLNode<E>(null);
			nextone = head;
			while (index > 0) {
				nextone = nextone.next;
				index--;
			}
			nextone.prev.next = node;
			node.prev = nextone.prev;
			node.next = nextone;
			nextone.prev = node;
			size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("index = " + index);
		} else {
			LLNode<E> node = new LLNode<E>(null);
			LLNode<E> temp = new LLNode<E>(null);
			node = head;
			if (index == 0){
				size--;
				E data = head.data;
				//head.next.prev = null;
				head = head.next;
				return data;
			} else {
				if (index == size - 1) {
					E data = tail.data;
					//tail.prev.next = null;
					tail = tail.prev;
					size--;
					return data;
				} else {
					while (index > 0) {
						node = node.next;
						index --;
					}
					size --;
					E data = node.data;
					node.prev.next = node.next;
					node.next.prev = node.prev;
					return data;
				}
			}
		}
	
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("index = " + index);
		}
		
		else if (element == null) {
			  throw new NullPointerException("MyLinkedList: Null elements not permitted in List.");
		}
		else {
			LLNode<E> node = new LLNode<E>(null);
			node = head;
			while (index > 0) {
				node = node.next;
				index--;
			}
			node.data = element;
			return element;
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
