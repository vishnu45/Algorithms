/* --------------------------------------------------------
	Binary search tree implementation
-------------------------------------------------------- */
public class BST {

	// insert an element into binary search tree (recursive)
	public static GBinaryNode<Integer> insertRec(GBinaryNode<Integer> root, int value) {
		// if bst is empty
		if (root == null) {
			root = new GBinaryNode<Integer>(value, null, null);
			return root;
		}

		// else search through to find where to insert node
		// if value is greater than root move right
		if (value > root.data) {
			root.right = insertRec(root.right, value);
		}
		// if value is lesser than root move left
		else if (value < root.data) {
			root.left = insertRec(root.left, value);
		}
		return root;
	}

	// insert an element into binary search tree (iterative)
	public static void insertItr(GBinaryNode<Integer> root, int value) {
		// if bst is empty
		if (root == null) {
			root = new GBinaryNode<Integer>(value, null, null);
			return;
		}

		GBinaryNode<Integer> parent = root;
		GBinaryNode<Integer> temp = root;
		// find the parent under which this has to be inserted
		while (temp != null) {
			parent = temp;			
			// if value is greater than root
			if (value > temp.data) {
				temp = temp.right;
			}
			// if value is lesser than root
			else if (value < temp.data) {
				temp = temp.left;
			}
		}
		if (value > parent.data) {
			parent.right = new GBinaryNode<Integer>(value, null, null);
		}
		else if (value < parent.data) {
			parent.left = new GBinaryNode<Integer>(value, null, null);
		}		
	}

	// search for an element in bst (recursive)
	public static boolean searchRec(GBinaryNode<Integer> root, int value) {
		// if null root is reached
		if (root == null) {
			return false;
		}
		// if value greater than root move right
		if (value > root.data) {
			return searchRec(root.right, value);			
		}
		// if value lesser than root move left
		else if (value < root.data) {
			return searchRec(root.left, value);
		}
		// else if data == value
		else {
			return true;
		}
	}

	// search for an element in bst (iterative)
	public static boolean searchItr(GBinaryNode<Integer> root, int value) {
		// if null root is reached
		if (root == null) {
			return false;
		}
		GBinaryNode<Integer> temp = root;
		while (temp != null) {
			// if value greater than root move right
			if (value > temp.data) {
				temp = temp.right;
			}
			// if value lesser than root move left
			else if (value < temp.data) {
				temp = temp.left;
			}
			// if value found
			else {
				return true;
			}
		}
		// if the entire BST is traversed
		return false;
	}
	
	// delete element from binary search tree

	// returns minimum element in bst

	// returns maximum element in bst

	// print BST
	public static void printTree(GBinaryNode<Integer> root) {
		// if leaf children are reached
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);		
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		GBinaryNode<Integer> root = 
				new GBinaryNode<Integer>(5, null, null);
		// root.left = new GBinaryNode<Integer>(2, null, null);
		insertRec(root, 3);	insertRec(root, 7);
		insertRec(root, 1);	insertRec(root, 4);
		insertItr(root, 6);	insertItr(root, 9);
		printTree(root);
		System.out.println();
		System.out.println("5: " + searchRec(root, 5));
		System.out.println("1: " + searchRec(root, 1));
		System.out.println("2: " + searchRec(root, 2));
		System.out.println("5: " + searchItr(root, 5));
		System.out.println("1: " + searchItr(root, 1));
		System.out.println("2: " + searchItr(root, 2));
		// insertItr(root, 2);
		// System.out.println("2: " + searchItr(root, 2));
	}
}