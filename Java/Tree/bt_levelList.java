/* --------------------------------------------------------
 Create linked lists of all nodes at each depth of a binary
 search tree
-------------------------------------------------------- */
import java.util.*;
public class bt_levelList {

	// returns an List<List> of all nodes at each level
	public static LinkedList<LinkedList<Integer>> getList(BinaryNode root) {
		// main list to store sub lists (for each level)
		LinkedList<LinkedList<Integer>> levelList = new LinkedList<LinkedList<Integer>>();
		// queue for level order traversal
		LinkedList<BinaryNode> QueueNode = new LinkedList<BinaryNode>();
		if (root == null) {
			System.out.println("Empty tree");
			return null;
		}
		// add the root to the queue
		QueueNode.add(root);

		// until all the nodes have been sent through the queue
		while (QueueNode.size() > 0) {
			LinkedList<Integer> lList = new LinkedList<Integer>();

			// find how many nodes are present at current level
			int size = QueueNode.size();					

			// for all nodes present at current level, 
			// add them to new list for this level
			for (BinaryNode node : QueueNode) {
				lList.add(node.data);
			}
			// add this list to the main list(for all levels)
			levelList.add(lList);
			
			// for all the nodes in current queue
			while(size > 0) {
				// take out each item
				BinaryNode node = QueueNode.remove();
				// if node has left child
				if (node.left != null) {
					// add child to queue					
					QueueNode.add(node.left);					
				}
				// if node has right child
				if (node.right != null) {
					// add child to queue
					QueueNode.add(node.right);
				}
				size--;			
			}
		}		
		return levelList;
	}	

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1, null, null);
		root.left = new BinaryNode(2, null, null);
		root.left.left = new BinaryNode(4, null, null);
		root.left.right = new BinaryNode(5, null, null);
		root.right = new BinaryNode(3, null, null);
		root.right.left = new BinaryNode(6, null, null);
		root.right.right = new BinaryNode(7, null, null);
		root.left.left.left = new BinaryNode(8, null, null);
		root.right.right.right = new BinaryNode(11, null, null);
		for (LinkedList<Integer> list : getList(root)) {
			System.out.println(list);
		}
	}
}