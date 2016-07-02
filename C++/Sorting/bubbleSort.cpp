/* *******************************************************************
 Bubble sort implementation  
******************************************************************** */

#include <string>
#include "common.h"
#include "bubbleSort.h"

//--------------------------------------------------------------------
// Function: To sort items in an array using bubble sort
//--------------------------------------------------------------------
template<typename T>
T *BubbleSort<T>::Sort(T array[], int len, bool type)
{
	for (int i = 0; i+1 < len; i++)
	{
		for (int j = 0; j+1 < len; j++)
		{
			// ascending order sort
			if (type == true)
			{
				if (array[j] > array[j+1])
					swap(&array[j], &array[j+1]);
			}
			// descending order sort
			else
			{
				if (array[j] < array[j+1])
					swap(&array[j], &array[j+1]);	
			}
		}
	}
	return array;
}

//--------------------------------------------------------------------
// Function: Improved bubble sort implementation
//--------------------------------------------------------------------
template<typename T>
T *BubbleSort<T>::SortImp(T array[], int len, bool type)
{
	bool flag = false;
	for (int i = 0; i+1 < len; i++)
	{
		for (int j = 0; j+1 < len; j++)
		{
			if (type == true)
			{
				if(array[j] > array[j+1])
				{
					swap(&array[j], &array[j+1]);
					flag = true;
				}				
			}
			else
			{
				if(array[j] < array[j+1])
				{
					swap(&array[j], &array[j+1]);
					flag = true;
				}				
			}			
		}
		if (flag == false)
			return array;
	}
	return array;
}

template class BubbleSort<int>;
template class BubbleSort<double>;
template class BubbleSort<char>;
template class BubbleSort<std::string>;