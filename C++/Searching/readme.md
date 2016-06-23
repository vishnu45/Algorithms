# Search algorithms implemented in C++

### Algorithms implemented:
 * [Linear Search](https://en.wikipedia.org/wiki/Linear_search)
 * [Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm)

### Implementation:
 * [linearSearch.h](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/linearSearch.h)
 * [linearSearch.cpp](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/linearSearch.cpp)
 * [binarySearch.h](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/binarySearch.h)
 * [binarySearch.cpp](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/binarySearch.cpp)  
  
### Testing
A program for uint testing the search algorithms are written using [Catch](https://github.com/philsquared/Catch) test framework.
* [testDriver.cpp](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/testDriver.cpp)

### Results
A [make file](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/makefile) has been created to automate the build process.
```bash
> make clean
> make
> testDriver && testDriver -s > TestResults.txt
```
A [TestResults.txt](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/TestResults.txt) file is generated which stores the results of the test cases.

Sample bash prompt output of testing:

![testResult](https://github.com/vishnu45/Algorithms/blob/master/C%2B%2B/Searching/results.png)