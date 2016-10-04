/** -------------------------------------------------------
 *	Directed Graph class implementation
-------------------------------------------------------- */
import java.util.*;
public class Digraph {

	private final int V;				// number of vertices
	private int E;						// number of edges	
	private LinkedList<Integer>[] adj;	// adjacency list

	// constructor for a V-vertex digraph with no edges
	public Digraph(int V) {
		this.V = V;
		this.E = 0;		
		adj = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Integer>();
		}
	}

	public int V() { return V; }
	public int E() { return E; }

	// adds edge v -> w to the digraph
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	// returns vertices connected to v by edges pointing from v
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	// returns the reverse of the digraph
	public Digraph reverse() {
		Digraph R = new Digraph(V);
		for (int v = 0; v < V; v++) {
			for (int w: adj[v]) {
				R.addEdge(w, v);
			}
		}
		return R;
	}

	// returns string representation of digraph
	public String toString() {
		String strDigraph = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++) {
			strDigraph += v + ": ";
			for (int w: adj[v]) {
				strDigraph += w + " ";				
			}
			strDigraph += "\n";
		}
		return strDigraph;
	}


	// ----------------------- MAIN -----------------------
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
		StdOut.println(G1.toString());
		StdOut.println((G1.reverse()).toString());
	}
}