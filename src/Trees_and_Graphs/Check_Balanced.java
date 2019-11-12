package Trees_and_Graphs;

import utility.TreeNode;

public class Check_Balanced {

	public static void main(String[] args) {
		/* Tree as Input */
		/*
		 * Implement a function to check if a binary tree is balanced. For the purposes
		 * of this question, a balanced tree is defined to be a tree such that the
		 * heights of the two subtrees of any node never differ by more than one.
		 */
		TreeNode child6 = new TreeNode(27);
		TreeNode child7 = new TreeNode(28);

		TreeNode child2 = new TreeNode(23);
		child2.setLeft(child6);
		child2.setRight(child7);

		TreeNode child3 = new TreeNode(24);

		TreeNode child0 = new TreeNode(21);
		child0.setLeft(child2);
		child0.setRight(child3);

		TreeNode child4 = new TreeNode(25);
		TreeNode child5 = new TreeNode(26);

		TreeNode child1 = new TreeNode(22);
		child1.setLeft(child4);
		child1.setRight(child5);

		TreeNode root = new TreeNode(20);
		root.setLeft(child0);
		root.setRight(child1);

		Boolean balanced = isTreeBalanced(root);
		
		System.out.println("Tree is Balanced:"+balanced);
	}

	private static boolean isTreeBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}

	private static int checkHeight(TreeNode root) {
		//Integer.MIN_VALUE is using as Error
		if (root == null) {
			return -1;
		}
		int leftHeight = checkHeight(root.getLeft());
		if(leftHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE; //Pass Error Up
		}
		int rightHeight = checkHeight(root.getRight());
		if(rightHeight == Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		int heightDiff = Math.abs(leftHeight - rightHeight);
		if(heightDiff > 1) {
			return Integer.MIN_VALUE;
		}else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

}
