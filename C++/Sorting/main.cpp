#include <iostream>
#include "bubbleSort.h"
using namespace std;

void displayArray(int[] array, int len)
{
	for (int i = 0; i < len; i++)
		cout << array[i] << " ";
	cout << endl;
	return;
}

int main()
{
	// check integer array
	int intArray1[] = {5, 4, 3, 2, 1};
	int *intArray1Asc = BubbleSort<int>::Sort(intArray1, 5, true);
	displayArray(intArray1Asc);

	// check for double array

	// check for character array

	// check for string array

	return 0;
}