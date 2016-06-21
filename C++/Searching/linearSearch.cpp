/* *******************************************************************
 Linear search implementation  
******************************************************************** */

#include "linearSearch.h"
#include <string>

//--------------------------------------------------------------------
// Function: To find item in array using linear serach
//--------------------------------------------------------------------	
template <typename T>
int LinearSearch<T>::Search(T array[], int length, T data)
{			
	for (int i = 0; i < length; i++)
	{		
		if (array[i] == data)
			return i;
	}
	return -1;
}

template class LinearSearch<int>;
template class LinearSearch<double>;
template class LinearSearch<char>;
template class LinearSearch<std::string>;