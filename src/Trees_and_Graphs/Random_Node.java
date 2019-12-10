package Trees_and_Graphs;

import java.util.Random;

public class Random_Node {

	public static void main(String[] args) {

		/* Tree as Input */

		/*
		 *          16
		 *         /  \ 
		 *        14   20
		 *        /\   / \
		 *       12 15 18 21
		 *      
		 *      
		 */

		TreeNode root = new TreeNode(16);
		root.insertInOrder(14);
		root.insertInOrder(20);
		root.insertInOrder(12);
		root.insertInOrder(15);
		root.insertInOrder(18);
		root.insertInOrder(21);
		
		System.out.println(root.getRandomNode().data());
	}

}

class TreeNode {
	private int data;
	public TreeNode left;
	public TreeNode right;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	
	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public TreeNode getLeft() {
		return left;
	}


	public void setLeft(TreeNode left) {
		this.left = left;
	}


	public TreeNode getRight() {
		return right;
	}


	public void setRight(TreeNode right) {
		this.right = right;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}

	public void insertInOrder(int d) { // Create BST
		if (d <= data) {
			if (left == null) {
				left = new TreeNode(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				right = new TreeNode(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public int size() {
		return size;
	}

	public int data() {
		return data;
	}

	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
}