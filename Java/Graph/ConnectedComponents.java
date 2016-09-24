/** -------------------------------------------------------
 *	To retrieve the connected components of a graph
-------------------------------------------------------- */

import java.util.*;
public class ConnectedComponents {

	// to track the vertices that are already visited
	private boolean[] marked;
	// to keep track of the id of the component (to which set of vertices belong to)
	private int[] id;
	// id value to the be assinged
	private int count;

	/**
	 *	preprocessing constructor
	 */
	public ConnectedComponents(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		count = 0;
		// go through all vertices in G and find the components
		for (int v = 0; v < G.V(); v++) {
			// process vertices that are not marked
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}

	}

	// dfs traversal
	public void dfs(Graph G, int v) {
		// mark the start vertex as visited
		marked[v] = true;
		// give an id to the start vertex
		id[v] = count;
		// go through all vertices connected to vertex v
		for (int w: G.adj(v)) {
			// do not process if vertex already visited
			if (!marked[w]) {				
				dfs(G, w);
			}
		}
	}

	/**
	 *	are vertices v and w connected
	 */
	public boolean connected(int v, int w) { return (id[v] == id[w]); }

	/**
	 *	number of connected components
	 */
	public int count() { return count; }

	/**
	 *	component identifier for v (between 0 and count()-1)
	 */
	public int id(int v) { return id[v]; }

	// --------------------- MAIN ------------------------
	public static void main(String[] args) {
		Graph G1 = new Graph(13);
		G1.addEdge(0, 5);
		G1.addEdge(4, 3);
		G1.addEdge(0, 1);
		G1.addEdge(9, 12);
		G1.addEdge(6, 4);
		G1.addEdge(5, 4);
		G1.addEdge(0, 2);
		G1.addEdge(11, 12);
		G1.addEdge(9, 10);
		G1.addEdge(0, 6);
		G1.addEdge(7, 8);
		G1.addEdge(9, 11);
		G1.addEdge(5, 3);
		ConnectedComponents cc = new ConnectedComponents(G1);

		int M = cc.count();
		StdOut.println(M + " components");
		// create a linkedlist to store all the components
		LinkedList<Integer>[] component = new LinkedList[M];
		for (int i = 0; i < M; i++) {
			component[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < G1.V(); i++) {
			// add items of same component id into the same linkedlist
			component[cc.id(i)].add(i);			
		}		

		for (int i = 0; i < M; i++) {
			StdOut.print("Component #" + i + ": ");
			for (int v = 0; v < component[i].size(); v++) {
				StdOut.print(component[i].get(v) + " ");
			}
			StdOut.println();
		}


	}
}