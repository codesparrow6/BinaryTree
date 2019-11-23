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
		b.traversal();
		
		//checking for isBST or Not-------------------------------------------------------
		System.out.println();
		boolean isBST= b.isBST();
		System.out.println("isBST ="+isBST);
		
	}

}
