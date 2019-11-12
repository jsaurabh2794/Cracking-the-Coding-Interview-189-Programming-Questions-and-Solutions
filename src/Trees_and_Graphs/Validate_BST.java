package Trees_and_Graphs;

import utility.TreeNode;

public class Validate_BST {

	static int prevNode = Integer.MIN_VALUE;

	public static void main(String[] args) {

		/* Tree as Input */

		/*
		 *          6
		 *         / \ 
		 *         4  8
		 *        /\  /\
		 *       2 5  7 9
		 *       /\
		 *      1  3
		 *      
		 */
		TreeNode child6 = new TreeNode(1);
		TreeNode child7 = new TreeNode(3);

		TreeNode child2 = new TreeNode(2);
		child2.setLeft(child6);
		child2.setRight(child7);

		TreeNode child3 = new TreeNode(5);

		TreeNode child0 = new TreeNode(4);
		child0.setLeft(child2);
		child0.setRight(child3);

		TreeNode child4 = new TreeNode(7);
		TreeNode child5 = new TreeNode(9);

		TreeNode child1 = new TreeNode(8);
		child1.setLeft(child4);
		child1.setRight(child5);

		TreeNode root = new TreeNode(6);
		root.setLeft(child0);
		root.setRight(child1);

		// check Tree is BST or Not

		// Using Inorder Traversal---give sorted elements
		System.out.println("Tree is BST:" + validateBSTUsingInorder(root));
	}

	private static boolean validateBSTUsingInorder(TreeNode root) {
		return validateBST(root);
	}

	private static boolean validateBST(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return false;
		}
		validateBST(root.getLeft());
		// System.out.print(root.getData()+" ");

		if (prevNode <= root.getData()) {
			prevNode = root.getData();
		} else {
			return false;
		}

		validateBST(root.getRight());
		return true;
	}

}
