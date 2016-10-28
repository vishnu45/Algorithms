/* --------------------------------------------------------
 Create a binary tree with minimal height given a sorted 
 array (ascending order)
-------------------------------------------------------- */

public class bt_treeFromArray {

	// creates a binary tree from the sorted array
	public static BinaryNode getTree(int[] array, int start, int end) {
		BinaryNode root;
		// when the leaf is reached
		if (start > end) {
			return null;
		}

		int middle = start + (end - start)/2;
		root = new BinaryNode(array[middle], null, null);
		root.left = getTree(array, start, middle - 1);
		root.right = getTree(array, middle + 1, end);
		return root;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
		BinaryNode tree = getTree(array, 0, 6);
		System.out.println(tree.data);
		System.out.println(tree.left.data + " " + tree.right.data);
		System.out.println(tree.left.left.data 
							+ " " + tree.left.right.data
							+ " " + tree.right.left.data
							+ " " + tree.right.right.data);
	}
}