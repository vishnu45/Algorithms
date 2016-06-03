// Printing diagonal elements of a matrix

#include <iostream>
using namespace std;

int main()
{
	int ROW = 3, COL = 4;
	int a, b;
	int array[ROW][COL] = {	{ 1, 2, 3, 4},
							{ 5, 6, 7, 8},
							{ 9, 10, 11, 12}};

	for (int i = 0; i < ROW; i++)
	{
		for (int j= 0; j < COL; j++)
			cout << array[i][j] << "\t";
		cout << endl;
	}
	cout << endl;

	for (int i = 0; i < ROW + COL - 1; i++)
	{
		a = i < COL ? 0 : i - COL + 1;
		b = i < ROW ? 0 : i - ROW + 1;
		for (int j = i - b; j >= a; j--)
			cout << array[j][i-j] << "\t";
		cout << endl;
	}

	return 0;
}