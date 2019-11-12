package Trees_and_Graphs;

import utility.TreeNode;

public class Successor {

	public static void main(String[] args) {
		/*
		 * Write an algorithm to find the "next" node (i.e., in-order successor) of a
		 * given node in a binary search tree. You may assume that each node has a link
		 * to its parent.
		 */
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
		
		/*Parent node is given for particular node*/
		child0.setParent(root);
		child1.setParent(root);
		child2.setParent(child0);
		child3.setParent(child0);
		child6.setParent(child2);
		child7.setParent(child2);
		child4.setParent(child1);
		child5.setParent(child1);
		
		/*find InOrderSuccessor*/
		TreeNode node = findInorderSuccessor(child7);
        if(node != null)
		{
			System.out.println("Inorder Successor of node is:" + node.getData());

		}else
		{
			System.out.println("No Inorder Successor is present.");
		}
		
	}

	private static TreeNode findInorderSuccessor(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.getRight() != null) {
			return getSmallestElementNode(root.getRight());
		} else {
			TreeNode parent = root.getParent();
			while (parent != null && parent.getLeft() != root) {
				root = parent;
				parent = parent.getParent();
			}
			return parent;
		}
	}

	private static TreeNode getSmallestElementNode(TreeNode node) {
		if (node == null) {
			return null;
		}
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

}
