package com.java.uttara;

import java.util.LinkedList;

public class BTree {

	BTNode root;
	int size;
	
	boolean isEmpty(BTNode node) {
		if (node == null)
			return true;
		else
			return false;
	}
	
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
    
    int max() {
    	return max(this.root);
    }
    
    void delete() {
    	delete(this.root);
    	System.out.println("Check1="+isEmpty(this.root));
    	this.root=null;                                  //Important condition
    	System.out.println("Check2="+isEmpty(this.root));
    }
    
    int size() {
    	return size(this.root);
    }
    
    int height() {
    	return height(this.root);
    }
    
    BTNode copy() {
    	BTNode newRoot= copy(this.root);
    	System.out.println("\nNew tree copy------");
    	traversalRecrs(newRoot);
    	return newRoot;
    }
    
    BTNode mirror() {
    	BTNode newRoot = mirror(this.root);
    	System.out.println("\nNew Mirror tree-----");
    	traversalRecrs(newRoot);
    	return newRoot;
    }
    
    boolean find(int data) {
		return find(this.root,data);
		
	}
    
    boolean printAncestors(int data) {
    	return printAncestors(this.root,data);
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
	
	//Print right border of the tree-------------------------------------------------------------------------
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
	
	//Print the boundary of the tree------------------------------------------------------
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
	
	//Maximum value----------------------------------------------------------------------
	int max(BTNode node) {
		if (null == node)
			return 0;
		else {
			int left = max(node.getLeft());
			int right = max(node.getRight());

			int max=Math.max(left, right);
			return Math.max(max, node.getData());
		}
	}
	
	
	//Delete or dereference a tree------------------------------------------------------
	void delete(BTNode node) {
		if (null == node)
			return;
		if (isLeaf(node))
			return;
		else {
			delete(node.getLeft());
			node.setLeft(null);
			delete(node.getRight());
			node.setRight(null);
		}
	}
	
	//Compute size of Tree or number of nodes in a tree--------------------------------
	int size(BTNode node) {
		if(null==node) {
		  return 0;
		}
		else {
			int left = size(node.getLeft());
			int right= size(node.getRight());
			
			return 1+left+right;
		}
	}
	
	//Compute the height of the tree---------------------------------------------------
	int height(BTNode node) {
		if (null == node)
			return -1;
		else if (isLeaf(node))
			return 0;
		else {
            int left=height(node.getLeft());
            int right=height(node.getRight());
            
            return 1+Math.max(left,right);
		}

	}
	
	//Copy a tree----------------------------------------------------------------------
	BTNode copy(BTNode root) {
		if (null == root)
			return null;
		else {
			BTNode node = new BTNode(root.getData());

			BTNode left = copy(root.getLeft());
			node.setLeft(left);
			BTNode right = copy(root.getRight());
			node.setRight(right);

			return node;
		}
	}
	
	//Mirror a tree--------------------------------------------------------------------
	BTNode mirror(BTNode root) {
		if(null==root)
			return null;
		else {
			BTNode node = new BTNode(root.getData());
			
			BTNode left = mirror(root.getLeft());
			node.setRight(left);
			BTNode right = mirror(root.getRight());
			node.setLeft(right);
			
			return node;
		}
	}
		

	//Find/search a value in a tree----------------------------------------------------
	boolean find(BTNode node, int data) {
		if (null == node) {
			return false;
		}
		else {
			if (node.getData() == data)
				return true;
			
			boolean left = find(node.getLeft(), data);
			if (left)
				return true;

			boolean right = find(node.getRight(), data);
			return right;
		}
	}
	
	
	//Print Ancestors-------------------------------------------------------------------
	boolean printAncestors(BTNode node,int data) {
		if(null==node)
			return false;
		else if(data==node.getData())
			return true;
		else {
			boolean left = printAncestors(node.getLeft(), data);
			if(left) {
				System.out.println(node.getData());
				return true;
			}
			
			boolean right=printAncestors(node.getRight(), data);
			if(right) {
				System.out.println(node.getData());
			}
			return right;
		}
	}
	
	//Two trees are identical-----------------------------------------------------------
	
	
}
