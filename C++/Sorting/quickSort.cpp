#include "quickSort.h"
#include "common.h"
#include <string>

// Function to partition array into 2 arrays based on the pivot element
template<typename T>
int Partition(T array[], int left, int right, bool type)
{
	// right most element is taken as pivot
	T pivot = array[right];

	// index to swap elements when left elements are larger than pivot
	int i = left - 1;

	// for ascending sort
	if (type)
	{
		// scan through all elements until pivot element
		for (int j = left; j <= right-1; j++)
		{		
			if (array[j] <= pivot)
			{
				i++;
				swap(&array[i], &array[j]);
			}
		}
	}
	// for descending sort
	else
	{
		// scan through all elements until pivot element
		for (int j = left; j <= right-1; j++)
		{		
			if (array[j] >= pivot)
			{
				i++;
				swap(&array[i], &array[j]);
			}
		}
	}

	// place the pivot element in the position just after all the 
	// smaller elements 
	swap(&array[i+1], &array[right]);

	// return current pivot index
	return (i+1);
}

// function to divide and sort arrays recursively
template<typename T>
void qSort(T array[], int left, int right, bool type)
{
	if (left < right)
	{
		int pivotIndex = Partition(array, left, right, type);

		// quicksort the two partitions excluding the pivot element
		qSort(array, left, pivotIndex-1, type);
		qSort(array, pivotIndex+1, right, type);
	}
	return;
}

// Function to perform quicksort
template<typename T>
void QuickSort<T>::Sort(T array[], int length, bool type)
{
	qSort(array, 0, length-1, type);
	return;
}

template class QuickSort<int>;
template class QuickSort<double>;
template class QuickSort<char>;
template class QuickSort<std::string>;