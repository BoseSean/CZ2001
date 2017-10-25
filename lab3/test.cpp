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

static std::vector<int> generate_random_vector(int size);
static std::vector<int> generate_ascending_vector(int size);
static std::vector<int> generate_descending_vector(int size);
static void print(std::vector<int>& a);
int main(int argc, char const *argv[])
{
    std::vector<int> a = generate_random_vector(15);
    std::vector<int> b = a;
    std::cout<<"Insertion sort:"<<std::endl;
    std::cout<<"a: ";
    print(a);
    InsertionSort(a);
    std::cout<<"a: ";
    print(a);
std::cout<<"Merge sort:"<<std::endl;
    std::cout<<"b: ";
    print(b);
    MergeSort(b);
    std::cout<<"b: ";
    print(b);
    return 0;
}



static std::vector<int> generate_random_vector(int size){
    // First create an instance of an engine.
    std::random_device rnd_device;
    // Specify the engine and distribution.
    std::mt19937 mersenne_engine(rnd_device());
    std::uniform_int_distribution<int> dist(1, size);

    auto gen = std::bind(dist, mersenne_engine);
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
static void print(std::vector<int>& a){
    for(int i:a){
        std::cout<<i<<" ";
    }
    std::cout<<std::endl;
}