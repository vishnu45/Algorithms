#include <iostream>
#include <stdlib.h>
#include "bubbleSort.h"
#include "selectionSort.h"
#include "insertionSort.h"
#include "mergeSort.h"
using namespace std;

// Function to display elements of an array
template<typename T>
void displayArray(T array[], int len) {
	for (int i = 0; i < len; i++)
		cout << array[i] << " ";
	cout << endl;
	return;
}

// Function covering all test cases for bubble sort
void TestBubbleSort() {

	cout << "Testing bubble sort ... " << endl << endl;

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
	cout << endl;

	// improved bubble sort
	int arrayI[] = {5, 1, 2, 3, 4};
	cout << "Original array: ";
	displayArray<int>(arrayI, 5);
	int *arrayIAsc = BubbleSort<int>::SortImp(arrayI, 5, true);
	cout << "Sorted array: ";
	displayArray<int>(arrayIAsc, 5);
	cout << endl;
	return;
}

// Function covering all test cases for selection sort
void TestSelectionSort() {

	cout << "Testing selection sort ... " << endl << endl;
	int intArray1[] = {5, 4, 3, 2, 1};

	// ascending order sort
	cout << "Original array: ";
	displayArray<int>(intArray1, 5);
	int *intArray1Asc = SelectionSort<int>::Sort(intArray1, 5, true);
	cout << "Sorted array: ";
	displayArray<int>(intArray1Asc, 5);
	cout << endl;

	// descending order sort
	cout << "Original array: ";
	displayArray<int>(intArray1Asc, 5);
	int *intArray1Dsc = SelectionSort<int>::Sort(intArray1Asc, 5, false);
	cout << "Sorted array: ";
	displayArray<int>(intArray1Dsc, 5);
	cout << endl;

	// random array
	int intArray2[] = {5, 1, 2, 4, 3, 0};
	cout << "Original array: ";
	displayArray<int>(intArray2, 6);
	int *intArray2Asc = SelectionSort<int>::Sort(intArray2, 6, true);
	cout << "Sorted array: ";
	displayArray<int>(intArray2Asc, 6);
	cout << endl;

	return;
}

// Function convering all test cases for insertion sort
void TestInsertionSort() {

	cout << "Testing insertion sort ... " << endl << endl;
	int intArray1[] = {5, 4, 3, 2, 1};

	// ascending order sort
	cout << "Original array: ";
	displayArray<int>(intArray1, 5);
	int *intArray1Asc = InsertionSort<int>::Sort(intArray1, 5, true);
	cout << "Sorted array: ";
	displayArray<int>(intArray1Asc, 5);
	cout << endl;

	// descending order sort
	cout << "Original array: ";
	displayArray<int>(intArray1Asc, 5);
	int *intArray1Dsc = SelectionSort<int>::Sort(intArray1Asc, 5, false);
	cout << "Sorted array: ";
	displayArray<int>(intArray1Dsc, 5);
	cout << endl;

	// random array
	int intArray2[] = {5, 1, 2, 4, 3, 0};
	cout << "Original array: ";
	displayArray<int>(intArray2, 6);
	int *intArray2Asc = SelectionSort<int>::Sort(intArray2, 6, true);
	cout << "Sorted array: ";
	displayArray<int>(intArray2Asc, 6);
	cout << endl;

	return;
}

void TestMergeSort() {

	cout << "Testing merge sort ... " << endl << endl;
	int array4[] = {8, 7, 6, 15, 4, 3, 2, 1, 10};

	// ascending order sort
	cout << "Original array: ";
	displayArray<int>(array4, 9);
	int *array4_asc = MergeSort<int>::Sort(array4, 9);
	cout << "Sorted array: ";
	displayArray<int>(array4_asc, 9);
	cout << endl;

	return;
}

int main(int argc, char* argv[])
{
	switch (atoi(argv[1]))
	{
		case 1:
			// testing bubble sort
			TestBubbleSort();
			break;

		case 2:
			// testing selection sort
			TestSelectionSort();
			break;

		case 3:
			// testing insertion sort
			TestInsertionSort();
			break;

		case 4:
			// testing merge sort
			TestMergeSort();
			break;

		default:
			// testing all sorting algorithms
			TestBubbleSort();
			TestSelectionSort();
			TestInsertionSort();
			TestMergeSort();
			break;
	}

	return 0;
}