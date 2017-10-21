#include <vector>
#include <iostream>
#include "mergeSort.hpp"
static int merge_compare=0;

void Merge(std::vector<int>& a, int start, int end, int mid) {
    int i, j, k, temp[end - start + 1];
    i = start;
    k = 0;
    j = mid + 1;
    while (i <= mid && j <= end) {
        if (a[i] < a[j]) {
            merge_compare++;
            temp[k] = a[i];
            k++; i++;
        } else {
            temp[k] = a[j];
            k++; j++;
        }
    }
    while (i <= mid) {
        temp[k] = a[i];
        k++;
        i++;
    }

    while (j <= end) {
        temp[k] = a[j];
        k++; j++;
    }

    for (i = start; i <= end; i++) {
        a[i] = temp[i - start];
    }
}
void rMergeSort(std::vector<int>& a, int start, int end) {
    int mid;
    if (start < end)
    {
        mid = (start + end) / 2;
        rMergeSort(a, start, mid);
        rMergeSort(a, mid + 1, end);
        Merge(a, start, end, mid);
    }
}
void MergeSort(std::vector<int>& a){
    rMergeSort(a,0, a.size()-1);
}
int getMergeCompare(){
    int i = merge_compare;
    merge_compare = 0;
    return i;
}