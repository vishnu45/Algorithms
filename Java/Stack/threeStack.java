/* --------------------------------------------------------
	Using a single array to implement 3 stakcs (fixed max capacity)
-------------------------------------------------------- */
public class threeStack {

	// size of each stack in array
	private static int stackSize = 10;
	// array to hold all three stacks
	private int[] buffer;
	// stack pointer to keep track of top element in each stack
	private int[] stackPointer = {0, 0, 0};

	// constructor
	public threeStack() {
		buffer = new int[3 * stackSize];		
	}

	// stack push operation
	public void push(int stack, int value) {
		// check if stack full
		if (stackPointer[stack] >= (stack+1)*stackSize) {
			System.out.println("Stack is full");
			return;
		}
		// find index where item has to be inserted
		buffer[stack * stackSize + stackPointer[stack]] = value;
		// update stack pointer
		stackPointer[stack]++;
	}

	// stack pop operation
	public int pop(int stack) {
		// check if stack is empty
		if (stackPointer[stack] == 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		// decrement stack pointer to move to top value
		stackPointer[stack]--;
		// get the top value in the stack
		int retVal = buffer[stack * stackSize + stackPointer[stack]];
		return retVal;
	}

	// stack peek operation
	public int peek(int stack) {
		// check if stack is empty
		if (stackPointer[stack] == 0) {
			System.out.println("Stack is empty");
			return 0;
		}
		// get the top value in the stack
		int retVal = buffer[stack * stackSize + stackPointer[stack] - 1];	
		return retVal;
	}

	// returns the string representation of particular stack
	public String toString(int stack) {
		String stkStr = "";
		int start = stack * stackSize;
		for (int i = start; i < start + stackPointer[stack]; i++) {
			stkStr += buffer[i] + " -> ";
		}
		stkStr += "END";
		return stkStr;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		threeStack t3 = new threeStack();
		t3.push(0, 0); t3.push(0, 1); t3.push(0, 2);
		t3.push(1, 10); t3.push(1, 11); t3.push(1, 12);
		t3.push(2, 20); t3.push(2, 21); t3.push(2, 22);
		System.out.println(t3.toString(0));
		System.out.println(t3.toString(1));
		System.out.println(t3.toString(2));
		System.out.println(t3.pop(0));
		System.out.println(t3.toString(0));
		System.out.println(t3.pop(0));
		System.out.println(t3.pop(0));
		System.out.println(t3.pop(0));
	}
}