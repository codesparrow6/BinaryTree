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
		
		System.out.println("Level Order Traversal output =");
		b.traversall();
		
		//checking for isBST or Not-------------------------------------------------------
		System.out.println();
		boolean isBST= b.isBST();
		System.out.println("isBST ="+isBST);
		
		System.out.println("Recursive Pre-order Traversal output =");
		b.traversalRecrs();
		
		System.out.println("\nPrint leaf-");
		b.printLeaf();
		
		System.out.println("\nPrint left border-");
		b.printLeftBorder();
		
		System.out.println("\nPrint Right border-");
		b.printRightBorder();
		
		System.out.println("\nPrint the boundry-");
		b.printBoundry();	
		
		int maxVal=b.max();
		System.out.println("\nMaxValue="+maxVal);
		
		//b.delete();                           Deletes the tree so it commented.
		
		
		int size=b.size();
		System.out.println("Size of Tree="+size);
		
		int h=b.height();
		System.out.println("Height of Tree="+h);
		
		BTNode copyTree= b.copy();
		
		BTNode mirrorTree=b.mirror();
		
		boolean findData = b.find(40);
		System.out.println("\nSearch for given data in the tree -"+ findData);
		
		System.out.println("\nPrint Ancestors-----------");
		boolean ancestors = b.printAncestors(40);
		
		System.out.println("\nFind the level -------");
		int level = b.level(70);
		System.out.println("Level="+level);
		int level_dup = b.level(710,0);
		System.out.println("level_dup ="+level_dup);
	}

}
