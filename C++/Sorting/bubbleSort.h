/* *******************************************************************
 Bubble sort implementation  
******************************************************************** */

#ifndef BUBBLESORT_H
#define BUBBLESORT_H

template<typename T>
class BubbleSort
{
public:
	T static *Sort(T array[], int len, bool type);
	T static *SortImp(T array[], int len, bool type);
};

#endif