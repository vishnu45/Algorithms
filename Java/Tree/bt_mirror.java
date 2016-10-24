/* --------------------------------------------------------
	To generate the mirror of a binary tree
-------------------------------------------------------- */
import java.util.*;
public class bt_mirror {

	//prints out all root-to-leaf path
	public static BinaryNode treeMirror(BinaryNode root) {
		BinaryNode temp;		// for swap
		// no more children
		if (root == null) {
			return null;
		}
		// swap left - right children
		temp = root.left;
		root.left = root.right;
		root.right = temp;
		// mirror nodes under left and right children
		treeMirror(root.left);
		treeMirror(root.right);

		return root;
	}

	// prints the tree
	public static void printTree(BinaryNode root) {
		// if leaf children are reached
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);		
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
		System.out.print("Original Tree: ");
		printTree(root);
		treeMirror(root);
		System.out.print("\nMirrored Tree: ");
		printTree(root);
		System.out.println();
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
		System.out.print("Original Tree: ");
		printTree(root);
		treeMirror(root);
		System.out.print("\nMirrored Tree: ");
		printTree(root);		
	}
}