/* --------------------------------------------------------
	Using a single array to implement 3 stakcs (fixed max capacity)
-------------------------------------------------------- */
import java.util.Stack;
public class stackMin extends Stack<NodeWithMin> {		

	// stack push operation
	public void push(int value) {
		// if stack is empty
		if (this.empty()) {
			super.push(new NodeWithMin(value, value));
			return;			
		}
		int newMin = Math.min(value, this.peek().minValue);
		super.push(new NodeWithMin(value, newMin));
	}

	// returns the minimum value in stack
	public int min() {
		return this.peek().minValue;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		stackMin S1 = new stackMin();
		S1.push(5); S1.push(2); S1.push(3); 
		S1.push(4); S1.push(6); S1.push(1);
		System.out.println(S1.min());
		S1.pop();
		System.out.println(S1.min());
	}
}