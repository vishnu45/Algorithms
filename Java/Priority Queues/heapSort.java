/* --------------------------------------------------------
	Heap sort using priority queues (ascending - maxPQ)
-------------------------------------------------------- */
public class heapSort {

	public static int[] sort(int[] array) {
		maxPQ<Integer> p = new maxPQ<Integer>(array.length);

		// add all elements into the priority queue
		for (int i = 0; i < array.length; i++) {
			p.insert(array[i]);
		}

		int[] newArray = new int[array.length];
		// remove the elements from the top
		for (int i = 0; i < newArray.length; i++) {
			// put max element into consecutive indices
			newArray[i] = p.removeMax();
		}
		return newArray;
	}


	// ------------------------ MAIN ------------------------
	public static void main(String[] args) {

		int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
		for (int i : sort(array)) {
			System.out.print(i + " ");
		}
	}
}