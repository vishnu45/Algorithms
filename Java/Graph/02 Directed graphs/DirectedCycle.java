/** -------------------------------------------------------
 *	For determining directed acyclic graphs
-------------------------------------------------------- */
import java.util.*;
public class DirectedCycle {

	private boolean[] marked;		// to indicate vertices visited
	private int[] edgeTo;			// to track parent vertex
	private Stack<Integer> cycle;	// vertices of a cycle
	private boolean[] onStack;		// vertices on current dfs stack
	// to check whether cycle is present in graph
	boolean isCyclic;

	// constructor to check graph is cyclic
	public DirectedCycle(Digraph G) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		onStack = new boolean[G.V()];
		isCyclic = false;
		// start at every unvisited vertex of graph and check for cycle
		for (int v = 0; v < G.V(); v++) {
			// dfs starting with vertices not already visited
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	// dfs to check for cycles
	public void dfs(Digraph G, int v) {
		// mark visited node
		marked[v] = true;
		onStack[v] = true;
		// visit all the nearby vertices
		for (int w: G.adj(v)) {
			// if cycle is already found exit loop
			if (hasCycle()) {
				return;
			}
			// go to only unvisited vertices
			else if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
			// if already visited, check if it is on the cycle stack
			else if (onStack[w]) {
				// create the cycle stack
				cycle = new Stack<Integer>();
				// starting from the current vertex v, traceback the path
				// and add all parents until child is reached
				for (int x = v; x != w; x = edgeTo[x]) {
					cycle.push(x);
				}
				// add child and current vertex v to complete cycle
				cycle.push(w);
				cycle.push(v);
			}
		}
		// if cycle not possible starting from v, remove form cycle
		// i.e., it is no longer possible for v to be part of a cycle
		onStack[v] = false;
	}

	// to check whether cycle stack is not empty indicating there is presence of cycle
	public boolean hasCycle() { return cycle != null; }

	// returns the cycle stack
	public Iterable<Integer> cycle() { return cycle; }


	// --------------------- MAIN ------------------------
	public static void main(String[] args) {
		Digraph G1 = new Digraph(6);
		G1.addEdge(0, 5);
		G1.addEdge(5, 4);
		G1.addEdge(4, 3);

		G1.addEdge(3, 5);
		
		StdOut.print(G1.toString());
		DirectedCycle DC = new DirectedCycle(G1);
		if (DC.hasCycle()) {
			StdOut.print("Cycle: ");
			for (int w: DC.cycle())	 {
				StdOut.print(w + " ");
			}
		}
		else {
			StdOut.print("Graph does not have any cycles");
		}

	}
}