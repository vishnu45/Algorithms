#include <iostream>
#include <stdlib.h>
#include "bubbleSort.h"
#include "selectionSort.h"
#include "insertionSort.h"
#include "mergeSort.h"
#include "heapSort.h"
#include "quickSort.h"
using namespace std;

// macro to find array length
#define COUNT(arr) (int)( (sizeof(arr)) / (sizeof(arr[0])));

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

// Function convering all test cases for merge sort
void TestMergeSort() {

	cout << "Testing merge sort ... " << endl << endl;
	int array4_1[] = {8, 5, 1, 4, 21, 21, 9, 0, 13};

	// ascending order sort
	cout << "Original array: ";
	displayArray<int>(array4_1, 9);
	int *array4_1_asc = MergeSort<int>::Sort(array4_1, 9, true);
	cout << "Sorted array: ";
	displayArray<int>(array4_1_asc, 9);
	cout << endl;

	// descending order sort
	cout << "Original array: ";
	displayArray<int>(array4_1, 9);
	int *array4_1_dsc = MergeSort<int>::Sort(array4_1, 9, false);
	cout << "Sorted array: ";
	displayArray<int>(array4_1_dsc, 9);
	cout << endl;

	char array4_2[] = {'q', 'w', 'e', 'r', 't', 'y'};
	// ascending order character sort
	cout << "Original array: ";
	displayArray<char>(array4_2, 6);
	char *array4_2_asc = MergeSort<char>::Sort(array4_2, 6, true);
	cout << "Sorted array: ";
	displayArray<char>(array4_2_asc, 6);
	cout << endl;

	return;
}

void TestHeapSort() {

	cout << "Testing heap sort ... " << endl << endl;
	int array5_1[] = {8, 5, 1, 4, 21, 21, 9, 0, 13};

	// ascending order sort
	cout << "Original array: ";
	displayArray<int>(array5_1, 9);
	int *array5_1_asc = HeapSort<int>::Sort(array5_1, 9, true);
	cout << "Sorted array: ";
	displayArray<int>(array5_1_asc, 9);
	cout << endl;

	// descending order sort
	cout << "Original array: ";
	displayArray<int>(array5_1, 9);
	int *array5_1_dsc = HeapSort<int>::Sort(array5_1, 9, false);
	cout << "Sorted array: ";
	displayArray<int>(array5_1_dsc, 9);
	cout << endl;

	string array5_2[] = {"My", "name", "is", "Vishnu", "Vidyan", "."};
	// ascending order string sort
	cout << "Original array: ";
	displayArray<string>(array5_2, 6);
	string *array5_2_asc = HeapSort<string>::Sort(array5_2, 6, true);
	cout << "Sorted array: ";
	displayArray<string>(array5_2_asc, 6);
	cout << endl;

	return;
}

void TestQuickSort() {

	cout << "Testing quick sort ... " << endl << endl;
	int array_1[] = {8, 5, 1, 4, 21, 21, 9, 0, 13};

	cout << "Original array: ";	
	displayArray<int>(array_1,9);
	cout  << "Sorted array: ";
	QuickSort::Sort(array_1, 9, true);
	displayArray<int>(array_1, 9);
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

		case 5:
			// testing heap sort
			TestHeapSort();
			break;

		case 6:
			// testing quick sort
			TestQuickSort();
			break;

		default:
			// testing all sorting algorithms
			TestBubbleSort();
			TestSelectionSort();
			TestInsertionSort();
			TestMergeSort();
			TestHeapSort();
			break;
	}

	return 0;
}