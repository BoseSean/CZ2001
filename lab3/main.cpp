#include <vector>
#include <iostream>
#include <random>
#include <algorithm>
#include <iterator>
#include <functional>
#include <chrono>
#include <iomanip>
#include "mergeSort.hpp"
#include "insertionSort.hpp"

#define ITERATION 10 

#define GET_T1() t1 = std::chrono::high_resolution_clock::now()
#define GET_T2() t2 = std::chrono::high_resolution_clock::now()
static std::chrono::high_resolution_clock::time_point t1,t2;
static unsigned long long int merge_time=0;
static unsigned long long int insert_time=0;
static unsigned long long int merge_compare=0;
static unsigned long long int insert_compare=0;

void printValues(int size, unsigned long long int merge_time, unsigned long long int insert_time, unsigned long long int merge_compare, unsigned long long int insert_compare );
static std::vector<int> generate_random_vector(int size, int max);
static std::vector<int> generate_ascending_vector(int size);
static std::vector<int> generate_descending_vector(int size);

int main() {
    std::cout<<std::setw(25)<<"merge"<<std::setw(15)<<"insert"<<std::setw(15)<<"merge"<<std::setw(15)<<"insert"<<std::endl;
    std::cout<<std::setw(10)<<"Data size"<<std::setw(15)<<"Time use(ms)"<<std::setw(30)<<"Comparison"<<std::endl;
    
    // 1000 to 10000 increase by 1000
    for(int size=1000; size<10000; size+=1000){
        merge_time = 0;
        insert_time = 0;
        for(int iter=0; iter<ITERATION; iter++){
            std::vector<int> a = generate_descending_vector(size);
            std::vector<int> b = a; //make a copy of vector a
            GET_T1();
            MergeSort(a);
            GET_T2();
            merge_time+=std::chrono::duration_cast<std::chrono::microseconds>( t2 - t1 ).count();
            merge_compare += getMergeCompare();

            GET_T1();
            InsertionSort(b);
            GET_T2();
            insert_time+=std::chrono::duration_cast<std::chrono::microseconds>( t2 - t1 ).count();
            insert_compare += getInsertCompare();
        }
        
        printValues(size, merge_time/ITERATION, insert_time/ITERATION, merge_compare/ITERATION, insert_compare/ITERATION);
    }
    // 10000 to 1,000,000 increase by 10,000
    for(int size=10000; size<220000; size+=20000){
        merge_time = 0;
        insert_time = 0;
        for(int iter=0; iter<ITERATION; iter++){
            std::vector<int> a = generate_descending_vector(size);
            std::vector<int> b = a; //make a copy of vector a
            GET_T1();
            MergeSort(a);
            GET_T2();
            merge_time+=std::chrono::duration_cast<std::chrono::microseconds>( t2 - t1 ).count();
            merge_compare += getMergeCompare();

            GET_T1();
            InsertionSort(b);
            GET_T2();
            insert_time+=std::chrono::duration_cast<std::chrono::microseconds>( t2 - t1 ).count();
            insert_compare += getInsertCompare();
        }
        
        printValues(size, merge_time/ITERATION, insert_time/ITERATION, merge_compare/ITERATION, insert_compare/ITERATION);
        

    }

    
}
void printValues(int size, unsigned long long int merge_time, unsigned long long int insert_time, unsigned long long int merge_compare, unsigned long long int insert_compare ){
    std::cout<<std::setw(10)<<size;
    std::cout<<std::setw(15)<<merge_time;
    std::cout<<std::setw(15)<<insert_time;
    std::cout<<std::setw(20)<<merge_compare;
    std::cout<<std::setw(20)<<insert_compare<<std::endl;
}
static std::vector<int> generate_random_vector(int size, int max){
 
    // First create an instance of an engine.
    std::random_device rnd_device;
    // Specify the engine and distribution.
    std::mt19937 mersenne_engine(rnd_device());
    std::uniform_int_distribution<int> dist(1, max);

    auto gen = std::bind(dist, mersenne_engine);
    // static std::vector<int> vec(size);
    std::vector<int> vec(size);
    
    std::generate(begin(vec), end(vec), gen);

    return vec;
}

static std::vector<int> generate_ascending_vector(int size){
    std::vector<int> vec(size);
    int n=1;
    generate(vec.begin(), vec.end(), [&n] { return n++;});
    return vec;
}
static std::vector<int> generate_descending_vector(int size){
    std::vector<int> vec(size);
    int n=size;
    generate(vec.begin(), vec.end(), [&n] { return n--;});
    return vec;
}