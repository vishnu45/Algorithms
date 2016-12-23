/** -------------------------------------------------------
 *	To check whether an undirected graph is bipartite or not
-------------------------------------------------------- */
public class TwoColor {

	// to check whether vertex was visited
	private boolean[] marked;
	// to check whether graph is bipartite
	private boolean isBipartite;
	// to assign alternate colors
	private boolean[] color;

	// constructor for TwoColor
	public TwoColor(Graph G) {
		marked = new boolean[G.V()];
		isBipartite = true;
		color = new boolean[G.V()];
		// go through all unvisited vertices in the graph
		for (int v = 0; v < G.V(); v++) {			
			// run dfs only if the vertex is not visited
			while (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	// dfs traversal function
	public void dfs(Graph G, int v) {
		// mark the vertex as visited
		marked[v] = true;
		// go through all connected vertices
		for (int w: G.adj(v)) {
			if (!marked[w]) {
				color[w] = !color[v];
				dfs(G, w);
			}
			else if (color[w] == color[v]) { 
				isBipartite = false;
				StdOut.println(w + "<>" + v);
			}
		}
	}

	// returns whether graph is bipartite
	public boolean isBipartite() { return isBipartite; }

	// --------------------- MAIN ------------------------
	public static void main(String[] args) {
		Graph G1 = new Graph(13);
		G1.addEdge(0, 5);		
		G1.addEdge(0, 1);
		G1.addEdge(6, 4);
		G1.addEdge(5, 4);
		G1.addEdge(0, 2);
		G1.addEdge(11, 12);
		G1.addEdge(9, 10);
		G1.addEdge(7, 8);
		G1.addEdge(0, 6);
		G1.addEdge(4, 3);
		G1.addEdge(9, 11);
		
		// G1.addEdge(9, 12);
		// G1.addEdge(5, 3);
		TwoColor T = new TwoColor(G1);
		if (T.isBipartite()) StdOut.println("Is bipartite");
		else StdOut.println("Not bipartite");

	}
}