public class DirectedEdge {

	private final int u;
	private final int v;
	private final double weight;

	public DirectedEdge(int u, int v, double weight) {
		this.u = u;
		this.v = v;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int from() {
		return this.u;
	}

	public int to() {
		return this.v;
	}

}