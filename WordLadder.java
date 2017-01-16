import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class WordLadder {

	public static class Node{
		String x;
		LinkedList<Node> neighbours;
		
		public Node(String x){
			this.x = x;
			this.neighbours = new LinkedList<Node>();
		}
		public String toString(){
			return this.x;
		}
	}
	
	public static class Graph{
		
		LinkedList<Node> nodes;
	
		
		
		public Graph(){
				this.nodes = new LinkedList<Node>();
		}
	}
	public static int difference(String A, String B){
		if (A.length() != B.length()){
			return -1;
		}
		
		int difference = 0;
		for (int i=0; i<A.length(); i++){
			if (A.charAt(i) != B.charAt(i)){
				difference ++;
				if (difference >= 2){
					break;
				}
			}
		}		
		return (difference == 1) ? 1:  0;
	}
	
	public static class NodeAndDepth{
		Node node;
		int depth;
		
		public NodeAndDepth(Node n, int d){
			this.node = n;
			this.depth = d;
		}
	}
	private static int BFS(Graph graph, Node start, Node target){
		Queue<NodeAndDepth> queue = new LinkedList<NodeAndDepth>();
		queue.offer(new NodeAndDepth(start, 0));
		boolean found = false;
		HashSet<Node> visited = new HashSet<Node>();
		
		while(!queue.isEmpty() && !found){
			
			NodeAndDepth temp = queue.poll();
			
			//System.out.println("Looking at " + temp.node);
			if (temp.node == target){
				found = true;
				return temp.depth;
			}
			for (Node neighbour : temp.node.neighbours){
				if (!visited.contains(neighbour)){
					queue.offer(new NodeAndDepth(neighbour, temp.depth+1));
					visited.add(temp.node);
				}
				
			}
			
		}
		
		return -1;
	}
	
	
	public static int wordsApart(String A, String B, Graph graph){
		
		Node nodeWithA = null;
		Node nodeWithB = null;
		for (Node node : graph.nodes){
			if (node.x.equals(A)){
				nodeWithA = node;
			}
			if (node.x.equals(B)){
				nodeWithB = node;
			}
			if (nodeWithA != null && nodeWithB != null){
				break;
			}
		}
		if (nodeWithA == null || nodeWithB == null){
			return -1;
		}
		//System.out.println("Nodes are " + nodeWithA.x + " " + nodeWithB.x);
		return BFS(graph, nodeWithA, nodeWithB);
		
	}
	
	public static Graph initializeGraph(String [] words){
		
		Graph graph = new Graph();
		
		for (int i=0; i<words.length; i++){
			graph.nodes.add(new Node(words[i]));
		}
		
		for (Node firsts : graph.nodes){
			for (Node seconds : graph.nodes){
				int tempDifference = difference(firsts.x, seconds.x);
				//System.out.println("Difference between " + firsts.x + " and " + seconds.x + " is " + tempDifference);
				if (tempDifference == 1){
					firsts.neighbours.add(seconds);
					seconds.neighbours.add(firsts);		
				}
			}
		}
		
		return graph;
	}
	
	public static void main(String[] args) {
		String [] words = {"dog", "cat", "dot", "cot"};
		Graph graph = initializeGraph(words);
		System.out.println(wordsApart("dog", "cat", graph));
//		System.out.println(graph.nodes);
//		for (Node member : graph.nodes){
//			for (Node neigh : member.neighbours){
//				System.out.println(member + " : " + neigh);
//			}
//		}
	}
}
