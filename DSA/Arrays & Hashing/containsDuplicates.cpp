/*
    Question :
    Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

    Level: Easy

    Example 1:
        Input: nums = [1, 2, 3, 3]
        Output: true

    Example 2:
        Input: nums = [1, 2, 3, 4]
        Output: false

    Constraints:
        0 <= nums.length <= 10^5
        -10^9 <= nums[i] <= 10^9

    Intuition:
        1. Brute force can be we pick each element from starting and in another loop we check if the same element
            exists somewhere else in the array and return true. Time Complexity O(n²), Space Complexity : O(1)
        2. Ask the interviewer if the array is sorted or not, if yes then the first intuition can be two pointer approach
            with space complexity as O(1) and time complexity as O(n).
        3. If array is not sorted then intuition can be set/hashmap, iterating through the array and if values exists in
            set/hashmap then return false else add in set and continue. Space Complexity : O(n), Time Complexity O(n).
*/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool hasDuplicate(vector<int>& nums) {
    unordered_set<int>st;
    for(auto &it: nums){
        if(st.find(it) != st.end()){
            return true;
        }else{
            st.insert(it);
        }
    }
    return false;
}

int main() {
    vector<int> arr1 = {1, 2, 3, 4};
    vector<int> arr2 = {1, 2, 2, 3};
    cout<<hasDuplicate(arr1)<<endl;
    cout<<hasDuplicate(arr2)<<endl;
};

