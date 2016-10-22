/* --------------------------------------------------------
	To find the height of a binary tree
-------------------------------------------------------- */
import java.util.*;
public class bt_deepestNode {

	// returns the deepest node in the binary tree
	public static BinaryNode deepestNode(BinaryNode root) {
		// using level order traversal
		Queue<BinaryNode> NodeQueue = new LinkedList<BinaryNode>();
		NodeQueue.add(root);
		BinaryNode temp = root;

		while(NodeQueue.size() > 0) {
			// take the node present at curretn level, this will
			// be one of the deepest node at current level
			temp = NodeQueue.remove();
			// check if left child is present
			if (temp.left != null) {
				NodeQueue.add(temp.left);
			}
			// check if right child is present
			if (temp.right != null) {
				NodeQueue.add(temp.right);				
			}
		}
		return temp;
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
		System.out.println("Deepest node: " + deepestNode(root).data);

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
		System.out.println("Deepest node: " + deepestNode(root).data);

	}
}