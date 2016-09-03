/** To print out elements in a matrix in a spiral order */
#include <iostream>
#include <vector>
using namespace std;

// Function to print matrix elements in spiral order
vector<int> spiralOrder(const vector< vector<int> > &A) {
	vector<int> result;
	int T = 0, B = A.size()-1, L = 0, R = A[0].size()-1;
	int dir = 0;

	while (T <= B && L <= R) {
		// traversing left to right -> dir=0
		if (dir == 0) {
			for (int i = L; i <= R; i++) {
				result.push_back(A[T][i]);
			}	
			T++;
			dir = 1;
		}

		// traversing top to bottom -> dir=1
		else if (dir == 1) {
			for (int i = T; i <= B; i++) {
				result.push_back(A[i][R]);
			}
			R--;
			dir = 2;
		}

		// traversing right to left -> dir=2
		else if (dir == 2) {
			for (int i = R; i >= L; i--) {
				result.push_back(A[B][i]);
			}
			B--;
			dir = 3;
		}

		// traversing bottom to top -> dir=3
		else if (dir == 3) {
			for (int i = B; i >= T; i--) {
				result.push_back(A[i][L]);
			}
			L++;
			dir = 0;
		}
	}
	return result;
}

// --------------------	MAIN --------------------------
int main() {
	vector<vector<int>> A =
	{
		{ 1, 2, 3, 4 },
		{ 5, 6, 7, 8 },
		{ 9, 10, 11, 12 }
		};
	vector<int> B = spiralOrder(A);
	int BSize = B.size();
	for (int i = 0; i < BSize; i++) {
		cout << B[i] << " ";
	}
	return 0;
}