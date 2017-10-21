#include <iostream>
#include <vector>
#include "insertionSort.hpp"
static unsigned long long int insert_compare=0;
void InsertionSort( std::vector<int> &a) {
    int i, j, key, numLength = a.size();
    for (j = 1; j < numLength; j++)
    {
        key = a[j];
        
        for (i = j - 1; ++insert_compare && (i >= 0) && (a[i] < key); i--)    //++merge_compare will always be true
        {
            
            a[i + 1] = a[i];
        }
        a[i + 1] = key;
    }
}
unsigned long long int getInsertCompare() {
    unsigned long long int i=insert_compare;
    insert_compare = 0;
    return i;
}