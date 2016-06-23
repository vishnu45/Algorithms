OBJS = testDriver.o linearSearch.o binarySearch.o
CC = g++
DEBUG = -g
CFLAGS = -Wall -c $(DEBUG)
LFLAGS = -Wall $(DEBUG)

testDriver: $(OBJS)
	$(CC) $(LFLAGS) $(OBJS) -o testDriver

# For testing from a test driver program main.cpp
# main: main.o linearSearch.o binarySearch.o
# 	$(CC) $(LFLAGS) main.o linearSearch.o binarySearch.o -o main
# main.o: linearSearch.h binarySearch.h main.cpp
# 	$(CC) $(CFLAGS) main.cpp

testDriver.o: \
	linearSearch.h linearSearch.cpp \
 	binarySearch.h binarySearch.cpp \
 	testDriver.cpp
	$(CC) $(CFLAGS) testDriver.cpp

linearSearch.o: \
	linearSearch.h linearSearch.cpp
	$(CC) $(CFLAGS) linearSearch.cpp

clean:
	del $(OBJS) testDriver.exe