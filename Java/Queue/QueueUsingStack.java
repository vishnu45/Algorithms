/* --------------------------------------------------------
	Implement a queue using stack data structure
-------------------------------------------------------- */
import java.util.Stack;
public class QueueUsingStack {
	
	private Stack<Integer> S1;	// to enqueue
	private Stack<Integer> S2;	// to dequeue

	// constructor
	public QueueUsingStack() {		
		S1 = new Stack<Integer>();
		S2 = new Stack<Integer>();
	}

	// To enqueue items into queue
	public void enqueue(int x) {
		S1.push(x);
	}

	// To dequeue items from queue
	public int dequeue() {
		int retVal;
		// check if queue is empty (S1 and S2 are empty)
		if (S1.empty() && S2.empty()) {
			System.out.println("Empty queue");
			return 0;
		}
		// check if S2 is empty (S1 is non empty)
		else if (S2.empty()) {
			// push items in S1 to S2
			while (!S1.empty()) {				
				S2.push(S1.pop());
			}
			retVal = S2.pop();
		}
		// if S2 is not empty (S1 could be either empty or not)
		else {
			retVal = S2.pop();
		}
		return retVal;
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		QueueUsingStack Q1 = new QueueUsingStack();
		Q1.enqueue(1); Q1.enqueue(2); Q1.enqueue(3);
		System.out.println(Q1.dequeue());
		Q1.enqueue(4);
		System.out.println(Q1.dequeue());
		Q1.enqueue(5); Q1.enqueue(6);
		System.out.println(Q1.dequeue());
		System.out.println(Q1.dequeue());
		System.out.println(Q1.dequeue());
	}
}