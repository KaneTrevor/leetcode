/*
10. Regular Expression Matching

Given an input string (s) and a pattern (p), implement regular expression matching with support
for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.

Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".

Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedent element, 'a'. Therefore, by repeating 'a' once,
it becomes "aa".

Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".

Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".

Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
*/


#include <iostream>
#include <math.h>
#include <string>
#include <vector>
#include <algorithm>

class Solution {
public:
	bool check(char a, char b) {
		if (a == b || b == '.')
			return true;
		return false;
	}

	bool isMatch(std::string s, std::string p) {
		int size_s = s.size();
		int size_p = p.size();
		int map_match[size_s + 1][size_p + 1];
        int i = 0;
        int j = 0;

		for (i = 0; i <= size_s; i++) {
			for (j = 0; j <= size_p; j++) {
				map_match[i][j] = 0;
				if (i == 0 && j == 0) {
					map_match[i][j] = 1;
					continue;
				}
				if (j == 0) {
					continue;
				}
				if (i == 0) {
					if (p[j - 1] == '*') {
						map_match[i][j] = map_match[i][j - 2];
					}
					continue;
				}

				if (p[j - 1] == '*') {
					map_match[i][j] |= map_match[i][j - 2];
					if (check(s[i - 1], p[j - 2])) {
						map_match[i][j] |= map_match[i - 1][j];
					}
				} else {
					map_match[i][j] |= check(s[i - 1], p[j - 1]) && map_match[i - 1][j - 1];
				}
			}
		}
		return map_match[size_s][size_p];
	}
};

int main(int argc, char *argv[])
{
	Solution s;
	std::string str = "abc";
	std::string patter = "ab";
	bool ret = s.isMatch(str, patter);
	std::cout << "ret: " << ret << std::endl;

	system("pause");
	return(0);
}
