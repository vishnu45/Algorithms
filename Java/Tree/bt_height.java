/* --------------------------------------------------------
	To find the height of a binary tree
-------------------------------------------------------- */
import java.util.*;
import java.lang.*;
public class bt_height {

	// finds the height of the tree recursively
	public static int getHeightRec(BinaryNode root) {
		// if the current node is null (no children)
		if (root == null) {
			return 0;
		}
		int lHeight, rHeight;
		// find left childs height
		lHeight = 1 + getHeightRec(root.left);
		// find right childs height
		rHeight = 1 + getHeightRec(root.right);
		// return max value among left and right children
		return Math.max(lHeight, rHeight);
	}

	// finds the height of the tree recursively
	public static int getHeightIte(BinaryNode root) {
		Queue<BinaryNode> NodeQueue = new LinkedList<BinaryNode>();
		int nodeCount;		// count of nodes at curret level
		BinaryNode node;	// node at current level
		int height = 0;
		// go through each level and increment height
		// first level (root)
		NodeQueue.add(root);
		
		while (NodeQueue.size() != 0) {
			// find number of elements at current level
			nodeCount = NodeQueue.size();
			// for all nodes in current level, remove them from queue
			// and enqueue their existing children
			while (nodeCount > 0) {
				// get node at current level
				node = NodeQueue.remove();
				// if left child exists
				if (node.left != null) {
					NodeQueue.add(node.left);
				}
				if (node.right != null) {
					NodeQueue.add(node.right);
				}
				nodeCount--;
			}
			// increment height after each level is traversed
			height++;
		}		
		return height;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1, null, null);
		root.left = new BinaryNode(2, null, null);
		root.left.left = new BinaryNode(4, null, null);
		root.left.right = new BinaryNode(5, null, null);
		root.right = new BinaryNode(3, null, null);
		root.right.left = new BinaryNode(6, null, null);
		root.right.right = new BinaryNode(7, null, null);
		System.out.println("Height recursive: " + getHeightRec(root));
		System.out.println("Height iterative: " + getHeightIte(root));

		root = new BinaryNode(1, null, null);
		root.left = new BinaryNode(2, null, null);
		root.left.left = new BinaryNode(4, null, null);
		root.left.right = new BinaryNode(5, null, null);
		root.left.right.left = new BinaryNode(6, null, null);
		root.left.right.right = new BinaryNode(7, null, null);		
		root.right = new BinaryNode(3, null, null);
		root.right.left = new BinaryNode(8, null, null);
		root.right.left.left = new BinaryNode(9, null, null);
		root.right.left.right = new BinaryNode(10, null, null);
		root.right.left.right.left = new BinaryNode(11, null, null);
		System.out.println("Height recursive: " + getHeightRec(root));
		System.out.println("Height iterative: " + getHeightIte(root));
	}
}