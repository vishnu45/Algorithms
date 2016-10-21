/* --------------------------------------------------------
	To find maximum element in a binary tree
-------------------------------------------------------- */
import java.util.*;
public class bTreeMaxElement {

	// returns max node in tree
	public static int maxTreeValue(BinaryNode root) {
		int max = root.data;
		BinaryNode temp;
		Queue<BinaryNode> NodeQueue = new LinkedList<BinaryNode>();
		NodeQueue.add(root);

		while (NodeQueue.size() != 0) {
			temp = NodeQueue.remove(); 
			if (temp.data > max) {
				max = temp.data;
			}
			if (temp.left != null) {
				NodeQueue.add(temp.left);
			}
			if (temp.right != null) {
				NodeQueue.add(temp.right);
			}
		}
		return max;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {		
		BinaryNode root = new BinaryNode(1, null, null);
		root.left = new BinaryNode(8, null, null);
		root.left.left = new BinaryNode(4, null, null);
		root.left.right = new BinaryNode(5, null, null);
		root.right = new BinaryNode(3, null, null);
		root.right.left = new BinaryNode(6, null, null);
		root.right.right = new BinaryNode(7, null, null);

		System.out.println("Max value: " + maxTreeValue(root));
	}
}