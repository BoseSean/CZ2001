CC=g++
CPPFLAGS=-std=c++11
OBJS=main.o mergeSort.o insertionSort.o

all: $(OBJS)
	$(CC) $(CPPFLAGS) -o main $(OBJS)
test: test.cpp $(OBJS)
	$(CC) $(CPPFLAGS) -o test test.cpp
%.o: %.c 
	$(CC) $(CPPFLAGS) -c $<

clean: 
	rm main test $(OBJS)

# g++ -std=c++11 -o test test.cpp insertionSort.o mergeSort.o