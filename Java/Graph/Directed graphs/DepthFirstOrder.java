/** -------------------------------------------------------
 *	For processing DFS preorder, postorder, reverse postorder
-------------------------------------------------------- */
import java.util.*;
public class DepthFirstOrder {

	private boolean[] marked;
	private LinkedList<Integer> preorder;			// vertice in preorder
	private LinkedList<Integer> postorder;			// vertice in postorder
	private Stack<Integer> reversePostOrder;	// vertices in reverse postorder

	// to calculate preorder, postorder and reverse post order of the graph
	public DepthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		preorder = new LinkedList<Integer>();
		postorder = new LinkedList<Integer>();
		reversePostOrder = new Stack<Integer>();
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	// dfs traversal
	public void dfs(Digraph G, int v) {
		// mark the visiting vertex
		marked[v] = true;
		// add to preorder
		preorder.add(v);
		// StdOut.print(v + " ");
		for (int w : G.adj(v)) {
			// traverse to only unvisited nodes
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		postorder.add(v);
		reversePostOrder.push(v);
	}

	// returns preorder
	public Iterable<Integer> preorder() { return preorder; }
	// returns postorder
	public Iterable<Integer> postorder() { return postorder; }
	// returns reverse postorder
	public Stack<Integer> reversePostOrder() { return reversePostOrder; }


	// --------------------- MAIN ------------------------
	public static void main(String[] args) {
		Digraph G1 = new Digraph(13);		
		G1.addEdge(0, 5);
		G1.addEdge(0, 1);
		G1.addEdge(0, 6);
		G1.addEdge(2, 0);
		G1.addEdge(2, 3);
		G1.addEdge(3, 5);
		G1.addEdge(5, 4);
		G1.addEdge(6, 4);
		G1.addEdge(6, 9);
		G1.addEdge(7, 6);
		G1.addEdge(8, 7);
		G1.addEdge(9, 11);
		G1.addEdge(9, 10);
		G1.addEdge(9, 12);
		G1.addEdge(11, 12);
		DepthFirstOrder D = new DepthFirstOrder(G1);
		StdOut.print("DFS Pre order: ");
		for (int w: D.preorder()) {
			StdOut.print(w + " ");
		}
		StdOut.println();
		StdOut.print("DFS Post order: ");
		for (int w: D.postorder()) {
			StdOut.print(w + " ");
		}
		StdOut.println();
		Stack S1 = D.reversePostOrder();
		StdOut.print("DFS Reverse Post order: ");
		while (!S1.empty()) {
			StdOut.print(S1.pop() + " ");
		}		
	} 
}