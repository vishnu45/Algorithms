#include "insertionSort.h"
#include "common.h"
#include <string>
// #include <iostream>
// using namespace std;

template<typename T>
T *InsertionSort<T>::Sort(T array[], int len, bool type)
{
	int i, j, temp;
	if (type)
	{
		for (i = 1; i < len; i++)
		{
			j = i - 1;
			temp = array[i];
			while (temp < array[j] && j >= 0)
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
			// for debuggin
			// for (int k = 0; k < len; k++)
			// 	cout << array[k] << " ";
			// cout << endl;
		}
	}
	else
	{
		for (i = 1; i < len; i++)
		{
			j = i - 1;
			temp = array[i];
			while (temp > array[j] && j >= 0)
			{
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
	}
	return array;
}

template class InsertionSort<int>;