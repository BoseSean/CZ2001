#include <vector>
#include <iostream>
#include <random>
#include <algorithm>
#include <iterator>
#include <functional>
#include <iomanip>
#include "main.cpp"
#include "insertionSort.hpp"
// static std::chrono::high_resolution_clock::time_point t1,t2;

// #define GET_T1() t1 = std::chrono::high_resolution_clock::now()
// #define GET_T2() t2 = std::chrono::high_resolution_clock::now()
// std::vector<int> generate_ascending_vector(int size){
//     std::vector<int> vec(size);
//     int n=1;
//     generate(vec.begin(), vec.end(), [&n] { return n++;});
//     std::cout<<&vec<<std::endl;
//     return vec;
// }
int main(int argc, char const *argv[])
{
    std::vector<int> a =  generate_ascending_vector(10);
    InsertionSort(a);
    std::vector<int> b =  generate_descending_vector(10);
    for (int i:a){
        std::cout<<i<<" ";
    }
    std::cout<<std::endl;
    for(int i:b){
        std::cout<<i<<" ";
    }
    return 0;
}
// using namespace std;
// using namespace std::chrono;

// void function1();


// int main()
// {
//     // GET_T1();
//     high_resolution_clock::time_point t1 = high_resolution_clock::now();
//     function1();
//     // GET_T2();
//     high_resolution_clock::time_point t2 = high_resolution_clock::now();

//     auto duration = duration_cast<microseconds>( t2 - t1 ).count();
//     int a = duration;
//     cout << a;
//     return 0;
// }
// void function1()
// {
//     long long number = 0;

//     for( long long i = 0; i != 1000; ++i )
//     {
//        number += 5;
//     }
// }
// int main() {
//     std::cout<<std::setw(10)<<50270502;
//     std::cout<<std::setw(15)<<50270502;
//     std::cout<<std::setw(15)<<50270502;
//     std::cout<<std::setw(15)<<50270502;
//     std::cout<<std::setw(15)<<50270502<<std::endl;
//     std::cout<<std::setw(10)<<50270502;
//     std::cout<<std::setw(15)<<50270502;
//     std::cout<<std::setw(15)<<50270502;
//     std::cout<<std::setw(15)<<50270502;
//     std::cout<<std::setw(15)<<50270502<<std::endl;
//     return 0;
// }