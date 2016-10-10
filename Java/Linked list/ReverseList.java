/** -------------------------------------------------------
 *	To retrieve the nth element from last in a linked list
-------------------------------------------------------- */
public class ReverseList {	

	public ReverseList(SList S) {
		// if list size is less than 2 return as such
		if (S.Size() <= 1) {
			return;
		}
		Node tempPrev, tempCurr, tempNext;
		tempPrev = S.sentinel.next;
		tempCurr = tempPrev.next;		
		// traverse until list end is reached
		while (tempCurr != null) {
			tempNext = tempCurr.next;	
			tempCurr.next = tempPrev;
			tempPrev = tempCurr;
			tempCurr = tempNext;			
		}
		S.sentinel.next.next = null;
		S.sentinel.next = tempPrev;
	}

	// ----------------------- MAIN -----------------------
	public static void main(String[] args) {

		SList S1 = new SList();
		S1.InsertBack(1); S1.InsertBack(2);	S1.InsertBack(3);
		S1.InsertBack(4); S1.InsertBack(5);	S1.InsertBack(6);
		S1.Print();
		ReverseList R = new ReverseList(S1);
		S1.Print();

	}
}