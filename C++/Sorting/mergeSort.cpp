#include "mergeSort.h"
#include <string>

#include <iostream>
using namespace std;

template<typename T>
void merge(T array [], int left, int middle, int right) {

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
		if (array1[j] <= array2[k])
		{
			array[i] = array1[j];
			j++;
		}
		else
		{
			array[i] = array2[k];
			k++;
		}
	}

	while (j < len1)
	{
		array[i] = array1[j];
		i++;
		j++;
	}

	while (k < len2)
	{
		array[i] = array2[k];
		i++;
		k++;
	}

	return;
}

template<typename T>
void divide(T array[], int left, int right) {

	if (left < right)
	{
		// calculate middle
		int middle = left + ((right - left)/2);

		// again divide
		divide(array, left, middle);
		divide(array, middle+1, right);

		merge(array, left, middle, right);		
	}
	return;
}

template<typename T>
T *MergeSort<T>::Sort(T array[], int len) {

	divide(array, 0, len-1);
	return array;
}

template class MergeSort<int>;