/** -------------------------------------------------------
 *	Depth First Search for directed graph
-------------------------------------------------------- */
import java.util.*;
public class DirectedDFS {

	boolean[] marked;	// to indicate vertices visited	
	int[] edgeTo;		// edge to corresponding vertex

	// find vertices in G that are reachable form vertex s
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		// dfs invocation
		dfs(G, s);
	}

	// find vertices in G that are reachable from sources
	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for (int s: sources) {
			if (!marked[s]) {
				// dfs invocation
				dfs(G, s);
			}
		}
	}

	// dfs for directed graph
	public void dfs(Digraph G, int v) {
		// mark the vertex as visited
		marked[v] = true;
		// visit all the nearby vertices
		for (int w : G.adj(v)) {
			// go to only unvisited vertices
			if (!marked[w]) {
				// go the unvisited node and record the edge from which it was reached
				edgeTo[w] = v;
				// call the dfs on this vertex
				dfs(G, w);
			}
		}
	}

	// returns true if v is reachable for the indicated sources in Digraph
	public boolean marked(int v) { return marked[v]; }


	// --------------------- MAIN ------------------------
	public static void main(String[] args) {
		Digraph G1 = new Digraph(13);
		G1.addEdge(4, 2);
		G1.addEdge(2, 3);
		G1.addEdge(3, 2);
		G1.addEdge(6, 0);
		G1.addEdge(0, 1);
		G1.addEdge(2, 0);
		G1.addEdge(11, 12);
		G1.addEdge(12, 9);
		G1.addEdge(9, 10);
		G1.addEdge(9, 11);
		G1.addEdge(8, 9);
		G1.addEdge(10, 12);
		G1.addEdge(11, 4);
		G1.addEdge(4, 3);
		G1.addEdge(3, 5);
		G1.addEdge(7, 8);
		G1.addEdge(8, 7);
		G1.addEdge(5, 4);
		G1.addEdge(0, 5);
		G1.addEdge(6, 4);
		G1.addEdge(6, 9);
		G1.addEdge(7, 6);
		// StdOut.print(G1.toString());
		DirectedDFS reachable;
		reachable = new DirectedDFS(G1, 1);
		for (int v = 0; v < G1.V(); v++) {
			if (reachable.marked(v)) {
				StdOut.print(v + " ");
			}			
		}
		StdOut.println();
		reachable = new DirectedDFS(G1, 2);
		for (int v = 0; v < G1.V(); v++) {
			if (reachable.marked(v)) {
				StdOut.print(v + " ");
			}			
		}
		StdOut.println();
		ArrayList<Integer> sources = new ArrayList<Integer>();
		sources.add(1); sources.add(2); sources.add(6);
		reachable = new DirectedDFS(G1, sources);		
		for (int v = 0; v < G1.V(); v++) {
			if (reachable.marked(v)) {
				StdOut.print(v + " ");
			}			
		}
	}
}