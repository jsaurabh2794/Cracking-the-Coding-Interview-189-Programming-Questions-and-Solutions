package Trees_and_Graphs;

import utility.TreeNode;

public class Minimal_Tree {

	public static void main(String[] args) {

		// Input of Sorted Array
		int[] sortedArray = {2,4,6,8,10,12};
		
		//Create Minimal BST
		TreeNode node = createMinimalBST(sortedArray);
		 System.out.println("Preorder:");
		 preOrder(node);
		 System.out.println("\nPostorder:");
		 postOrder(node);
		 System.out.println("\nInorder:");
		 inorder(node);
	}

	private static TreeNode createMinimalBST(int[] sortedArray) {

		return createMinimalBST(sortedArray,0,sortedArray.length - 1);
	}

	private static TreeNode createMinimalBST(int[] sortedArray, int start, int end) {
		
		if(start > end)
		{
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(sortedArray[mid]);
		node.setLeft(createMinimalBST(sortedArray,start,mid - 1));
		node.setRight(createMinimalBST(sortedArray,mid+1,end));
        return node;
		
	}
	
	private static void inorder(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		inorder(node.getLeft());
		System.out.print(node.getData()+" ");
		inorder(node.getRight());
	}
	
	private static void preOrder(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		System.out.print(node.getData()+" ");
		inorder(node.getLeft());
		inorder(node.getRight());
	}	
	private static void postOrder(TreeNode node)
	{
		if(node == null)
		{
			return;
		}
		inorder(node.getLeft());
		inorder(node.getRight());
		System.out.print(node.getData()+" ");
	}

}
