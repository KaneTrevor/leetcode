#include <iostream>
#include<math.h>
#include<string>
#include<vector>
#include <algorithm>

using namespace std;

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

Coud you solve it without converting the integer to a string?

*/

class Solution {
public:
	bool isPalindrome(int x) {
		if (x < 0)
			return false;

		int y = x;
		double ret = 0;
		int k = 0;
		do {
			k = y % 10;
			y /= 10;
			ret = ret * 10 + k;
		} while (y != 0);

		cout << "ret: " << ret << endl;
		if (ret == x)
			return true;
		else
			return false;
	}
};

int main(int argc, char *argv[])
{
	Solution s;
	bool ret = s.isPalindrome(501105);

	cout << "ret: " << ret << endl;

	system("pause");
	return(0);
}
