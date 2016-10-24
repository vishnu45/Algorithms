/* --------------------------------------------------------
	To construct tree given preOrder and inOrder traversal order
-------------------------------------------------------- */
import java.util.*;
public class bt_treeConstruct {
	
	public static int preOrderIndex = 0;

	// constructs tree from preOrder and inOrder
	public static GBinaryNode<Character> constructTree(
		char[] inOrder, char[] preOrder, int start, int end) {

		if (start > end) {
			return null;
		}

		// take the node from inOrder which will be current node		
		GBinaryNode<Character> tNode = new GBinaryNode<Character>(preOrder[preOrderIndex], null, null);
		// move to next node
		preOrderIndex++;

		// if this is a leaf return
		if (start == end) {
			return tNode;
		}

		// else, search for index of node in inOrder
		int index = searchInorder(inOrder, start, end, tNode.data);

		// construct left and right children
		tNode.left = constructTree(inOrder, preOrder, start, index-1);
		tNode.right = constructTree(inOrder, preOrder, index+1, end);

		// return final tree (root node)
		return tNode;
	}

	// find node in inOrder array
	public static int searchInorder(char[] inOrder, int start, int end, char data) {
		int i;
		for (i = start; i <= end; i++) {
			if (inOrder[i] == data) {
				break;
			}
		}
		return i;
	}

	// prints the tree
	public static void printTree(GBinaryNode<Character> root) {
		// if leaf children are reached
		if (root == null) {
			return;
		}
		printTree(root.left);
		System.out.print(root.data + " ");
		printTree(root.right);		
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		char[] inOrder = {'D', 'B', 'E', 'A', 'F', 'C'};
		char[] preOrder = {'A', 'B', 'D', 'E', 'C', 'F'};
		GBinaryNode<Character> tree = constructTree(inOrder, preOrder, 0, preOrder.length - 1);		
		printTree(tree);
	}
}