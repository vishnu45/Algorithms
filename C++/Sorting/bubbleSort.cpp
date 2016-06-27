#include <string>
#include "bubbleSort.h"

template<typename T>
void swap(T *a, T *b)
{
	T temp;
	temp = *a;
	*a = *b;
	*b = temp;
	return;
}

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

template class BubbleSort<int>;
template class BubbleSort<double>;
template class BubbleSort<char>;
template class BubbleSort<std::string>;