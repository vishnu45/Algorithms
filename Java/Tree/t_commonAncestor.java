/* --------------------------------------------------------
 To find the first common ancestor of two nodes in a 
 binary tree
-----------------------------------------------------------
 - Check if the nodes are present on separate sides, one on
 left and the other on the right -> In such case the root
 will be the CA.
 - If in case both are on the same side -> similarly go to
 the root of that side and again check
 - Continue this approach
-------------------------------------------------------- */
import java.util.*;
public class t_commonAncestor {

	private static int TWO_NODES_FOUND = 2;
	private static int ONE_NODE_FOUND = 1;
	private static int NO_NODES_FOUND = 0;

	// retunrs the common acesstor of two nodes in the tree
	public static BinaryNode getCA(BinaryNode root, int n1, int n2)	{
		
		if (root == null) {
			System.out.println("Either of the keys not present in tree");
			return null;
		}

		// if either value is the top root value
		if (n1 == root.data || n2 == root.data) {
			return root;
		}
		
		// if each node is present in either of left and right branches
		if ((countNodesPresent(root.left, n1, n2) == ONE_NODE_FOUND) &&
			(countNodesPresent(root.right, n1, n2) == ONE_NODE_FOUND)) {
			return root;
		}

		// if no nodes are present in left
		else if (countNodesPresent(root.left, n1, n2) == NO_NODES_FOUND) {
			// check in right branch
			return getCA(root.right, n1, n2);
		}

		// if both nodes are present in left
		else {
			// check in left branch
			return getCA(root.left, n1, n2);
		}		
	}

	// search if nodes are present in tree
	public static int countNodesPresent(BinaryNode root, int n1, int n2) {
		int count = 0;
		if (isNodePresent(root, n1)) {
			count++;
		}
		if (isNodePresent(root, n2)) {
			count++;
		}
		return count;
	}

	// search if node is present
	public static boolean isNodePresent(BinaryNode root, int n1) {
		if (root == null) {
			return false;
		}
		if (root.data == n1) {
			return true;
		}
		else {
			return ( isNodePresent(root.left, n1) || isNodePresent(root.right, n1) );
		}
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1, null, null);
		root.left = new BinaryNode(2, null, null);
		root.left.left = new BinaryNode(4, null, null);
		root.left.right = new BinaryNode(5, null, null);
		root.left.right.left = new BinaryNode(10, null, null);
		root.left.right.right = new BinaryNode(11, null, null);
		root.right = new BinaryNode(3, null, null);
		root.right.left = new BinaryNode(6, null, null);
		root.right.left.left = new BinaryNode(12, null, null);
		root.right.left.right = new BinaryNode(13, null, null);
		root.right.right = new BinaryNode(7, null, null);
		root.left.left.left = new BinaryNode(8, null, null);
		root.left.left.right = new BinaryNode(9, null, null);
		root.right.right.left = new BinaryNode(14, null, null);
		root.right.right.right = new BinaryNode(15, null, null);
		// System.out.println(isNodePresent(root, 12));
		// System.out.println(isNodePresent(root, 11));
		// System.out.println(countNodesPresent(root, 11, 3));
		// System.out.println(countNodesPresent(root, 11, 12));
		// System.out.println(countNodesPresent(root, 13, 12));
		System.out.println("[01:02] > " + getCA(root,  1,  2).data);
		System.out.println("[01:08] > " + getCA(root,  1,  8).data);
		System.out.println("[01:15] > " + getCA(root,  1, 15).data);
		System.out.println("[15:01] > " + getCA(root, 15,  1).data);
		System.out.println("[15:01] > " + getCA(root, 15,  1).data);

		System.out.println("[02:03] > " + getCA(root,  2,  3).data);
		System.out.println("[02:12] > " + getCA(root,  2, 12).data);
		System.out.println("[04:06] > " + getCA(root,  4,  6).data);
		System.out.println("[04:05] > " + getCA(root,  4,  5).data);
		System.out.println("[04:11] > " + getCA(root,  4, 11).data);
		System.out.println("[10:11] > " + getCA(root, 10, 11).data);
	}
}