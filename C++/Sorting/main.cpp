#include <iostream>
#include "bubbleSort.h"
using namespace std;

template<typename T>
void displayArray(T array[], int len)
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
	cout << "Original array: ";
	displayArray<int>(intArray1, 5);
	int *intArray1Asc = BubbleSort<int>::Sort(intArray1, 5, true);
	cout << "Sorted array: ";
	displayArray<int>(intArray1Asc, 5);
	cout << endl;

	// descending order sort
	cout << "Original array: ";
	displayArray<int>(intArray1Asc, 5);
	int *intArray1Dsc = BubbleSort<int>::Sort(intArray1Asc, 5, false);
	cout << "Sorted array: ";
	displayArray<int>(intArray1Dsc, 5);
	cout << endl;

	// random array
	int intArray2[] = {5, 1, 2, 4, 3, 0};
	cout << "Original array: ";
	displayArray<int>(intArray2, 6);
	int *intArray2Asc = BubbleSort<int>::Sort(intArray2, 6, true);
	cout << "Sorted array: ";
	displayArray<int>(intArray2Asc, 6);
	cout << endl;

	// check for double array
	double doubleArray2[] = {0.5, 19.9, -2.0, .41, -0.03, 99.9};
	cout << "Original array: ";
	displayArray<double>(doubleArray2, 6);
	double *doubleArray2Asc = BubbleSort<double>::Sort(doubleArray2, 6, true);
	cout << "Sorted array: ";
	displayArray<double>(doubleArray2Asc, 6);
	cout << endl;

	// check for character array
	char charArray[] = {'b', 'a', 'z', 'b', 'g', 'r', 'e'};
	cout << "Original array: ";
	displayArray<char>(charArray, 7);
	char *charArrayDesc = BubbleSort<char>::Sort(charArray, 7, false);
	cout << "Sorted array: ";
	displayArray<char>(charArrayDesc, 7);
	cout << endl;

	// check for string array
	string strArray[] = {"My", "name", "is", "Vishnu", "Vidyan"};
	cout << "Original array: ";
	displayArray<string>(strArray, 5);
	string *strArrayAsc = BubbleSort<string>::Sort(strArray, 5, true);
	cout << "Sorted array: ";
	displayArray<string>(strArrayAsc, 5);

	return 0;
}