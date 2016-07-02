#include "common.h"
#include <string>

//--------------------------------------------------------------------
// Function: To swap the value of two items between each other
//--------------------------------------------------------------------
template<typename T>
void swap(T *a, T *b)
{
	T temp;
	temp = *a;
	*a = *b;
	*b = temp;
	return;
}

template void swap<int>(int *a, int *b);
template void swap<char>(char *a, char *b);
template void swap<double>(double *a, double *b);
template void swap<std::string>(std::string *a, std::string *b);