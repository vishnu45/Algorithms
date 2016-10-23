/* --------------------------------------------------------
	To check the structural similrity of 2 binary trees
-------------------------------------------------------- */
import java.util.*;
public class bt_checkSame {

	// returns true if both trees are structurally same
	public static boolean checkSame(BinaryNode root1, BinaryNode root2) {
		// check if both current nodes are null
		if (root1 == null && root2 == null) {
			return true;
		}

		// check if only one of the current nodes exist
		if (root1 == null || root2 == null) {
			return false;
		}

		// check if data are same
		if (root1.data == root2.data) {
			// check similarity for left and right nodes
			return (checkSame(root1.left, root2.left) &&
					checkSame(root1.right, root2.right));
		}
		// if data on nodes dont match
		else {
			return false;
		}
	}
	

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		BinaryNode root1 = new BinaryNode(1, null, null);
		root1.left = new BinaryNode(2, null, null);
		root1.left.left = new BinaryNode(4, null, null);
		root1.left.right = new BinaryNode(5, null, null);
		root1.right = new BinaryNode(3, null, null);
		root1.right.left = new BinaryNode(6, null, null);
		root1.right.right = new BinaryNode(7, null, null);
		BinaryNode root2 = root1;
		System.out.println("Check root1-root2: " + checkSame(root1, root2));

		BinaryNode root3 = new BinaryNode(1, null, null);
		root3.left = new BinaryNode(2, null, null);
		root3.left.left = new BinaryNode(4, null, null);
		root3.left.right = new BinaryNode(5, null, null);
		root3.left.right.left = new BinaryNode(6, null, null);
		root3.left.right.right = new BinaryNode(7, null, null);		
		root3.right = new BinaryNode(3, null, null);
		root3.right.left = new BinaryNode(8, null, null);
		root3.right.left.left = new BinaryNode(9, null, null);
		root3.right.left.right = new BinaryNode(10, null, null);
		root3.right.left.right.left = new BinaryNode(11, null, null);
		System.out.println("Check root1-root3: " + checkSame(root1, root3));

	}
}