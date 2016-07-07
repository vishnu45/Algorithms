#include "mergeSort.h"
#include <string>

#include <iostream>
using namespace std;

template<typename T>
void merge(T array [], int left, int middle, int right, bool type) {

	int len1 = middle - left + 1;
	int len2 = right - middle;
	T array1[len1], array2[len2];

	for (int i = 0; i < len1; i++)
		array1[i] = array[left + i];
	for (int i = 0; i < len2; i++)
		array2[i] = array[middle + 1 + i];

	// merging arrays together
	int i, j, k;
	for (i = left , j = 0, k = 0; j < len1 && k < len2; i++)
	{
		if (type)
		{
			if (array1[j] <= array2[k])
				array[i] = array1[j++];
			else
				array[i] = array2[k++];
		}
		else
		{
			if (array1[j] >= array2[k])
				array[i] = array1[j++];
			else
				array[i] = array2[k++];
		}
	}

	while (j < len1)
		array[i++] = array1[j++];
	while (k < len2)
		array[i++] = array2[k++];

	return;
}

template<typename T>
void divide(T array[], int left, int right, bool type) {

	if (left < right)
	{
		// calculate middle
		int middle = left + ((right - left)/2);

		// again divide
		divide(array, left, middle, type);
		divide(array, middle+1, right, type);

		merge(array, left, middle, right, type);
	}
	return;
}

template<typename T>
T *MergeSort<T>::Sort(T array[], int len, bool type) {

	divide(array, 0, len-1, type);
	return array;
}

template class MergeSort<int>;