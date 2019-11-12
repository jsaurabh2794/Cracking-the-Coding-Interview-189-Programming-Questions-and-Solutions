package Trees_and_Graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import utility.Display;
import utility.TreeNode;

public class List_of_Depths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Binary Tree Created
		/*
		 * Given a binary tree, design an algorithm which creates a linked list of all
		 * the nodes at each depth (e.g., if you have a tree with depth D, you'll have D
		 * linked lists).
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

		ArrayList<LinkedList<TreeNode>> data = createLevelLinkedList(root);
		System.out.println(data);
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedListByBFSApproach(root, lists);
		System.out.println(lists);
	}

	private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {

		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, list, 0);
		return list;

	}

	private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		// Trying DFS Approach
		if (root == null) { // base condition
			return;
		}
		LinkedList<TreeNode> list;
		if (lists.size() == level) // new Level
		{
			list = new LinkedList<TreeNode>(); // create new Linked List
			lists.add(list);

		} else {
			list = lists.get(level); // give the existing LinkedList on that level
		}
		list.add(root); // add node to that list
		createLevelLinkedList(root.getLeft(), lists, level + 1);
		createLevelLinkedList(root.getRight(), lists, level + 1);
	}

	private static void createLevelLinkedListByBFSApproach(TreeNode root, ArrayList<LinkedList<TreeNode>> lists) {
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (root != null) {
			current.add(root);
		}
		while (current.size() > 0) {
			lists.add(current);
			LinkedList<TreeNode> parent = current;
			current = new LinkedList<TreeNode>();
			for (TreeNode treeNode : parent) {
				if (treeNode.getLeft() != null) {
					current.add(treeNode.getLeft());
				}
				if (treeNode.getRight() != null) {
					current.add(treeNode.getRight());
				}
			}
		}

	}

}
