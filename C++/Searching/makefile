OBJS = testDriver.o linearSearch.o
CC = g++
DEBUG = -g
CFLAGS = -Wall -c $(DEBUG)
LFLAGS = -Wall $(DEBUG)

testDriver: $(OBJS)
	$(CC) $(LFLAGS) $(OBJS) -o testDriver

testDriver.o: linearSearch.h linearSearch.cpp testDriver.cpp
	$(CC) $(CFLAGS) testDriver.cpp

linearSearch.o: linearSearch.h linearSearch.cpp
	$(CC) $(CFLAGS) linearSearch.cpp

clean:
	del $(OBJS) testDriver.exe