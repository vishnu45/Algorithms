/** -------------------------------------------------------
 *	Edge class implementation 
-------------------------------------------------------- */

public class Edge {

	private int v;			// one vertex
	private int w;			// the other vertex
	private double weight;	// edge weight

	// Edge constructor
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	// returns the weight of this edge
	public double weight() { return this.weight; }

	// returns either of this edge's vertices
	public int either() { return this.v; }

	// returns the other vertex
	public int other(int vertex) {
		if (vertex == v) return w;
		else if (vertex == w) return v;
		else throw new RuntimeException("Inconsistent edge");
	}

	// compareTo() custom function to compare this edge to e
	public int compareTo(Edge that) {
		if (this.weight() < that.weight()) return -1;
		else if	(this.weight() > that.weight()) return 1;
		else return 0;
	}

	// returns string representation of the edge
	public String toString() {
		return String.format("%d-%d %.2f", v, w, weight);
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {

		Edge E1 = new Edge(4, 5, .35);
		Edge E2 = new Edge(4, 7, .37);
		Edge E3 = new Edge(5, 7, .28);
		System.out.println("E1: " + E1.toString());
		System.out.println("E2: " + E2.toString());
		if (E1.compareTo(E2) > 0) { System.out.println("E1 > E2"); }
		if (E1.compareTo(E2) < 0) { System.out.println("E1 < E2"); }
		if (E1.compareTo(E2) == 0) { System.out.println("E1 = E2"); }

	}

}