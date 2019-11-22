package com.java.uttara;

public class BTNode {

	private int data;
	private BTNode right,left;
	
	public BTNode(int data){
		this.data=data;
	}

	public void setData(int data){
		this.data= data;
	}
	
	public int getData(){
		return data;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}
	
}
