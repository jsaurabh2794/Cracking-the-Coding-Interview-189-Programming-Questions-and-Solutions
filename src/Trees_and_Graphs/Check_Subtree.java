package Trees_and_Graphs;

import utility.TreeNode;

public class Check_Subtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Tree as Input t1 */

		/*
		 *          16
		 *         /  \ 
		 *        14   20
		 *        /   / \
		 *       12  18 21
		 *      
		 *      
		 */
		
	    TreeNode child2 = new TreeNode(12);

		

		TreeNode child0 = new TreeNode(14);
		child0.setLeft(child2);


		TreeNode child4 = new TreeNode(18);
		TreeNode child5 = new TreeNode(21);

		TreeNode child1 = new TreeNode(20);
		child1.setLeft(child4);
		child1.setRight(child5);

		TreeNode root = new TreeNode(16);
		root.setLeft(child0);
		root.setRight(child1);
		

		/* Tree as Input t2 */

		/*
		 *         
		 *        14 
		 *        /   
		 *       12  
		 *      
		 *      
		 */
		
	    
		TreeNode child1_0 = new TreeNode(12);
		TreeNode root1 = new TreeNode(14);
		root1.setLeft(child1_0);
		//root1.setRight(child1_0);
		
		System.out.println(checkSubtree(root, root1));
		
		
	}

	
	public static boolean checkSubtree(TreeNode t1, TreeNode t2) // t2 is small, t1 is big
	{
		StringBuffer stringTraversalForT1 = new StringBuffer("");
		StringBuffer stringTraversalForT2 = new StringBuffer("");
	
		getTraversal(stringTraversalForT1,t1);
		getTraversal(stringTraversalForT2,t2);
		
		System.out.println(stringTraversalForT1);
		System.out.println(stringTraversalForT2);
		return stringTraversalForT1.indexOf(stringTraversalForT2.toString()) != -1;
		
	}


	private static void getTraversal(StringBuffer stringTraversal, TreeNode node) { //PreorderTraversal
		
		if(node == null)
		{
			stringTraversal.append("X ");
			return;
		}
		stringTraversal.append(node.getData()+" ");
		getTraversal(stringTraversal, node.getLeft());
		getTraversal(stringTraversal, node.getRight());
	}
	
}
