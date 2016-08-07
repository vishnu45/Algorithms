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

int main()
{
	int count;	
	cin >> count;

	vector<int> vec(count);
	for (int i = 0; i < count; i++)
		cin >> vec[i];

	cout << "Product = " << MaxProd(vec);

	return 0;
}