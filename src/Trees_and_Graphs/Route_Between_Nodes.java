package Trees_and_Graphs;

import java.util.LinkedList;
import java.util.Queue;

import utility.Constants;

public class Route_Between_Nodes {

	public static void main(String[] args) {

		/*
		 * Given a directed graph, design an algorithm to find out whether there is a
		 * route between two nodes.
		 */

		// Graph input in the form of Adjacency Matrix --- Node is 0,1,2,3

		int[][] adjacencyMatrix = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 } };

		int startNode = 0;
		int endNode = 3;
		System.out.printf("Path from node %d to %d is:" + isRouteBetweenNodes(adjacencyMatrix, startNode, endNode),
				startNode, endNode);
	}

	private static boolean isRouteBetweenNodes(int[][] adjacencyMatrix, int startNode, int endNode) {

		// Apply BFS to Find Route
		if (startNode == endNode) {
			return true;
		}
		String visited[] = new String[adjacencyMatrix.length];
		Queue<Integer> nodes = new LinkedList<Integer>();

		// initialize all node as unvisited
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			visited[i] = Constants.UNVISITED;
		}

		// add start node as visited
		if (startNode <= adjacencyMatrix.length && endNode <= adjacencyMatrix.length) {
			visited[startNode] = Constants.VISITING;
			nodes.add(startNode);
		}

		while (!nodes.isEmpty()) {
			int node = nodes.remove();
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				if (adjacencyMatrix[node][i] == 1) { // get All Adjacent nodes
					if (visited[i].equals(Constants.UNVISITED)) { // checking they are visited or not
						if (i == endNode) {
							return true;
						} else {
							nodes.add(i);
							visited[i] = Constants.VISITING;
							;
						}
					}
				}

			}
			visited[node] = Constants.VISITED;
			;
		}
		return false;

	}

}
