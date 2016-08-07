// To find the maximum pair wise product for a 

#include <iostream>
#include <vector>
using namespace std;

// Max product using naive approach
int MaxProd (vector<int> &vec)
{
	int product = vec[0] * vec[1];
	int count = vec.size();	

	for (int i = 0; i < count; i++)
	{
		for (int j = i + 1; j < count; j++)
		{
			if ( vec[i] * vec[j] > product)
				product = vec[i] * vec[j];
		}
	}
	return product;
}

// improved function to find pair wise max product
int ImpMaxProd (vector<int> &vec)
{
	// big and small are two of the largest numbers in the group
	int big, small;
	if (vec[0] > vec[1])
	{
		big = vec[0];
		small = vec[1];
	}
	else
	{
		big = vec[1];
		small = vec[0];
	}

	int product;
	int count = vec.size();

	// scan through the rest of the elements in the group
	for (int i=2 ; i<count; i++)
	{
		if (vec[i] > big)
		{
			if (vec[i] > small)
			{
				small = big;
				big = vec[i]; 
			}
			else
				small = vec[i];
		}
		else if (vec[i] > small)
			small = vec[i];
	}
	product = big * small;

	return product;
}

int main()
{
	int count;	
	cin >> count;

	vector<int> vec(count);
	for (int i = 0; i < count; i++)
		cin >> vec[i];

	cout << "Product = " << ImpMaxProd(vec);

	return 0;
}