/* --------------------------------------------------------
	Generic Binary Tree Node implementation
-------------------------------------------------------- */
public class GBinaryNode<K> {
	K data;
	GBinaryNode<K> left;
	GBinaryNode<K> right;

	// Binary tree node constructor
	public GBinaryNode(K data, GBinaryNode<K> l, GBinaryNode<K> r) {
		this.data = data;
		this.left = l;
		this.right = r;
	}
}