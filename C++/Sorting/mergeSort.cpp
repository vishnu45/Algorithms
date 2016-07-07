/* *******************************************************************
 Merge sort implementation  
******************************************************************** */

#include "mergeSort.h"
#include <string>

//--------------------------------------------------------------------
// Function: To merge the divided arrays by arranging values in
//			 asending or descending order
//--------------------------------------------------------------------
template<typename T>
void merge(T array [], int left, int middle, int right, bool type) {

	// calculate length of the 2 sub arrays used for storing the split array
	int len1 = middle - left + 1;
	int len2 = right - middle;
	T array1[len1], array2[len2];

	// store the values into the sub arrays
	for (int i = 0; i < len1; i++)
		array1[i] = array[left + i];
	for (int i = 0; i < len2; i++)
		array2[i] = array[middle + 1 + i];

	// merge the two arrays together
	int i, j, k;
	for (i = left , j = 0, k = 0; j < len1 && k < len2; i++)
	{
		// check for ascending or descending sort
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

	// store rest of the elements into the merged array
	while (j < len1)
		array[i++] = array1[j++];
	while (k < len2)
		array[i++] = array2[k++];

	return;
}

//--------------------------------------------------------------------
// Function: To divide the array into sub arrays
//--------------------------------------------------------------------
template<typename T>
void divide(T array[], int left, int right, bool type) {

	if (left < right)
	{
		// calculate middle index
		int middle = left + ((right - left)/2);

		// again divide
		divide(array, left, middle, type);
		divide(array, middle+1, right, type);

		// sort and merge the divided arrays
		merge(array, left, middle, right, type);
	}
	return;
}

//--------------------------------------------------------------------
// Function: To sort items in an array using merge sort
//--------------------------------------------------------------------
template<typename T>
T *MergeSort<T>::Sort(T array[], int len, bool type) {

	// send the array to the divide and conquer function
	divide(array, 0, len-1, type);
	return array;
}

template class MergeSort<int>;
template class MergeSort<char>;
template class MergeSort<double>;
template class MergeSort<std::string>;