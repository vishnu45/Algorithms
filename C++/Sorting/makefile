OBJS = main.o bubbleSort.o selectionSort.o
CC = g++
DEBUG = -g
CFLAGS = -Wall -c $(DEBUG)
LFLAGS = -Wall $(DEBUG)

main: $(OBJS)
	$(CC) $(LFLAGS) $(OBJS) -o main

main.o: \
	bubbleSort.cpp bubbleSort.h \
	main.cpp
	$(CC) $(CFLAGS) main.cpp

bubbleSort.o: \
	bubbleSort.cpp bubbleSort.h
	$(CC) $(CFLAGS) bubbleSort.cpp

selectionSort.o: \
	selectionSort.cpp selectionSort.h
	$(CC) $(CFLAGS) selectionSort.cpp

clean:
	del $(OBJS) main.exe