import java.util.LinkedList;
public class EdgeWeightedDigraph {

	private final int V;
	private int E;
	private LinkedList<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int v) {
		this.V = v;
		this.E = 0;
		adj = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<DirectedEdge>();
		}
	}

	public void addEdge(DirectedEdge e) {
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int u) {
		return adj[u];
	}

	public int V() { return V; }
	public int E() { return E; }

	public static void main(String[] args) {
		EdgeWeightedDigraph G1 = new EdgeWeightedDigraph(8);
		G1.addEdge(new DirectedEdge(4, 5, 0.35));
		G1.addEdge(new DirectedEdge(5, 4, 0.35));
		G1.addEdge(new DirectedEdge(4, 7, 0.37));
		G1.addEdge(new DirectedEdge(5, 7, 0.28));
		G1.addEdge(new DirectedEdge(7, 5, 0.28));
		G1.addEdge(new DirectedEdge(5, 1, 0.32));
		G1.addEdge(new DirectedEdge(0, 4, 0.38));
		G1.addEdge(new DirectedEdge(0, 2, 0.26));
		G1.addEdge(new DirectedEdge(7, 3, 0.39));
		G1.addEdge(new DirectedEdge(1, 3, 0.29));		
		G1.addEdge(new DirectedEdge(2, 7, 0.34));
		G1.addEdge(new DirectedEdge(6, 2, 0.40));
		G1.addEdge(new DirectedEdge(3, 6, 0.52));
		G1.addEdge(new DirectedEdge(6, 0, 0.58));
		G1.addEdge(new DirectedEdge(6, 4, 0.93));	
	}

}