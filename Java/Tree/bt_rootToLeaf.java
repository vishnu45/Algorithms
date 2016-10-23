/* --------------------------------------------------------
	To print out all root-to-leaf paths
-------------------------------------------------------- */
import java.util.*;
public class bt_rootToLeaf {

	//prints out all root-to-leaf path
	public static void rootToLeaf(BinaryNode root, ArrayList<Integer> path) {
		// create a new list for functino stack
		ArrayList<Integer> t_path = new ArrayList<Integer>(path);
		// check if the node is a leaf
		if (root.left == null && root.right == null) {
			// add the node to the path
			t_path.add(root.data);
			// print the entire path
			System.out.println(t_path.toString());			
			return;
		}
		// if not leaf, add node to path
		t_path.add(root.data);
		// if not leaf and left child is present
		if (root.left != null){ 
			rootToLeaf(root.left, t_path);
		}
		// if not leaf and right child is present
		if (root.right != null) {			
			rootToLeaf(root.right, t_path);
		}
		return;
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
		rootToLeaf(root, new ArrayList<Integer>());
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
		rootToLeaf(root, new ArrayList<Integer>());
	}
}