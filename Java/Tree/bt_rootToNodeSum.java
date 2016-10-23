/* --------------------------------------------------------
	To print out all root-to-leaf paths with sum value
-------------------------------------------------------- */
import java.util.*;
public class bt_rootToNodeSum {

	//prints out all root-to-leaf path
	public static boolean sumCheck(BinaryNode root, int sum) {
		int fnSum = sum;
		// if root has reached, check sum
		if (root == null) {
			return fnSum == 0;
		}		
		fnSum = fnSum - root.data;
		if (fnSum == 0) {
			return true;
		}
		return (sumCheck(root.left, fnSum) 
			|| (sumCheck(root.right, fnSum)));
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
		System.out.println(sumCheck(root, 5));
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
		// rootToLeaf(root, new ArrayList<Integer>());
	}
}