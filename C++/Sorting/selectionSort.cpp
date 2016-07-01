#include "selectionSort.h"

template<typename T>
T *SelectionSort<T>::Sort(T array[], int n, bool type)
{
	T temp;
	int smallIndex;
	for (int i = 0; i < n-1; i++)
	{
		smallIndex = i;
		for (int j = i+1; j < n; j++)
		{
			if (array[j] < array[smallIndex])
				smallIndex = j;				
		}
		temp = array[smallIndex];
		array[smallIndex] = array[i];
		array[i] = temp;
	}

	return array;
}

template class SelectionSort<int>;