/* --------------------------------------------------------
 To find the ceil and floor keys in BST for requested value
-------------------------------------------------------- */
public class ceilFloorBST {

	// returns the ceil key for given value
	public static int getCeil(GBinaryNode<Integer> root, int value) {
		// if null tree
		if (root == null) {
			return -1;
		}		
		// in case value == root key
		if (root.data == value) {
			return root.data;
		}
		// if value > root key
		else if (value > root.data) {
			return getCeil(root.right, value);
		}
		// if value < root key		
		int ceil = getCeil(root.left, value);		
		return (ceil >= value) ? ceil : root.data;
	}

	// returns the floor key for given value
	public static int getFloor(GBinaryNode<Integer> root, int value) {
		// if null tree
		if (root == null) {
			return -1;
		}		
		// in case value == root key
		if (root.data == value) {
			return root.data;
		}
		// if value < root key
		else if (value < root.data) {
			return getFloor(root.left, value);
		}
		// if value > root key		
		int floor = getFloor(root.right, value);
		if (value >= root.data) {
			System.out.println(root.data);
			return root.data;
		}
		else {
			return floor;
		}		
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		GBinaryNode<Integer> root = new GBinaryNode<Integer>(8, null, null);
		root.left = new GBinaryNode<Integer>(4,  null, null);
		root.left.left = new GBinaryNode<Integer>(2, null, null);
		root.left.right = new GBinaryNode<Integer>(6, null, null);
		root.right = new GBinaryNode<Integer>(12, null, null);
		root.right.left = new GBinaryNode<Integer>(10, null, null);
		root.right.right = new GBinaryNode<Integer>(14, null, null);
		// System.out.println(getCeil(root, 1));
		// System.out.println(getCeil(root, 3));
		// System.out.println(getCeil(root, 15));
		System.out.println(getFloor(root, 1));		
		// System.out.println(getFloor(root, 11));
		System.out.println(getFloor(root, 15));
	}		
}