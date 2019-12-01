package Trees_and_Graphs;

import utility.TreeNode;

public class First_Common_Ancestor {

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
		
		/*Parent node is given for particular node*/
		child0.setParent(root);
		child1.setParent(root);
		child2.setParent(child0);
		child3.setParent(child0);
		child6.setParent(child2);
		child7.setParent(child2);
		child4.setParent(child1);
		child5.setParent(child1);
		
		TreeNode ancestorNode = firstCommonAncestor(root,child6,child7);
		System.out.println("Common Node is: "+ancestorNode.getData());
	}

	private static TreeNode firstCommonAncestor(TreeNode root, TreeNode child2, TreeNode child5) {
		
		/*First, Have to check wheather both nodes are present in this tree or not.*/
		if(!covers(root,child2) || !covers(root,child5)) {
			return null;
		}
		
		return findAncestor(root,child2,child5);
	}

	private static TreeNode findAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null || root == node1 || root == node2) {
			return root;
		}
		boolean node1IsOnLeft = covers(root.getLeft(),node1);
		boolean node2IsOnLeft = covers(root.getLeft(), node2);
		
		if(node1IsOnLeft!=node2IsOnLeft) { // nodes are of different side of root.
			return root;
		}
		
		// if roads are of same side
		TreeNode childSide = node1IsOnLeft ? root.getLeft():root.getRight();
		return findAncestor(childSide, node1, node2);
	}

	private static boolean covers(TreeNode root, TreeNode node) {
		if(root == null) {
			return false;
		}
		if(root == node) {
			return true;
		}
		return covers(root.getLeft(),node) || covers(root.getRight(),node);
	}

}
