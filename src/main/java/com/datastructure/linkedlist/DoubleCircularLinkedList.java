package com.datastructure.linkedlist;

import com.datastructure.node.DoubleNode;

public class DoubleCircularLinkedList {

	private DoubleNode head;
	private DoubleNode tail;
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public DoubleNode createDoubleLinkedList(int nodeValue) {
		head = new DoubleNode();
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		node.setPrev(head);
		node.setNext(node);

		head = node;
		tail = node;

		size = 1;// size =1
		return head;

	}

	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}

	public void traverseLinkedList() {

		if (existsLinkedList()) {

			DoubleNode tempNode = head;
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());

				if (i != size - 1) {
					System.out.print(" -> ");
				}
			}

		} else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println();

	}

	public void insertInLinkedList(int nodeValue, int location) {
		DoubleNode node = new DoubleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");
			return; // Linked List does not exists
		} else if (location == 0) {
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			head = node;
		} else if (location >= size) { // insert at last position
			node.setNext(head);
			node.setPrev(tail);
			head.setPrev(node);
			tail.setNext(node);
			tail = node; // to keep track of last node
		} else {
			DoubleNode tempNode = head;
			int index = 0;

			while (index < location - 1) {
				tempNode = tempNode.getNext();
				index++;
			}
			node.setPrev(tempNode);
			node.setNext(tempNode.getNext());
			tempNode.setNext(node);
			node.getNext().setPrev(node);
		}
		size++;

	}

	// Traverse Linked List reverse order
	void traverseLinkedListInReverseOrder() {
		if (existsLinkedList()) {
			DoubleNode tempNode = tail;
			System.out.println("\nPrinting Linked list in reverse order...");
			for (int i = 0; i < size; i++) {
				System.out.print(tempNode.getValue());
				if (i != size - 1) {
					System.out.print(" <- ");
				}
				tempNode = tempNode.getPrev();
			}
		} else {
			System.out.println("Linked List does not exists !");
		}
	}

	// Traverse Linked List
	void printHeadUsingTail() {
		if (existsLinkedList()) {
			System.out.println("\n\nPrinting Tail...");
			System.out.println(tail.getValue());

			System.out.println("\nPrinting Head using Head reference...");
			System.out.println(head.getValue());

			System.out.println("\nPrinting Head using Tail reference...");
			System.out.println(tail.getNext().getValue());

		} else {
			System.out.println("Linked List does not exists");
		}
	}

	// Deletion of linked list
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		if (tail == null) {
			System.out.println("Linked List is already deleted, nothing to delete anymore !");
			return;
		} else {
			head.setPrev(null);
			tail.setNext(null);
			head = null;
			tail = null;
			System.out.println("Linked List deleted successfully !");
		}
	}// end of method

	// Searching a specified value in linked list
	boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			DoubleNode tempNode = head;
			traverseLinkedList();
			for (int i = 0; i < size; i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! ");
		return false;
	}

	// Deletes a node having a given value
	public void deletionOfNode(int location) {
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
		} else if (location == 0) { // we want to delete first element
			if (getSize() == 1) { // if this is the only node in this list
				head.setNext(null);
				head.setPrev(null);
				head = tail = null;
				setSize(getSize() - 1);
				return;
			} else {
				head = head.getNext();
				head.setPrev(null);
				tail.setNext(head);
				setSize(getSize() - 1);
			}
		} else if (location >= getSize()) { // If location is not in range or equal, then delete last node
			if (getSize() == 1) { // if this is the only element in the list
				head.setNext(null);
				head.setPrev(null);
				tail = head = null;
				setSize(getSize() - 1);
				return;
			}
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
			setSize(getSize() - 1);
		} else { // if any inside node is to be deleted
			DoubleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			tempNode.getNext().setPrev(tempNode);
			setSize(getSize() - 1);
		} // end of else

	}// end of method

}
