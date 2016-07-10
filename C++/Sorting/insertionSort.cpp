/* *******************************************************************
 Insertion sort implementation  
******************************************************************** */

#include "insertionSort.h"
#include "common.h"
#include <string>
// #include <iostream>
// using namespace std;

//--------------------------------------------------------------------
// Function: To sort elements of an arrays using insertion sort
//--------------------------------------------------------------------
template<typename T>
T *InsertionSort<T>::Sort(T array[], int len, bool type)
{
	int i, j;
	T temp;

	// ascending sort
	if (type)
	{
		// start from the second element
		for (i = 1; i < len; i++)
		{
			j = i - 1;
			
			// store current element in temp location
			temp = array[i];

			// check wether temp element is smaller than previous elements
			while (temp < array[j] && j >= 0)
			{
				// if so swap advance elements one place forward
				array[j+1] = array[j];
				j--;
			}
			// place the temp element in the ascending order
			array[j+1] = temp;
			
			// for debuggin
			// for (int k = 0; k < len; k++)
			// 	cout << array[k] << " ";
			// cout << endl;
		}
	}

	// descending sort
	else
	{
		// start from the second element
		for (i = 1; i < len; i++)
		{
			j = i - 1;
			
			temp = array[i];

			// check wether temp element is larger than previous elements
			while (temp > array[j] && j >= 0)
			{
				// if so swap advance elements one place forward
				array[j+1] = array[j];
				j--;
			}
			// place the element in the descending order
			array[j+1] = temp;
		}
	}
	return array;
}

template class InsertionSort<int>;
template class InsertionSort<char>;
template class InsertionSort<double>;
template class InsertionSort<std::string>;