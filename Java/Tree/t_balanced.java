/* --------------------------------------------------------
 Check if a given binary tree is balanced or not
 Approach: the difference between min depth and max depth 
 should not exceed 1
-------------------------------------------------------- */
import java.lang.*;
public class t_balanced {

	// returns min depth of a binary tree
	public static int minDepth(BinaryNode root) {
		// if empty tree
		if (root == null) {
			return 0;
		}
		// root + minimum (depth of left, right trees)
		return (1 + Math.min(minDepth(root.left), minDepth(root.right)));
	}

	// returns max depth of a binary tree
	public static int maxDepth(BinaryNode root) {
		// if empty tree
		if (root == null) {
			return 0;
		}
		// root + maximum (depth of left, right trees)
		return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
	}

	// checks if tree is balanced
	public static boolean isTreeBalacned(BinaryNode root) {
		if (root == null) {
			return true;
		}
		// return (isTreeBalacned(root.left) && 
		// 		isTreeBalacned(root.right) && 
		// 		(maxDepth(root) - minDepth(root) <= 1)  );
		return (maxDepth(root) - minDepth(root) <= 1);
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1, null, null);
		root.left = new BinaryNode(2, null, null);
		root.left.left = new BinaryNode(4, null, null);
		root.left.right = new BinaryNode(5, null, null);
		root.right = new BinaryNode(3, null, null);
		root.right.left = new BinaryNode(6, null, null);
		System.out.println(isTreeBalacned(root));
		root.right.right = new BinaryNode(7, null, null);
		System.out.println(isTreeBalacned(root));
		root.right.right.right = new BinaryNode(8, null, null);
		System.out.println(isTreeBalacned(root));
	}

}