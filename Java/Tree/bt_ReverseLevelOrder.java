/* --------------------------------------------------------
	Size of a binary tree (recursive and iterative)
-------------------------------------------------------- */
import java.util.*;
public class bt_ReverseLevelOrder {

	// prints the nodes in reverse level order
	public static void ReverseLevelOrder(BinaryNode root) {
		BinaryNode temp;
		Queue<BinaryNode> NodeQueue = new LinkedList<BinaryNode>();
		Stack<BinaryNode> NodeStack = new Stack<BinaryNode>();
		NodeQueue.add(root);		

		while (NodeQueue.size() != 0) {
			temp = NodeQueue.remove();			
			if (temp.right != null) {
				NodeQueue.add(temp.right);				
			}
			if (temp.left != null) {
				NodeQueue.add(temp.left);				
			}
			NodeStack.push(temp);
		}

		while (!NodeStack.empty()) {
			System.out.print(NodeStack.pop().data + " ");
		}
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
		ReverseLevelOrder(root);
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
		ReverseLevelOrder(root);
	}
}