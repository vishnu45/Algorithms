/** -------------------------------------------------------
 *	To check whether a graph is acyclic or not
-------------------------------------------------------- */

import java.util.*;

public class Cycle {

	// to check whether vertex was visited
	private boolean[] marked;
	// to check whether there is a cycle
	private boolean hasCycle;

	// Constructor to check whether cycle is present
	public Cycle(Graph G) {
		hasCycle = false;
		marked = new boolean[G.V()];
		// go through all the unvisited vertices in the graph
		for (int v = 0; v < G.V(); v++) {
			// check if the dfs reaches back to v (assuming no self cycles)
			if (!marked[v]) {				
				dfs(G, v, v);
			}
		}
	}

	// to check whether there is a cyclce starting at start vertex
	public void dfs(Graph G, int v, int parent) {
		// mark start vertex as visited
		marked[v] = true;
		// go thorugh all connected vertices
		for (int w: G.adj(v)) {
			// if not visited, go in deeper (dfs)
			if (!marked[w]) {
				dfs(G, w, v);
			}
			// if already visited, and if its not a parent of v
			else if (w != parent) { 
				hasCycle = true; 
			}
		}
	}

	// returns whether graph is cyclic or not
	public boolean isCyclic() { return hasCycle; }


	// --------------------- MAIN ------------------------
	public static void main(String[] args) {
		Graph G1 = new Graph(13);
		G1.addEdge(0, 5);		
		G1.addEdge(0, 1);
		G1.addEdge(9, 12);
		G1.addEdge(6, 4);
		G1.addEdge(5, 4);
		G1.addEdge(0, 2);
		G1.addEdge(11, 12);
		G1.addEdge(9, 10);
		G1.addEdge(7, 8);
		G1.addEdge(5, 3);

		// G1.addEdge(0, 6);
		G1.addEdge(4, 3);
		// G1.addEdge(9, 11);
		Cycle c = new Cycle(G1);
		if (c.isCyclic()) 
			StdOut.println("Cyclic");
		else 
			StdOut.println("Acyclic");

	}
}