package com.java.uttara;

public class TestBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BTree b = new BTree();
		
		System.out.println("Inserting begins");
		b.insert(60);
		b.insert(20);
		b.insert(50);
		b.insert(30);
		b.insert(100);
		b.insert(40);
		b.insert(10);
		b.insert(70);
		System.out.println("All elements are inserted");
		
		System.out.println("Traversal output =");
		b.traversall();
		
		//checking for isBST or Not-------------------------------------------------------
		System.out.println();
		boolean isBST= b.isBST();
		System.out.println("isBST ="+isBST);
		
		System.out.println("Recursive Traversal output =");
		b.traversalRecrs();
		
		System.out.println();
		System.out.println("Print leaf-");
		b.printLeaf();
		
		System.out.println();
		System.out.println("Print left border-");
		b.printLeftBorder();
		
		System.out.println();
		System.out.println("Print Right border-");
		b.printRightBorder();
		
		System.out.println();
		System.out.println("Print the boundry-");
		b.printBoundry();		
		
		
		
	}

}
