/** -------------------------------------------------------
 *	Edge Weighted Graph data structure class implementation
-------------------------------------------------------- */

import java.util.*;
public class EdgeWeightedGraph {

	private final int V;				// number of vertices
	private int E;						// number of edges
	private LinkedList<Edge>[] adj;		// adjacent lists

	// contructor to create an empty V-vertex graph
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
	}

	// returns number of vertices
	public int V() { return this.V; }

	// returns number of edges
	public int E() { return this.E; }

	// add edge e to this graph (add to adjacency matrix)
	public void addEdge(Edge e) {
		(adj[e.either()]).add(e);		
		(adj[e.other(e.either())]).add(e);		
		E++;
	}

	// returns the edges adjacent to vertex v
	public Iterable<Edge> adj(int v) { return adj[v]; }

	// returns all edges in the graph
	public Iterable<Edge> edges() {
		LinkedList<Edge> Edges = new LinkedList();
		for (int v = 0; v < V; v++) {
			for (Edge e: adj[v]) {
				// to add edges only once
				if (e.other(v) > v) {					
					Edges.add(e);
				}
			}
		}
		return Edges;
	}

	// returns string representation of graph
	public String toString() {
		String strGraph = "";
		for (Edge e: edges()) {
			strGraph = strGraph + "[" + e.toString() + "] ";
		}
		return strGraph;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {

		EdgeWeightedGraph G1 = new EdgeWeightedGraph(8);		
		G1.addEdge(new Edge(4, 5, .35));
		G1.addEdge(new Edge(4, 7, .37));
		G1.addEdge(new Edge(5, 7, .28));
		G1.addEdge(new Edge(0, 7, .16));
		G1.addEdge(new Edge(1, 5, .32));
		G1.addEdge(new Edge(0, 4, .38));
		G1.addEdge(new Edge(2, 3, .17));
		G1.addEdge(new Edge(1, 7, .19));
		G1.addEdge(new Edge(0, 2, .26));
		G1.addEdge(new Edge(1, 2, .36));
		G1.addEdge(new Edge(1, 3, .29));
		G1.addEdge(new Edge(2, 7, .34));
		G1.addEdge(new Edge(6, 2, .40));
		G1.addEdge(new Edge(3, 6, .52));
		G1.addEdge(new Edge(6, 0, .58));
		G1.addEdge(new Edge(6, 4, .93));

		StdOut.println(G1.toString());

	}
}