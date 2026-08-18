/*
    Question :
    Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
    You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
    Return the answer with the smaller index first.

    Level: Easy

    Example 1:
        Input: nums = [3,4,5,6], target = 7
        Output: [0,1]

    Example 2:
        Input: nums = [4,5,6], target = 10
        Output: [0,2]

    Constraints:
        2 <= nums.length <= 1000
        -10,000,000 <= nums[i] <= 10,000,000
        -10,000,000 <= target <= 10,000,000
        Only one valid answer exists.

    Intuition:
        1. Brute force can be we pick one element from nums and loop through nums and add each element and check if
            we sum up to the target. Time Complexity O(n²), Space Complexity O(1)
        2. Another optimal intuition can be using map and keeping a counter of all the characters in both the strings
            and checking at last if both the maps are equal or not. Time Complexity O(n), Space Complexity O(s+t)
*/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

bool isAnagram(string s, string t) {
    if (s.length() != t.length()) {
        return false;
    }
    unordered_map<char, int>mp1;
    unordered_map<char, int>mp2;
    for(auto &it: s){
        mp1[it]++;
    }
    for(auto &it:t){
        mp2[it]++;
    }
    return mp1==mp2;
}

int main() {
    string s1 = "jar", t1 = "jam";
    cout<<isAnagram(s1, t1)<<endl;
    string s2 = "racecar", t2 = "carrace";
    cout<<isAnagram(s2, t2)<<endl;
};
