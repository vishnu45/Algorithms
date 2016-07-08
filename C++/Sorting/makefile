OBJS = main.o \
 	bubbleSort.o \
 	selectionSort.o \
 	insertionSort.o \
 	mergeSort.o \
 	heapSort.o \
 	common.o
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
	bubbleSort.cpp bubbleSort.h \
	common.cpp
	$(CC) $(CFLAGS) bubbleSort.cpp

selectionSort.o: \
	selectionSort.cpp selectionSort.h \
	common.cpp
	$(CC) $(CFLAGS) selectionSort.cpp

insertionSort.o: \
	insertionSort.cpp insertionSort.h \
	common.cpp
	$(CC) $(CFLAGS) insertionSort.cpp

mergeSort.o: \
	mergeSort.cpp mergeSort.h \
	common.cpp
	$(CC) $(CFLAGS) mergeSort.cpp

heapSort.o: \
	heapSort.cpp heapSort.h \
	common.cpp
	$(CC) $(CFLAGS) heapSort.cpp

common.o: \
	common.cpp common.h
	$(CC) $(CFLAGS) common.cpp

clean:
	del $(OBJS) main.exe