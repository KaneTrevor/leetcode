/*
5. Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum
length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

#include<iostream>
#include<math.h>
#include<string>
#include<vector>
#include <algorithm>

class Solution {
public:
	std::string longestPalindrome(std::string s) {
		unsigned int len = s.size();
		if (len < 2)
			return s;
		std::string max_string = "";
		unsigned int i = 0, j = 0, x = 0, y = 0, pos_start = 0, pos_end = 0;

		for (i = 0; i < len; i++) {
			for (j = len - 1; j > 0; j--) {
				pos_start = x = i;
				pos_end = y = j;

				if (i == j - 1 && s[i] == s[j]) {
					if (pos_end - pos_start + 1 > max_string.size())
						max_string = s.substr(pos_start, pos_end - pos_start + 1);
				}

				while (s[x] == s[y] && y - 1 > x) {
					x++;
					y--;
				}

				if (x == y ||
					x == y - 1 && s[x] == s[y]) {
					if (pos_end - pos_start + 1 > max_string.size())
						max_string = s.substr(pos_start, pos_end - pos_start + 1);

					if (max_string.size() + 1 >= len)
						return max_string;
				}
			}
		}
		return max_string;
	}
};


int main(int argc, char *argv[])
{
	std::string t = "eabcbky";
	Solution s;
	std::string ret = s.longestPalindrome(t);
	std::cout << "ret: " << ret << std::endl;
	system("pause");
	return(0);
}
