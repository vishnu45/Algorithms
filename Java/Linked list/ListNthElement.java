/** -------------------------------------------------------
 *	To retrieve the nth element from last in a linked list
-------------------------------------------------------- */
public class ListNthElement {	

	private Node nthElement;

	public ListNthElement(SList S, int N) {
		Node temp1, temp2;
		temp1 = S.sentinel;
		temp2 = S.sentinel;
		int i = 0;
		while (i < N) {
			temp1 = temp1.next;
			i++;
		}
		while (temp1 != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		nthElement = temp2;
	}

	public Node nthElement() { return nthElement; }

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {

		SList S1 = new SList();
		S1.InsertBack(1); S1.InsertBack(2);	S1.InsertBack(3);
		S1.InsertBack(4); S1.InsertBack(5);	S1.InsertBack(6);
		S1.Print();
		ListNthElement L = new ListNthElement(S1, 5);
		System.out.println("Nth from last: " + L.nthElement().item);
		L = new ListNthElement(S1, 1);
		System.out.println("Nth from last: " + L.nthElement().item);
	}
}