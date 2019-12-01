package Trees_and_Graphs;

import java.util.*;


public class Build_Order {

	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);
		System.out.println("No of vertices:");
		int noofvert = inp.nextInt();
		Graph g = new Graph(noofvert);
		for (int i = 0; i < noofvert; i++) {
			g.addVertices(inp.next());
		}

		g.addEdge("a", "d");
		g.addEdge("f", "b");
		g.addEdge("b", "d");
		g.addEdge("f", "a");
		g.addEdge("d", "c");
		
		g.buildOrder();
	}

}

class Graph {
	int noOfVertices;
	List<String> adjacencyList[]; // Adjacency List
	Map<String, Integer> charToNumberMapping = new HashMap<String, Integer>(); // String to No conversion
	int no;

	public Graph(int noOfVertices) {
		this.noOfVertices = noOfVertices;
		adjacencyList = new ArrayList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			adjacencyList[i] = new ArrayList<String>();
		}
	}

	public void addVertices(String vertex) {
		charToNumberMapping.put(vertex, no++);
	}

	public void addEdge(String a, String b) {
		if (charToNumberMapping.containsKey(a)) {
			adjacencyList[charToNumberMapping.get(a)].add(b);
		}

	}
	
	public void buildOrder()
	{
		//Create Indegree of Nodes
		StringBuffer s = new StringBuffer("");
		int[] indegree = new int[noOfVertices];
		for(int i = 0; i< noOfVertices; i++)
		{
			List<String> temp = adjacencyList[i];
			for(String s1:temp)
			{
				indegree[charToNumberMapping.get(s1)]++;
			}
		}
		
		Queue<Integer> queueWithZeroInDegree = new LinkedList<Integer>();
		for(int i = 0; i < noOfVertices ; i++)
		{
			if(indegree[i] == 0)
			{
				queueWithZeroInDegree.add(i);
			}
		}
		int cont=0;
		while(!queueWithZeroInDegree.isEmpty())
		{
			int temp = queueWithZeroInDegree.poll();
			s.append(temp+" ");
			for(String s2: adjacencyList[temp])
			{
				if(--indegree[charToNumberMapping.get(s2)] == 0)
				{
					queueWithZeroInDegree.add(charToNumberMapping.get(s2));
				}
			}
			cont++;
		}
		if(cont != noOfVertices)
		{
			System.out.println("Cycle Present");
		}else
		{
			System.out.println(s);

		}
		
	}

}