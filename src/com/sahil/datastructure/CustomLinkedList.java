package com.sahil.datastructure;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.sahil.datastructure.components.ListIterator;
import com.sahil.datastructure.components.Node;

public class CustomLinkedList<E> implements Iterable<E>{

	private int size = 0;
	private Node<E> head;
	private Node<E> tail;


	public void add(E object) {
		Node<E> node = new Node<E>();
		node.data = object;
		node.ref = null;

		if(head == null && tail == null) {
			head = new Node<>();
			tail = new Node<>();
			head.ref = tail.ref = node;
		}else {
			tail.ref.ref = node;
			tail.ref = node;
		}
		size++;
	}

	public void add(E object, int index) {
		Node<E> node = new Node<E>();
		node.data = object;
		if(size == index) {
			add(object);
		}else if(index > size){
			throw new ArrayIndexOutOfBoundsException();
		}else {
			int counter = 0;
			Node<E> currentNode = head.ref;
			Node<E> tempNode = null;

			while(currentNode != null) {
				if(counter == index-1) {
					tempNode = currentNode;
				}
				if(counter == index) {
					tempNode.ref = node;
					node.ref = currentNode;
					break;
				}

				currentNode = currentNode.ref;
				counter++;
			}
			size++;
		}
	}

	public E delete(int index){

		if(index > size - 1){
			throw new ArrayIndexOutOfBoundsException();
		}

		Node<E> nodeToBeDeleted = null;

		if(index == 0) {
			nodeToBeDeleted = head.ref;
			head.ref = head.ref.ref;
			return nodeToBeDeleted.data;
		}


		int counter = 0;
		Node<E> currentNode = head.ref;
		Node<E> prevNode = null;
		Node<E> targetNode = null;

		while(currentNode != null) {

			if(targetNode != null && prevNode != null) {
				prevNode.ref = currentNode;
				size--;
				return nodeToBeDeleted.data;
			}

			if(counter == index-1) {
				prevNode = currentNode;
			}

			if(counter == index) {
				targetNode = currentNode;
				nodeToBeDeleted = currentNode;
			}


			currentNode = currentNode.ref;
			counter++;
		}

		if(nodeToBeDeleted != null) {
			prevNode.ref = null;
			tail.ref = prevNode;
			size --;
			return nodeToBeDeleted.data;
		}
		return null;

	}

	public int size() {
		return size;
	}
	
	public Stream<E> stream() {
		Iterator<E> it = iterator();
		int characteristics = 0; 
		Spliterator<E>spliterator=Spliterators.spliterator(it,size(),characteristics);
		return StreamSupport.stream(spliterator, false);
	}


	@Override
	public Iterator<E> iterator() {
		ListIterator<E> iterator = new ListIterator<>(head.ref);
		return iterator;
	}
}



