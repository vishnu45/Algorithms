/* *******************************************************************
 Binary search implementation  
******************************************************************** */

 #include "binarySearch.h"
 #include <string>

//--------------------------------------------------------------------
// Function: To find item in array using binary serach
//--------------------------------------------------------------------	
template<typename T>
int BinarySearch<T>::Search(T array[], int length, T data)
{
	int low = 0, high = length - 1;
	int mid;

	while (low <= high)
	{
		mid = low + (high-low)/2;
		if (array[mid] == data)
			return mid;
		if (data < array[mid])
			high = mid - 1;
		else
			low = mid + 1;
	}
	return -1;
}

template class BinarySearch<int>;
template class BinarySearch<char>;
template class BinarySearch<double>;
template class BinarySearch<std::string>;