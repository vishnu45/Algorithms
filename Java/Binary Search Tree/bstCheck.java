/* --------------------------------------------------------
	Given values of two nodes in a BST, find the Lowest
	Common Ancestor (LCA).
-------------------------------------------------------- */
public class bstCheck {

	// returns minimum element in bst (recursive)
	public static int findMinRec(GBinaryNode<Integer> root) {
		// if null tree
		if (root == null) {
			System.out.println("Empty tree");			
			return -1;
		}
		// once we reach left most leaf node
		else if (root.left == null) {
			return root.data;
		}
		// traverse to left child node
		else {
			return findMinRec(root.left);
		}
	}

	// returns maximum element in bst (recursive)
	public static int findMaxRec(GBinaryNode<Integer> root) {
		// if null tree
		if (root == null) {
			System.out.println("Empty tree");			
			return -1;
		}
		// once we reach right most leaf node
		else if (root.right == null) {
			return root.data;
		}
		// traverse to right child node
		else {
			return findMaxRec(root.right);
		}
	}

	// returns true/false depending on whether B-tree is BST
	public static boolean check(GBinaryNode<Integer> root) {
		// check if empty tree
		if (root == null) {			
			return true;
		}
		// if root is less than largest node in left subtree - false
		else if ( (root.left != null) &&
				  (root.data < findMaxRec(root.left)) ) {
			return false;
		}
		// if root is greater than smallest node in right subtree - false
		else if ( (root.right != null) &&
				  (root.data > findMinRec(root.right)) ) {
			return false;
		}
		// recursively check for all left and right subtrees from current node
		return (check(root.left) || check(root.right));
	}


	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		GBinaryNode<Integer> root = new GBinaryNode<Integer>(6, null, null);
		root.left = new GBinaryNode<Integer>(2, null, null);
		root.right = new GBinaryNode<Integer>(8, null, null);
		root.left.left = new GBinaryNode<Integer>(1, null, null);
		root.left.right = new GBinaryNode<Integer>(9, null, null);
		System.out.println(check(root));		

		root = new GBinaryNode<Integer>(5, null, null);
		root.left = new GBinaryNode<Integer>(2, null, null);
		root.left.left = new GBinaryNode<Integer>(1, null, null);
		root.left.right = new GBinaryNode<Integer>(4, null, null);
		root.right = new GBinaryNode<Integer>(7, null, null);
		root.right.left = new GBinaryNode<Integer>(6, null, null);
		root.right.right = new GBinaryNode<Integer>(9, null, null);
		System.out.println(check(root));
	}
}