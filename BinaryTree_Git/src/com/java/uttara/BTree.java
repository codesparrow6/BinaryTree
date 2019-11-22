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
}
