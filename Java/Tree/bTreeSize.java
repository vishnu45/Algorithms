/* --------------------------------------------------------
	Size of a binary tree (recursive and iterative)
-------------------------------------------------------- */
import java.util.*;
public class bTreeSize {

	// size of tree (#elements) recursively
	public static int sizeRecursive(BinaryNode root) {
		int size;
		if (root == null) {
			return 0;
		}
		size = 	sizeRecursive(root.left) 	// size of left child
				+ 1 + 						// size of current parent
				sizeRecursive(root.right);	// size of right child
		return size;
	}

	// size of tree iteratively
	public static int sizeIterative(BinaryNode root) {
		Queue<BinaryNode> NodeQueue = new LinkedList<BinaryNode>();
		BinaryNode temp = root;
		int size = 0;
		NodeQueue.add(root);

		while (NodeQueue.size() != 0) {
			size++;
			temp = NodeQueue.remove();
			if (temp.left != null) {
				NodeQueue.add(temp.left);
			}
			if (temp.right != null) {
				NodeQueue.add(temp.right);
			}
		}
		return size;
	}
	

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {		
		BinaryNode root = new BinaryNode(1, null, null);
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
		System.out.println("Recursive size: " + sizeRecursive(root));
		System.out.println("Iterative size: " + sizeIterative(root));
	}
}