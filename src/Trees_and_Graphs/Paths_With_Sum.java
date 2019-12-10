package Trees_and_Graphs;

import java.util.ArrayList;

public class Paths_With_Sum {

	static ArrayList<Integer> path = new ArrayList<Integer>();
	static int noOfPath;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	public static void countAndPrintKSumPath(Node node,int sum) {
		
		if(node == null) {
			return;
		}
		//Preorder Traversal to Put Data into ArrayList
		//Put root data
		path.add(node.data);
		
		//Go to Left to Check any k sum path
		countAndPrintKSumPath(node.left, sum);
		
		//Go to Right to Check any k sum path
		countAndPrintKSumPath(node.right, sum);
		
		// till Here all node will be pushed to List
		int temp = 0;
		for(int i = path.size() - 1; i >= 0;i--) {
			temp += path.get(i);
			
			// if sum equals to temp means one path is this
			if(temp == sum)
			{
				noOfPath++;
				printPath(i);
			}
			// keep checking might some negative node be there
		}
		//here you remove last element from list..because all sum path till this node is node
		path.remove(path.size() - 1);
	}
	
	private static void printPath(int start) {
     for(int i = start; i<= path.size() - 1; i++)
     {
    	 System.out.print(path.get(i)+" ");
     }
     System.out.println();
    
	}

	public static void main(String[] args) {

		Node root = new Node(1);  
	    root.left = new Node(3);  
	    root.left.left = new Node(2);  
	    root.left.right = new Node(1);  
	    root.left.right.left = new Node(1);  
	    root.right = new Node(-1);  
	    root.right.left = new Node(4);  
	    root.right.left.left = new Node(1);  
	    root.right.left.right = new Node(2);  
	    root.right.right = new Node(5);  
	    root.right.right.right = new Node(2);
	    
	    int sum = 5;
	    countAndPrintKSumPath(root,sum);
	    System.out.println("Total no of sum path is:"+noOfPath);
	}

}
