#include <iostream>
#include "bubbleSort.h"
using namespace std;

void displayArray(int array[], int len)
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

	// ascending order sort
	int *intArray1Asc = BubbleSort<int>::Sort(intArray1, 5, true);
	displayArray(intArray1Asc, 5);

	// descending order sort
	int *intArray1Dsc = BubbleSort<int>::Sort(intArray1Asc, 5, false);
	displayArray(intArray1Dsc, 5);

	// random array
	int intArray2[] = {5, 1, 2, 4, 3, 0};
	int *intArray2Asc = BubbleSort<int>::Sort(intArray2, 6, true);
	displayArray(intArray2Asc, 6);

	// check for double array

	// check for character array

	// check for string array

	return 0;
}