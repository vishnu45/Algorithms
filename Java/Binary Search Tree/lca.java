/* --------------------------------------------------------
	Given values of two nodes in a BST, find the Lowest
	Common Ancestor (LCA).
-------------------------------------------------------- */
public class lca{

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

	// return the lca node
	public static GBinaryNode<Integer> findLCA(GBinaryNode<Integer> root,
	 int a, int b) {
		// check if tree null
		if (root == null) {
			System.out.println("Empty tree");
			return null;
		}
		// check the node where a <= node <= b		
		while (root != null) {
			// if condition satisfied current node is lca
			if (a <= root.data && root.data <= b) {
				return root;
			}
			// move left
			else if (a <= root.data) {
				root = root.left;
			}
			// move right
			else if (a >= root.data) {
				root = root.right;
			}
		}
		// if not present, then the key is not present in tree
		System.out.println("Keys not found in tree");
		return null;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		GBinaryNode<Integer> root = new GBinaryNode<Integer>(15, null, null);
		insertRec(root, 10); insertRec(root, 20);
		insertRec(root, 5); insertRec(root, 12);
		insertRec(root, 17); insertRec(root, 25);
		insertRec(root, 11); insertRec(root, 14);
		insertRec(root, 23); insertRec(root, 16);
		insertRec(root, 22); insertRec(root, 24);
		insertRec(root, 18);
		System.out.println(findLCA(root, 5, 12).data);
		findLCA(root, 15, 12);
		System.out.println(findLCA(root, 10, 24).data);
		System.out.println(findLCA(root, 16, 22).data);
		System.out.println(findLCA(root, 15, 24).data);
	}
}