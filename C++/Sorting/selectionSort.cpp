#include "selectionSort.h"
#include "common.h"
#include <string>

template<typename T>
T *SelectionSort<T>::Sort(T array[], int n, bool type)
{
	int smallIndex;
	
	// ascending order sort
	if (type)
	{
		for (int i = 0; i < n-1; i++)
		{
			smallIndex = i;
			for (int j = i+1; j < n; j++)
			{
				if (array[j] < array[smallIndex])
					smallIndex = j;				
			}
			swap(&array[smallIndex], &array[i]);
		}
	}
	
	// descending order sort
	else
	{
		for (int i = 0; i < n-1; i++)
		{
			smallIndex = i;
			for (int j = i+1; j < n; j++)
			{
				if (array[j] > array[smallIndex])
					smallIndex = j;				
			}
			swap(&array[smallIndex], &array[i]);
		}	
	}

	return array;
}

template class SelectionSort<int>;
template class SelectionSort<char>;
template class SelectionSort<double>;
template class SelectionSort<std::string>;