/*
3. Longest Substring Without Repeating Characters

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

class Solution {
public:
int lengthOfLongestSubstring(string s) {

}
};
*/
#include <iostream>
#include <math.h>
#include <vector>
#include <set>
#include <algorithm>

class Solution {
public:
	inline int lengthOfLongestSubstring(std::string a) {
		int i = 0;
		int j = 0;
		int max_len = 0;
		std::set<char> s;

		for (j = 0; i<a.size(); j++) {
			for (i = j; i<a.size(); i++) {
				if (!s.count(a[i])) {
					s.insert(a[i]);
				}
				else {
					if (s.size() > max_len) {
						max_len = s.size();
					}
					s.clear();
					break;
				}
			}
		}
		return std::max(max_len, (int)s.size());
	}
};


int main(int argc, char *argv[])
{
	std::string p = "akbsbbgdsbtbb";
	Solution s;
	int len = s.lengthOfLongestSubstring(p);
	std::cout << "len: " << len << std::endl;
	system("pause");
	return(0);
}
