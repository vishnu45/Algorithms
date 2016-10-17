/* --------------------------------------------------------
	Set of stacks implementation
-------------------------------------------------------- */
import java.util.ArrayList;
import java.util.Stack;
public class SetOfStacks {		

	ArrayList<Stack<Integer>> stackSet = new ArrayList<Stack<Integer>>();
	private int capacity;
	private int size;

	// constructor which decides stack set capacity
	public SetOfStacks(int capacity) {
		this.capacity = capacity;		
		size = 0;
	}

	// check if stack capacity has reached
	private boolean isAtCapacity() {
		if (size == capacity) {
			return true;
		}
		return false;
	}

	// returns the latest stack set
	private Stack<Integer> getLastSet() {
		// check if no stacks have yet been assinged
		if (stackSet.size() == 0) {
			return null;
		}
		return stackSet.get(stackSet.size()-1);
	}
	
	// push items onto stack
	public void push(int value) {
		Stack<Integer> tempStack = getLastSet();
		// check if no stacks have yet been created in the set
		if (tempStack == null) {
			stackSet.add(new Stack<Integer>());
			getLastSet().push(value);
			size = 1;
			return;
		}
		// if already stacks are present but not reached max cap
		else if (!isAtCapacity()) {
			tempStack.push(value);
			size++;
			return;
		}
		// if current stack has reached max cap		
		stackSet.add(new Stack<Integer>());
		getLastSet().push(value);
		size = 1;
	}

	// pop items from stack
	public int pop() {
		// check if stack set is empty
		if (getLastSet() == null) {
			System.out.println("Empty Stack set");
			return -1;
		}
		// get the top value on stack
		int retVal;
		Stack<Integer> temp = getLastSet();
		retVal = temp.pop();
		size--;
		// if stack is empty, remove it from list
		if (size == 0) {			
			stackSet.remove(stackSet.size() - 1);
			size = capacity;
		}
		return retVal;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		SetOfStacks ST = new SetOfStacks(3);
		ST.push(1); ST.push(2); ST.push(3); ST.push(4);
		ST.push(5); ST.push(6); ST.push(7); ST.push(8);
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
		System.out.println(ST.pop());
	}
}
