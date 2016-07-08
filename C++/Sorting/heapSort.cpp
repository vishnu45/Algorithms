/* *******************************************************************
 Heap sort implementation  
******************************************************************** */
#include "heapSort.h"
#include <string>

//--------------------------------------------------------------------
// Function: To heapify the array into a min heap or max heap
//--------------------------------------------------------------------
template<typename T>
void heapify(T array[], int pos, int length, bool type)
{
	// determine the left and right children
	int left = 2 * pos + 1;
	int right = 2 * pos + 2;

	// index of the greatest/smallest element (parent, left child, right child)
	int swap = pos;
	T temp;
	
	// for ascending sort
	if (type)
	{
		// check if a left child exists, 
		// if so check if it is greater than parent
		if (left < length && array[left] > array[pos])
			swap = left;

		// check if a right child exists, 
		// if so check if it is greater than greatest(parent, left)
		if (right < length && array[right] > array[swap])
			swap = right;

		// if children are greater than parent swap them
		if (swap != pos)
		{
			temp = array[pos];
			array[pos] = array[swap];
			array[swap] = temp;

			// heapify the node which was swapped
			heapify(array, swap, length, type);
		}
	}

	// for descending sort
	else
	{
		// check if a left child exists, 
		// if so check if it is smaller than parent
		if (left < length && array[left] > array[pos])
			swap = left;

		// check if a right child exists, 
		// if so check if it is smaller than smallest(parent, left)
		if (right < length && array[right] > array[swap])
			swap = right;

		// if children are greater than parent swap them
		if (swap != pos)
		{
			temp = array[pos];
			array[pos] = array[swap];
			array[swap] = temp;

			// heapify the node which was swapped
			heapify(array, swap, length, type);
		}
	}	

	return;
}

//--------------------------------------------------------------------
// Function: To perform the heapsort on the array
//--------------------------------------------------------------------
template<typename T>
T *HeapSort<T>::Sort(T array[], int length, bool type) {

	T temp;
	// build max heap by heapifying the given array
	for (int i = length/2 - 1; i >= 0; i--)
		heapify(array, i, length, type);

	for (int i = length; i > 1; i--)
	{
		// take the largest/smallest element at the root,
		// then swap it with the last element in the heap
		temp = array[i-1];
		array[i-1] = array[0];
		array[0] = temp;

		// heapify the array excluding the last element in current heap
		heapify(array, 0, i-1, type);
	}

	return array;
}

template class HeapSort<int>;
template class HeapSort<char>;
template class HeapSort<double>;
template class HeapSort<std::string>;