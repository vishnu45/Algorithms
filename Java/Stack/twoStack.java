/* --------------------------------------------------------
 Implementation of 2 stacks in an array
-------------------------------------------------------- */
import java.util.Stack;
public class twoStack {	

	private int size;
	private int top1, top2;
	private int[] array;

	// twoStack constructor
	public twoStack(int n) {
		array = new int[n];
		size = n;
		top1 = 0;
		top2 = size - 1;
	}

	// push element to stack1
	public void push1(int value) {
		// array if completely full
		if (top1 > top2) {
			System.out.println("Stack1 is full");
			return;
		}
		array[top1] = value;
		top1++;
	}

	// pop element from stack1
	public int pop1() {
		// check if stack empty
		if (top1 < 0) {
			System.out.println("Stack1 is empty");
			return 0;
		}
		int ret = array[top1];
		top1--;
		return ret;
	}

	// push element to stack2
	public void push2(int value) {
		// array if completely full
		if (top1 > top2) {
			System.out.println("Stack2 is full");
			return;
		}
		array[top2] = value;
		top2--;
	}

	// pop element from stack2
	public int pop2() {
		// check if stack empty
		if (top2 >= size) {
			System.out.println("Stack2 is empty");
			return 0;
		}
		int ret = array[top2];
		top2++;
		return ret;
	}

	// print element in stack1
	public void print1() {
		for (int i = 0; i < top1; i++) {
			System.out.print(array[i] + " ");
		}
	}

	// print element in stack2
	public void print2() {
		for (int i = size-1; i > top2; i--) {
			System.out.print(array[i] + " ");
		}
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {
		
		twoStack T = new twoStack(10);
		T.push1(1); T.push1(2); T.push1(3); T.push1(4);
		T.push2(10); T.push2(11);
		T.push1(5); T.push1(6); T.push1(7); T.push1(8);
		T.push1(9);
		T.push2(12);
		T.print1();
		System.out.println();
		T.print2();
	}
}