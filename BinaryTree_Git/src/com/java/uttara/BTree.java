package com.java.uttara;

import java.util.LinkedList;

public class BTree {

	BTNode root;
	int size;
	
	void insert(int data){
	   insert(this.root,data);
	}
	
	void traversal(){
		traversal(this.root);
	}
	
	boolean isBST(){
		int min_value= 10;
		return isBST(this.root,min_value);
	}
	
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
		LinkedList<BTNode> ll = new LinkedList<>();
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
	
	void traversal(BTNode root){
		if(null == root)
			return;
		else{
			BTNode temp = root;
			System.out.print(temp.getData()+",");
			
			if(temp.getLeft()!=null){
				traversal(temp.getLeft());
			}
			
			if(temp.getRight()!=null)
				traversal(temp.getRight());
		}
	}
	
	//check whether given Binary Tree is BST or Not--------------------------------------------------------------------------
	boolean isBST(BTNode root,int prev){
		if(null == root){
			return true;
		}else{
			boolean left = isBST(root.getLeft(),prev);
			if(!left)
				return left;
			
			if(prev > root.getData())
				return false;
			
			prev = root.getData();
			
			boolean right = isBST(root.getRight(),prev);
			return right;
		}
	}
}
