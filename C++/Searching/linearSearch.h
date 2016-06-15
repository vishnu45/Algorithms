/* *******************************************************************
 Linear search implementation  
******************************************************************** */

#include <iostream>
using namespace std;
#ifndef LINEARSEARCH_H
#define LINEARSEARCH_H

template <typename T>
class LinearSearch
{
public:
//--------------------------------------------------------------------
// Function: To find item in array using linear serach
//--------------------------------------------------------------------	
	int static search(T array[], int length, T data)
	{	
		cout << sizeof(array) << endl;
		for (int i = 0; i < length; i++)
		{		
			if (array[i] == data)
				return i;
		}
		return -1;
	}
};

#endif