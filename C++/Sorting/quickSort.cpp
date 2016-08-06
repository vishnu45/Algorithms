#include "quickSort.h"
#include "common.h"

// Function to partition array into 2 arrays based on the pivot element
int Partition(int array[], int left, int right)
{
	// right most element is taken as pivot
	int pivot = array[right];

	// index to swap elements when left elements are larger than pivot
	int i = left - 1;

	// scan through all elements until pivot element
	for (int j = left; j <= right-1; j++)
	{
		if (array[j] >= pivot)
		{
			i++;
			swap(&array[i], &array[j]);
		}
	}
	swap(&array[i+1], &array[right]);

	// return current pivot index
	return (i+1);
}

// function to divide and sort arrays recursively
void qSort(int array[], int left, int right)
{
	if (left < right)
	{
		int pivotIndex = Partition(array, left, right);

		qSort(array, left, pivotIndex-1);
		qSort(array, pivotIndex+1, right);
	}
	return;
}

// Function to perform quicksort
void QuickSort::Sort(int array[], int length, bool type)
{
	qSort(array, 0, length-1);
	return;
}

