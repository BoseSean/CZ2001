#include <iostream>
#include <vector>
#include "insertionSort.hpp"
static unsigned long long int insert_compare=0;
void InsertionSort( std::vector<int> &a) {
    int i, j, key, numLength = a.size();
    for (j = 1; j < numLength; j++)   // Start with 1 (not 0)
    {
        key = a[j];
        for (i = j - 1; (i >= 0) && (a[i] < key); i--)  // Smaller values move up
        {
            insert_compare++;
            a[i + 1] = a[i];
        }
        a[i + 1] = key;  //Put key into its proper location
    }
}
unsigned long long int getInsertCompare() {
    unsigned long long int i=insert_compare;
    insert_compare = 0;
    return i;
}