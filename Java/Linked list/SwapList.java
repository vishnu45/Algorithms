/** -------------------------------------------------------
 *	To swap two nodes in a singly linked list
-------------------------------------------------------- */
public class SwapList {

	private Node sentinel;
	public int size;

	public SwapList() {
		sentinel = new Node(-1, null);
		size = 0;
	}

	public void Add(int x) {
		if (size == 0) {
			sentinel.next = new Node(x, null);
			size++;
			return;
		}
		Node temp = sentinel.next;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(x, null);
		size++;
		return;
	}

	public void Print() {
		Node temp = sentinel.next;
		while (temp != null) {
			StdOut.print(temp.item + " -> ");
			temp = temp.next;
		}
		StdOut.println("NULL");
	}

	// Retunrs node at the specified index
	public Node Get(int index) {
		int i = 0;
		Node temp = sentinel.next;
		while (i < index) {
			temp = temp.next;
		}
		return temp;
	}

	// Swaps nodes at the specified indices
	public void Swap(int i, int j) {
		Node startPrev = null, startCurr = null, stopPrev = null, stopCurr = null, temp;
		int start, stop, k;
		if (i < j) {
			start = i;
			stop = j;
		}
		else {
			start = j;
			stop = i;
		}

		// check if start node is to be swapped
		if (start == 0) {
			// find start nodes
			startPrev = sentinel;
			startCurr = sentinel.next;

			// find stop nodes
			temp = sentinel.next;
			for (k = 0; k < stop-1; k++) {
				temp = temp.next;
			}
			stopPrev = temp;
			stopCurr = temp.next;
		}
		else {
			// find start nodes
			temp = sentinel.next;
			for (k = 0; k < start-1; k++) {			
				temp = temp.next;
			}			
			startPrev = temp;
			startCurr = temp.next;

			// find stop nodes
			for (; k < stop-1; k++) {
				temp = temp.next;
			}
			stopPrev = temp;
			stopCurr = temp.next;
		}

		// swap nodes
		// if the nodes are not adjacent
		if (!startCurr.equals(stopPrev)) {
			temp = startCurr.next;			
		}
		else {
			temp = startCurr;
		}
		startPrev.next = stopCurr;
		startCurr.next = stopCurr.next;
		// if the nodes are not adjacent
		if (!startCurr.equals(stopPrev)) {		 	
			stopPrev.next = startCurr;			
		}		
		stopCurr.next = temp;
	}

	// -------------------- MAIN --------------------
	public static void main(String[] args) {
		SwapList S1 = new SwapList();
		S1.Add(1); S1.Add(2); S1.Add(3); S1.Add(4); S1.Add(5);
		S1.Print();
		S1.Swap(1, 2);
		S1.Print();

		SwapList S2 = new SwapList();
		S2.Add(1); S2.Add(2); S2.Add(3); S2.Add(4); S2.Add(5);
		S2.Print();
		S2.Swap(0, 3);
		S2.Print();

		SwapList S3 = new SwapList();
		S3.Add(1); S3.Add(2); S3.Add(3); S3.Add(4); S3.Add(5);
		S3.Print();
		S3.Swap(1, 3);
		S3.Print();

		SwapList S4 = new SwapList();
		S4.Add(1); S4.Add(2); S4.Add(3); S4.Add(4); S4.Add(5);
		S4.Print();
		S4.Swap(1, 0);
		S4.Print();
	}
}