/* --------------------------------------------------------
	Sorting using stacks
-------------------------------------------------------- */
import java.util.Stack;
public class sortStack {		

	private Stack<Integer> sorted = new Stack<Integer>();	

	// constructor which sorts the given stack and stores in sorted
	public sortStack(Stack<Integer> unsorted) {
		int temp;

		// sort until unsorted stack is empty
		while (!unsorted.empty()) {
			temp = unsorted.pop();
			// pop items from sorted if they are larger than temp
			while (!sorted.empty() && sorted.peek() > temp) {
				// store the poped items into unsorted
				unsorted.push(sorted.pop());
			}
			// store the smaller temp into sorted
			sorted.push(temp);
		}
	}

	// returns the sorted stack
	public Stack<Integer> sorted() {
		return sorted;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		Stack<Integer> S1 = new Stack<Integer>();
		S1.push(3); S1.push(1); S1.push(5); 
		S1.push(2); S1.push(4); 
		System.out.println("OLD STACK: " + S1.toString());
		sortStack S = new sortStack(S1);
		System.out.println("NEW STACK: " + S.sorted());
	}
}