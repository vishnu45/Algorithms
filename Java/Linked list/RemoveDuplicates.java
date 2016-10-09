/** -------------------------------------------------------
 *	To swap two nodes in a singly linked list
-------------------------------------------------------- */
import java.util.*;
public class RemoveDuplicates {

	private Node sentinel;
	public int size;

	public RemoveDuplicates() {
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

	public void Remove() {
		Node temp = sentinel.next;
		Node prev = null;
		if (temp == null) {
			System.out.println("List is empty");
			return;
		}
		// create a hash set to leep track in case duplicates occur
		HashSet<Integer> S = new HashSet<Integer>();
		// until last node is reached
		while (temp != null) {
			// if element not present in hashset
			if (!S.contains(temp.item)) {
				// add element to hashset
				S.add(temp.item);
			}
			// if element already present in hashset (duplicate in list)
			else {
				// point previous element to next element
				prev.next = temp.next;
				// advance to next element
				temp = temp.next;
				// decrease list size
				size--;
				continue;
			}
			// keep track of prev element in order to remove duplicates
			prev = temp;
			temp = temp.next;
		}
	}


	// -------------------- MAIN --------------------
	public static void main(String[] args) {
		RemoveDuplicates S1 = new RemoveDuplicates();
		S1.Add(4); S1.Add(4); S1.Add(4); S1.Add(4); S1.Add(4);
		S1.Print();
		S1.Remove();
		S1.Print();
	}

}