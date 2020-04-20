package com.java.uttara;

import java.util.LinkedList;

public class BTree {

	BTNode root;
	int size;
	
	void insert(int data){
	   insert(this.root,data);
	}
	
	void traversalRecrs(){
		traversalRecrs(this.root);
	}
	
	void traversall() {
		traversall(this.root);
	}
	
	boolean isBST(){
		int min_value= 10;
		return isBST(this.root,min_value);
	}
	
	void printLeaf() {
		 printLeaf(this.root);
	}
	
	void printLeftBorder() {
		printLeftBorder(this.root);
	}
	
	void printRightBorder() {
		printRightBorder(this.root);
	}
	
    void printBoundry() {
		printBoundry(this.root);
	}
	//--------------------------------------------------------------------------------------
	
	void insert(BTNode root,int data){
		
		BTNode node = new BTNode(data);
		
		if(null == root)
		{
			this.root = node;
			size++;
			return ;
		}
		else
		{
		LinkedList<BTNode> ll = new LinkedList<>();  //Instead of Queue we used LinkedList
		ll.add(root);
		
		while(!ll.isEmpty()){
			BTNode temp = ll.removeFirst();
			
			if(temp.getLeft() != null){
				ll.add(temp.getLeft());
			}
			else{
				temp.setLeft(node);
				size++;
				return;
			}
			
			if(temp.getRight() != null){
				ll.add(temp.getRight());
			}
			else{
				temp.setRight(node);
				size++;
				return;
			}
		}
      }
	}
	
	//Traversal without recursion--------------------------------------------------
	
	void traversall(BTNode root) {
		if(root == null) {
			System.out.println("No elements in the Tree");
			return;
		}
		else {
           LinkedList<BTNode> ll= new LinkedList<BTNode>();
           
           ll.add(root);
           
           while(!ll.isEmpty()) {
        	  BTNode temp= ll.removeFirst();
        	  System.out.print(temp.getData()+",");
        	  
        	if(temp.getLeft()!=null) {
        		ll.add(temp.getLeft());
        	}
        	
        	if(temp.getRight()!=null) {
        		ll.add(temp.getRight());
        	}
        	   
           }
		}
	}
	
	
	//Recursive traversal-------------------------------------------------------
	
	void traversalRecrs(BTNode root){
		if(null == root)
			return;
		else{
			BTNode temp = root;
			System.out.print(temp.getData()+",");
			
			if(temp.getLeft()!=null)
				traversalRecrs(temp.getLeft());
			
			if(temp.getRight()!=null)
				traversalRecrs(temp.getRight());
			
			
		}
	}
	
	//check whether given Binary Tree is BST or Not--------------------------------------------------------------------------
	boolean isBST(BTNode root,int prev){
		if(null == root){
			return true;
		}else{
			boolean left = isBST(root.getLeft(),prev);
			if(!left)       			//Important condition to avoid unnecessary processing 
				return left;
			
			if(prev > root.getData())
				return false;
			
			prev = root.getData();
			
			boolean right = isBST(root.getRight(),prev);
			return right;
		}
	}
	
	//Print leaf nodes only---------------------------------------------------------------------------------
	void printLeaf(BTNode root) {
		if (null != root) {
			if (isLeaf(root)) {
				System.out.print(root.getData() + ",");
				return;
			} else {
                  printLeaf(root.getLeft());
                  printLeaf(root.getRight());
			}
		}
	}
	
	boolean isLeaf(BTNode node) {
		if((node.getLeft() == null && node.getRight() == null))
				return true;
		else 
			return false;
	}
	//Print left border of the tree-------------------------------------------------------------------------
	void printLeftBorder(BTNode root) {
		if (null == root)
			return;
		else if(isLeaf(root)) {
			return;
		}
		else {
			System.out.print(root.getData() + ",");   //To print the data from root to leaf
			
			if (root.getLeft() != null)
				printLeftBorder(root.getLeft());
			else if(root.getRight() != null)
				printLeftBorder(root.getRight());

			//System.out.print(root.getData() + ",");    //To print in reverse order  i.e from leaf to root
		}
	}
	
	void printRightBorder(BTNode node) {
		if(null==node)
			return;
		else if(isLeaf(node)) {
			return;
		}
		else {
			if(node.getRight()!=null)
				printRightBorder(node.getRight());
			else if(node.getLeft()!=null)
				printRightBorder(node.getLeft());
			
			System.out.print(node.getData()+",");
		}
	}
	
	void printBoundry(BTNode node) {
		if(null == node)
			return;
		else {
			System.out.print(node.getData()+",");
			
			printLeftBorder(node.getLeft());
			
			printLeaf(node.getLeft());
			printLeaf(node.getRight());
			
			printRightBorder(node.getRight());
		}
	}
}
