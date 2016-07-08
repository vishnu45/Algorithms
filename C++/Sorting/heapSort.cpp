#include "heapSort.h"
#include <string>

template<typename T>
void heapify(T array[], int pos, int length, bool type)
{
	int left = 2 * pos + 1;
	int right = 2 * pos + 2;
	int swap = pos;
	T temp;
	
	if (type)
	{
		if (left < length && array[left] > array[pos])
			swap = left;

		if (right < length && array[right] > array[swap])
			swap = right;
		if (swap != pos)
		{
			temp = array[pos];
			array[pos] = array[swap];
			array[swap] = temp;

			heapify(array, swap, length, type);
		}
	}

	else
	{
		if (left < length && array[left] > array[pos])
			swap = left;

		if (right < length && array[right] > array[swap])
			swap = right;
		if (swap != pos)
		{
			temp = array[pos];
			array[pos] = array[swap];
			array[swap] = temp;

			heapify(array, swap, length, type);
		}
	}	

	return;
}

template<typename T>
T *HeapSort<T>::Sort(T array[], int length, bool type) {

	T temp;
	// build max heap
	for (int i = length/2 - 1; i >= 0; i--)
		heapify(array, i, length, type);

	for (int i = length; i > 1; i--)
	{
		// take the largest element at the root
		temp = array[i-1];
		array[i-1] = array[0];
		array[0] = temp;

		// heapify
		heapify(array, 0, i-1, type);
	}

	return array;
}

template class HeapSort<int>;
template class HeapSort<char>;
template class HeapSort<double>;
template class HeapSort<std::string>;