/*
    Question :
    Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
    An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

    Level: Easy

    Example 1:
        Input: s = "racecar", t = "carrace"
        Output: true

    Example 2:
        Input: s = "jar", t = "jam"
        Output: false

    Constraints:
        1 <= s.length, t.length <= 5 * 10^4
        s and t consist of lowercase English letters.

    Intuition:
        1. Brute force can be we pick each element from s and look for the same in t once found remove both the characters
           from both strings and at last if the strings are empty both are anagrams else not. Time Complexity O(n²),
           Space Complexity O(1)
        2. Optimal solution can be using set of pair / hashmap (to keep number and index both), we put all the elements
           in a set/hashmap and start a loop and check if the target-nums[i] exists in the map and return the first such
           pair. Time Complexity O(n+n), Space Complexity O(n)
*/

#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> mp;
    for(int i=0; i<nums.size(); i++){
        mp[nums[i]] = i;
    }
    for(int i=0; i<nums.size(); i++){
        int findNum = target-nums[i];
        if(mp.find(findNum) != mp.end()){
            return {mp[findNum], i};
        }
    }
    return {};
}

/*
    We can also do it in one pass like
    for (int i = 0; i < nums.size(); i++) {
        int complement = target - nums[i];
        if (mp.find(complement) != mp.end()) {
            return {mp[complement], i};
        }
        mp[nums[i]] = i;
    }
*/

int main() {
    vector<int>nums = {3,4,5,6};
    int target = 10;
    vector<int> ans = twoSum(nums, target);
    for(auto &it: ans){
        cout<<it<< " ";
    }
};