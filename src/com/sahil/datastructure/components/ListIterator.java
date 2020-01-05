package com.sahil.datastructure.components;

import java.util.Iterator;

public class ListIterator<E> implements Iterator<E> {
	private Node<E> current;
	public ListIterator(Node<E> first) {
		current = first;
	}
	@Override
	public boolean hasNext() {
		return current != null;
	}
	@Override
	public E next() {
		Node<E> tempo = current;
		current = current.ref;
		return tempo.data;
	}    
}
