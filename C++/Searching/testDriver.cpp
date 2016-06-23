#define CATCH_CONFIG_MAIN
#include "./../catch.hpp"

#include "linearSearch.h"
#include "binarySearch.h"
using namespace std;

// -------------------------------------------------------------------------------------------------
//			Linear search - test cases
// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in an integer array using linear search", "[Linear Search][integer]"){

	GIVEN ("An integer array [1, 2, 3, 4, 5] ")
	{
		int intArray[] = {1, 2, 3, 4, 5};
		
		WHEN ("we search for an integer item [3] present within the array")
		{
			int data = 3;
			THEN ("the index of the integer item (2) must be returned back correctly")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) == 2);
			}
		}

		WHEN ("we search for an integer item [5] present within the array")
		{
			int data = 5;
			THEN ("the index value retured back must not be -1")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) != -1);
			}
		}

		WHEN ("we search for an interger item [6] not present within the array")
		{
			int data = 6;
			THEN("the index value returned must be -1")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) == -1);
			}
		}
	}
}

// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in a character array using linear search", "[Linear Search][character]"){

	GIVEN ("A character array [a, b, c, d, e] ")
	{
		char charArray[] = {'a', 'b', 'c', 'd', 'e'};
		WHEN ("we search for a character item 'a' present within the array")
		{
			char data = 'a';
			THEN ("the index of the character item (0) must be returned back correctly")
			{
				REQUIRE (LinearSearch<char>::Search(charArray, 5, data) == 0);
			}
		}

		WHEN ("we search for a character item 'b' present within the array")
		{
			char data = 'b';
			THEN ("the index value retured back must not be -1")
			{
				REQUIRE (LinearSearch<char>::Search(charArray, 5, data) != -1);
			}
		}

		WHEN ("we search for a character item 'z' not present within the array")
		{
			char data = 'z';
			THEN("the index value returned must be -1")
			{
				REQUIRE (LinearSearch<char>::Search(charArray, 5, data) == -1);
			}
		}	
	}
}

// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in a double array using linear search", "[Linear Search][double]"){

	GIVEN ("A double array [0.1, 0.2, 0.3, 0.4, 0.5] ")
	{
		double doubleArray[] = {0.1, 0.2, 0.3, 0.4, 0.5};
		WHEN ("we search for a double item 0.4 present within the array")
		{
			double data = 0.4;
			THEN ("the index of the double item must be returned back correctly")
			{
				REQUIRE (LinearSearch<double>::Search(doubleArray, 5, data) == 3);
			}
		}

		WHEN ("we search for a double item 'b' present within the array")
		{
			double data = 0.1;
			THEN ("the index value retured back must not be -1")
			{
				REQUIRE (LinearSearch<double>::Search(doubleArray, 5, data) != -1);
			}
		}

		WHEN ("we search for a double item 0.6 not present within the array")
		{
			double data = 0.6;
			THEN("the index value returned must be -1")
			{
				REQUIRE (LinearSearch<double>::Search(doubleArray, 5, data) == -1);
			}
		}	
	}
}

// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in a string array using linear search", "[Linear Search][string]"){

	GIVEN ("A string array [\"My\", \"name\", \"is\", \"Vishnu\", \"Vidyan\"] ")
	{
		string stringArray[] = {"My", "name", "is", "Vishnu", "Vidyan"};
		WHEN ("we search for a string item \"Vishnu\" present within the array")
		{
			string data = "Vishnu";
			THEN ("the index of the string item must be returned back correctly")
			{
				REQUIRE (LinearSearch<string>::Search(stringArray, 5, data) == 3);
			}
		}

		WHEN ("we search for a string item \"My\" present within the array")
		{
			string data = "My";
			THEN ("the index value retured back must not be -1")
			{
				REQUIRE (LinearSearch<string>::Search(stringArray, 5, data) != -1);
			}
		}

		WHEN ("we search for a string item \"Hello\" not present within the array")
		{
			string data = "Hello";
			THEN("the index value returned must be -1")
			{
				REQUIRE (LinearSearch<string>::Search(stringArray, 5, data) == -1);
			}
		}	
	}
}

// -------------------------------------------------------------------------------------------------
//			Binary search test cases
// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in an integer array using binary search", "[Binary Search][integer]"){

	GIVEN ("An integer array [1, 2, 3, 4, 5] ")
	{
		int intArray[] = {1, 2, 3, 4, 5};
		
		WHEN ("we search for an integer item [1] present within the array")
		{
			int data = 1;
			THEN ("the index of the integer item (0) must be returned back correctly")
			{
				REQUIRE (BinarySearch<int>::Search(intArray, 5, data) == 0);
			}
		}

		WHEN ("we search for an integer item [4] present within the array")
		{
			int data = 4;
			THEN ("the index value retured back must not be -1")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) != -1);
			}
		}

		WHEN ("we search for an integer item [1] present at the beginning of the array")
		{
			int data = 1;
			THEN ("the index of the integer item (0) must be returned back correctly")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) == 0);
			}
		}

		WHEN ("we search for an integer item [5] present at the end of the array")
		{
			int data = 5;
			THEN ("the index of the integer item (4) must be returned back correctly")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) == 4);
			}
		}

		WHEN ("we search for an interger item [-100] not present within the array")
		{
			int data = -100;
			THEN("the index value returned must be -1")
			{
				REQUIRE (LinearSearch<int>::Search(intArray, 5, data) == -1);
			}
		}
	}
}

// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in a character array using binary search", "[Binary Search][character]"){

	GIVEN ("A character array ['a', 'b', 'c', 'd', 'e'] ")
	{
		char charArray[] = {'a', 'b', 'c', 'd', 'e'};
		
		WHEN ("we search for a character item [b] present within the array")
		{
			char data = 'b';
			THEN ("the index of the character item (1) must be returned back correctly")
			{
				REQUIRE (BinarySearch<char>::Search(charArray, 5, data) == 1);
			}
		}		

		WHEN ("we search for a character item [Z] not present within the array")
		{
			char data = 'Z';
			THEN("the index value returned must be -1")
			{
				REQUIRE (BinarySearch<char>::Search(charArray, 5, data) == -1);
			}
		}
	}
}

// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in a double array using binary search", "[Binary Search][double]"){

	GIVEN ("A double array [-0.1, 0.05, 0.1, 1.2, 21.1] ")
	{
		double doubleArray[] = {-0.1, 0.05, 0.1, 1.2, 21.1};
		
		WHEN ("we search for a double item [-0.1] present within the array")
		{
			double data = -0.1;
			THEN ("the index of the character item (0) must be returned back correctly")
			{
				REQUIRE (BinarySearch<double>::Search(doubleArray, 5, data) == 0);
			}
		}		

		WHEN ("we search for a character item [99.99] not present within the array")
		{
			double data = 99.99;
			THEN("the index value returned must be -1")
			{
				REQUIRE (BinarySearch<double>::Search(doubleArray, 5, data) == -1);
			}
		}
	}
}

// -------------------------------------------------------------------------------------------------
SCENARIO ("Search for an item in a string array using binary search", "[Binary Search][string]"){

	GIVEN ("A string array [\"My\", \"name\", \"is\", \"Vishnu\", \".\"] ")
	{
		string stringArray[] = {"a", "ab", "abc", "abcd", "abcde"};
		
		WHEN ("we search for a string item [\"abcd\"] present within the array")
		{
			string data = "abcd";
			THEN ("the index of the string item (3) must be returned back correctly")
			{
				REQUIRE (BinarySearch<string>::Search(stringArray, 5, data) == 3);
			}
		}		

		WHEN ("we search for a string item [\"No\"] not present within the array")
		{
			string data = "No";
			THEN("the index value returned must be -1")
			{
				REQUIRE (BinarySearch<string>::Search(stringArray, 5, data) == -1);
			}
		}
	}
}