/*
6. ZigZag Conversion

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
*/
#include <iostream>
#include<math.h>
#include<string>
#include<vector>
#include <algorithm>

class Solution {
public:
	std::string convert(std::string s, int n) {
		int len = s.size();
		int m = std::max(ceil(len / 2 + 1), ceil(len / n)); //max line
		int u = 0;
		int i = 0, j = 0; // iterator
		int x = 0, y = 0; // present space indicate a[x,y]

		char **a = new char *[m];
		for (i = 0; i < m; ++i) {
			a[i] = new char[n];
			memset(a[i], '0', n*sizeof(char));
		}

		while (u < len) {
			for (y = 0; y < n && u < len; ++y, u++){
				a[x][y] = s[u];
			}
			if (u >= len) {
				break;
			}
			y--;	// y has added to n, now become n -1
			x++;	//next row

			if (n > 2) {
				y--;
				for (; x < m && u < len && y > 0; ++x, --y, u++){
					a[x][y] = s[u];
				}
			}
		}

		std::string ret(len, '0');
		u = 0;
		for (j = 0; j < n; ++j) {
			for (i = 0; i < m; ++i) {
				if (a[i][j] != '0') {
					ret[u++] = a[i][j];
					if (u >= len) {
						break;
					}
				}
			}
			if (u >= len) {
				break;
			}
		}

		for (i = 0; i < m; ++i) {
			delete[] a[i];
			a[i] = nullptr;
		}
		delete[] a;
		a = nullptr;

		return ret;
	}
};

int main(int argc, char *argv[])
{
	std::string str = "PAYPALISHIRING";
	Solution s;
	std::string ret = s.convert(str, 3);
	std::cout << "ret: " << ret << std::endl;
	system("pause");
	return(0);
}
