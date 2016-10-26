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

	// returns minimum element in bst (iterative)
	public static int findMinItr(GBinaryNode<Integer> root) {
		// if null tree
		if (root == null) {
			System.out.println("Empty tree");			
			return -1;
		}
		GBinaryNode<Integer> temp = root;
		// until the left most leaf is reached
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
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

	// returns maximum element in bst (iterative)
	public static int findMaxItr(GBinaryNode<Integer> root) {
		// if null tree
		if (root == null) {
			System.out.println("Empty tree");			
			return -1;
		}
		GBinaryNode<Integer> temp = root;
		// until the right most leaf is reached
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;
	}

	// find inorder predessor and successor
	public static int[] predSucc(GBinaryNode<Integer> root, int key) {
		int[] retVal = new int[]{-1, -1};
		// null tree
		if (root == null) {
			System.out.println("Empty tree");
			return new int[]{-1, -1};
		}
		// find the key node
		GBinaryNode<Integer> keyNode = root;		
		while (true) {
			// if unable to find key in tree
			if (keyNode == null) {
				System.out.println("Key not in tree");
				return new int[]{-1, -1};	
			}
			// traverse right
			if (key > keyNode.data) {
				keyNode = keyNode.right;
			}
			// traverse left
			else if (key < keyNode.data) {
				keyNode = keyNode.left;
			}
			// found key
			else {
				break;
			}
		}
		
		GBinaryNode<Integer> predessor = keyNode.left;
		GBinaryNode<Integer> successor = keyNode.right;
		// if there are no any potential predessor for key
		if (predessor == null) {
			System.out.println("No predessor for key");			
		}
		else {
			// traverse to the right most node in left tree
			while (predessor.right != null) {
				predessor = predessor.right;
			}
			// first value in retVal is predessor
			retVal[0] = predessor.data;
		}
		// if there are no any potential successor for key
		if (successor == null) {
			System.out.println("No successor for key");			
		}
		else {
			// traverse to the left most node in right tree
			while (successor.left != null) {
				successor = successor.left;
			}
			// second value in retVal is predessor
			retVal[1] = successor.data;
		}
		return retVal;
	}

	// delete element from binary search tree
	public static GBinaryNode<Integer> delete(GBinaryNode<Integer> root, int key) {
		// if tree is empty / unable to find key
		if (root == null) {
			System.out.println("Key not found in tree");
			return root;
		}
		else {
			// traverse right
			if (key > root.data) {
				root.right = delete(root.right, key);
			}
			// traverse left
			else if (key < root.data) {
				root.left = delete(root.left, key);
			}
			// key found
			else {
				// with no child or one of either children
				if (root.left == null) {
					return root.right;
				}
				else if (root.right == null) {
					return root.left;
				}

				// with both children present - find inorder predecessor
				// replace current node with predecessor				
				GBinaryNode<Integer> predecessor = root.left;
				// find the predessor 
				while (predecessor.right != null) {				
					predecessor = predecessor.right;
				}
				// replace root data with that of predecessor
				root.data = predecessor.data;
				// delete predecessor from tree with root as current node
				root.left = delete(root.left, root.data);
			}
			return root;
		}
	}

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
		System.out.println("Min (recursive): " + findMinRec(root));
		System.out.println("Min (iterative): " + findMinItr(root));
		System.out.println("Max (recursive): " + findMaxRec(root));
		System.out.println("Max (iterative): " + findMaxItr(root));

		root = new GBinaryNode<Integer>(15, null, null);
		insertRec(root, 10); insertRec(root, 20);
		insertRec(root, 5); insertRec(root, 12);
		insertRec(root, 17); insertRec(root, 25);
		insertRec(root, 11); insertRec(root, 14);
		insertRec(root, 23); insertRec(root, 16);
		insertRec(root, 22); insertRec(root, 24);
		insertRec(root, 18);
		for (int i: predSucc(root, 15)) {
			System.out.print(i + " ");
		}
		System.out.println();
		printTree(root);
		System.out.println();
		// root = delete(root, 24);
		// root = delete(root, 22);
		// root = delete(root, 17);
		// root = delete(root, 25);
		root = delete(root, 20);
		// root = delete(root, 15);

		printTree(root);

	}
}
