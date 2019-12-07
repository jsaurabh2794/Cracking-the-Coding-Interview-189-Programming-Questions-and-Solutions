package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import utility.TreeNode;

public class BST_Sequences {

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

		ArrayList<LinkedList<Integer>> allSeq = allSequences(root);
		for (LinkedList<Integer> list : allSeq) {
			System.out.println(list);
		}
		System.out.println(allSeq.size());
		
		
	}
	public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		/* One list is empty. Add the remainder to [a cloned] prefix and
		 * store result. */
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		/* Recurse with head of first added to the prefix. Removing the
		 * head will damage first, so we’ll need to put it back where we
		 * found it afterwards. */
		int headFirst = first.removeFirst();
		prefix.addLast(headFirst);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(headFirst);
		
		/* Do the same thing with second, damaging and then restoring
		 * the list.*/
		int headSecond = second.removeFirst();
		prefix.addLast(headSecond);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();	
		second.addFirst(headSecond);
	}
	
	public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
		
		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		} 
		
		LinkedList<Integer> prefix = new LinkedList<Integer>();
		prefix.add(node.getData());
		
		/* Recurse on left and right subtrees. */
		ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.getLeft());
		ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.getRight());
		
		/* Weave together each list from the left and right sides. */
		for (LinkedList<Integer> left : leftSeq) {
			for (LinkedList<Integer> right : rightSeq) {
				ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
				weaveLists(left, right, weaved, prefix);
				result.addAll(weaved);
			}
		}
		return result;
	}

}
