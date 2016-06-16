#define CATCH_CONFIG_MAIN
#include "./../catch.hpp"

#include "linearSearch.h"

SCENARIO ("Search for an item in an array using linear search", "[Linear Search]"){
	
	GIVEN ("An integer array")
	{
		int intArray[] = {1, 2, 3, 4, 5};
		WHEN ("we search for an integer item present within the array")
		{
			int data = 5;
			THEN ("the index of the integer item must be returned back correctly")
			{
				REQUIRE(LinearSearch<int>::Search(intArray, 5, data) != -1);
			}
		}
	}

	GIVEN ("A character array")
	{
		char charArray[] = {'a', 'b', 'c', 'd', 'e'};
		WHEN ("we search for a character item present within the array")
		{
			char data = 'a';
			THEN ("the index of the character item must be returned back correctly")
			{
				REQUIRE(LinearSearch<char>::Search(charArray, 5, data) != -1);
			}
		}	
	}
	
}