/* --------------------------------------------------------
 Reverse stack using recursion
-------------------------------------------------------- */
import java.util.Stack;
public class reverseStack {	

	// Retunrs the reversed stack
	public static Stack<Integer> reverse(Stack<Integer> stk) {
		if (stk.empty()) {
			return;
		}
		int temp = stk.pop();
		reverse(stk, temp);
		InsertAtBottom(stk, temp);
	}

	// Returns bottom element
	public static int InsertAtBottom(Stack<Integer> stk, int data) {
		if (stk.empty()) {
			stk.push(data);
		}
		else {
			int temp = stk.pop();
			
		}
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(1); stk.push(2); stk.push(3); stk.push(4);
		System.out.println("Original stack:");
		System.out.println(stk);
		System.out.println("Reversed stack:");
		System.out.println(reverse(stk));
	}
}