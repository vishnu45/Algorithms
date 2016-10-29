/* --------------------------------------------------------
 Check if a binary tree is a subtree of another binary tree
-------------------------------------------------------- */
public class bt_checkSubTree {

	// to check if two trees are same
	public static boolean sameTree(BinaryNode root1, BinaryNode root2) {
		// if both arrive at null leaves
		if (root1 == null && root2 == null) {
			return true;
		}
		// if only either has a null leaf
		if (root1 == null || root2 == null) {
			return false;
		}
		// check if both root data are equal
		// similarly check for left and right subtrees
		return ((root1.data == root2.data) &&
				sameTree(root1.left, root2.left) &&
				sameTree(root1.right, root2.right));
	}

	// to check if smallTree is a sub tree of bigTree
	public static boolean checkSub(BinaryNode bigTree, BinaryNode smallTree) {
		
		if (smallTree == null) {
			return true;
		}

		// if bigTree reaches the leaf
		if (bigTree == null) {
			return false;
		}

		// check if small tree is same as big tree		
		// if not traverse lower down and check similarity		
		
		return (sameTree(bigTree, smallTree) ||
				checkSub(bigTree.left, smallTree) ||
				checkSub(bigTree.right, smallTree));		
	}

	// ------------------------ MAIN ------------------------
	public static void main (String[] args) {
		BinaryNode bigTree = new BinaryNode(1, null, null);
		bigTree.left = new BinaryNode(2, null, null);
		bigTree.right = new BinaryNode(3, null, null);

		BinaryNode smallTree = new BinaryNode(4, null, null);
		System.out.println(checkSub(bigTree, smallTree));
		smallTree = new BinaryNode(2, null, null);
		// BinaryNode smallTree2 = new BinaryNode(2, null, null);		
		// System.out.println(sameTree(smallTree2, smallTree));
		System.out.println(checkSub(bigTree, smallTree));

		bigTree = new BinaryNode(26, null, null);
		bigTree.left = new BinaryNode(10, null, null);
		bigTree.left.left = new BinaryNode(4, null, null);
		bigTree.left.left.right = new BinaryNode(30, null, null);
		bigTree.left.right = new BinaryNode(6, null, null);
		bigTree.right = new BinaryNode(3, null, null);
		bigTree.right.right = new BinaryNode(3, null, null);

		smallTree = new BinaryNode(10, null, null);
		smallTree.left = new BinaryNode(4, null, null);
		smallTree.right = new BinaryNode(6, null, null);
		smallTree.left.right = new BinaryNode(30, null, null);
		System.out.println(checkSub(bigTree, smallTree));
		smallTree.left.right = new BinaryNode(31, null, null);
		System.out.println(checkSub(bigTree, smallTree));
	}
}