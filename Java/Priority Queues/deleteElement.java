/* --------------------------------------------------------
	To delete an element at the Ith position in a max PQ
-------------------------------------------------------- */
public class deleteElement<Key extends Comparable<Key>> extends maxPQ {

	// initializes max priority queue
	@SuppressWarnings("unchecked")
	public deleteElement(Key[] items) {
		super(items);
	}

	// delete item at the specified index
	@SuppressWarnings("unchecked")
	public void deleteItemAt(int index) {
		// get the last element in the heap
		Comparable<Key> replacement = super.getPQ()[super.size()];
		// decrease the heap size (deleting the last element)
		super.setSize(super.size() - 1);
		// replace the element to be deleted with replacement
		super.getPQ()[index] = replacement;
		percolateDown(index);
	}	

	// percolate down and heapify
	@SuppressWarnings("unchecked")
	private void percolateDown(int index) {

		int child;
		Comparable<Key> temp = super.getPQ()[index];
		// until we reach the leaf (it has atleast left child)
		for ( 	; 2*index <= super.size()
				; index = child,
				super.getPQ()[index] = temp
			 ) {
			child = 2*index;
			
			// if right child exists
			if ((2*index + 1 <= super.size()) &&
				// if it is greater than left child
				((super.getPQ()[2*index+1]).compareTo(super.getPQ()[2*index]) > 0)) {
				child++;
			}

			// if element at child is greater than parent
			if ( (super.getPQ()[child]).compareTo(super.getPQ()[index]) > 0 ) {
				super.getPQ()[index] = super.getPQ()[child]; 
			}

			// if parent greater than both children
			else {
				break;
			}
		}
	}

	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {
		Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		deleteElement<Integer> de = new deleteElement<Integer>(array);
		de.print();
		de.deleteItemAt(3);
		System.out.println();
		de.print();
	}
}
