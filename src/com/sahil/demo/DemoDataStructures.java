package com.sahil.demo;

import com.sahil.datastructure.CustomLinkedList;

public class DemoDataStructures {

	public static void main(String[] args) {
		
		CustomLinkedList<String> l = new CustomLinkedList<>();
		
		l.add("First Insertion");
		l.add("Second Insertion");
		l.add("Third Insertion");
		l.add("Fourth Insertion");
		l.add("Fifth Insertion");
		l.add("Sixth Insertion");
		l.add("Seventh Insertion");

		l.add("Between 3rd and 4th", 3);
		
		//l.add("Demo", 10); //IndexOutOfBoundException
		
		System.out.println("Size -> "+ l.size());
		System.out.println("Element deleted from list -> "+l.delete(5));
		System.out.println("Size -> "+ l.size());
		
		//l.delete(10);   //IndexOutOfBoundException
		
		System.out.println("---");
		
		l.stream().forEach(System.out::println);
	}

}
