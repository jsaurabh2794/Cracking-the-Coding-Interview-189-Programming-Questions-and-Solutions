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
		
	    TreeNode child2 = new TreeNode(12);

		TreeNode child3 = new TreeNode(15);

		TreeNode child0 = new TreeNode(14);
		child0.setLeft(child2);
		child0.setRight(child3);

		TreeNode child4 = new TreeNode(18);
		TreeNode child5 = new TreeNode(21);

		TreeNode child1 = new TreeNode(20);
		child1.setLeft(child4);
		child1.setRight(child5);

		TreeNode root = new TreeNode(16);
		root.setLeft(child0);
		root.setRight(child1);
		
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

	public void insertInOrder(int d) {
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