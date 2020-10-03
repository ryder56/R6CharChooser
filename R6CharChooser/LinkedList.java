//**************
// CSE 205: #11333 - T,Th - 4:30-5:45
// Assignment: assignment #6
// Author: Ryder Roth - 1216790822
// Description: This is the generic linked list class.
//**************
import java.util.NoSuchElementException;

public class LinkedList<T> {
	private Node head = null;
	private int size = 0;

	public void add(T o) {
		Node newNode = new Node();
		newNode.data = o;
		if(size == 0)
			head = newNode;
		else {
			Node currentNode = head;
			while(currentNode.next != null)
				currentNode = currentNode.next;
			currentNode.next = newNode;
		}
		size++;
	}

	public void insert(int index, T o) {
		if(size<index)
			throw new NoSuchElementException();
		Node currentNode = head;
		Node newNode = new Node();
		newNode.data = o;
		for(int i = 0; i<index-1 ;i++) 
			currentNode = currentNode.next;
		if(index == 0) {
			newNode.next = currentNode;
			head = newNode;
		}
		else {
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
		size++;
	}
	
	public void remove(int index) {
		if(size<index)
			throw new NoSuchElementException();
		Node currentNode = head;
		for(int i = 0; i<index-1; i++)
			currentNode = currentNode.next;
		if(index == 0)
			head = head.next;
		else
			currentNode.next = currentNode.next.next;
		size--;
	}

	public T get(int index) {
		if(size<index)
			throw new NoSuchElementException();
		Node currentNode = head;
		for(int i = 0; i<index; i++)
			currentNode = currentNode.next;
		return currentNode.data;
	}

	public int size() {
		return size;
	}

	class Node {
		public T data = null;
		public Node next = null;
	}
}