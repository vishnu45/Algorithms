
#include "heapSort.h"

template<typename T>
void heapify(T array[], int pos, int length)
{
	int left = 2 * pos + 1;
	int right = 2 * pos + 2;
	int largest = pos;
	int temp;

	if (left < length && array[left] > array[pos])
		largest = left;

	if (right < length && array[right] > array[largest])
		largest = right;

	if (largest != pos)
	{
		temp = array[pos];
		array[pos] = array[largest];
		array[largest] = temp;

		heapify(array, largest, length);
	}

	return;
}

template<typename T>
T *HeapSort<T>::Sort(T array[], int length, bool type) {

	int temp;
	// build max heap
	for (int i = length/2 - 1; i >= 0; i--)
		heapify(array, i, length);

	for (int i = length; i > 1; i--)
	{
		// take the largest element at the root
		temp = array[i-1];
		array[i-1] = array[0];
		array[0] = temp;

		// heapify
		heapify(array, 0, i-1);
	}

	return array;
}

template class HeapSort<int>;
