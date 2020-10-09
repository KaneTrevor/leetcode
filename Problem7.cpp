/*
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

 Example 1:

Input: 123
Output: 321

 Example 2:

Input: -123
Output: -321

 Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within
the 32-bit signed integer range:
[−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0
when the reversed integer overflows.
*/
#include <iostream>
#include <math.h>
#include <vector>
#include <ctime>

class Solution {
public:
	int reverse(int x) {
		std::string x_string = std::to_string(x);
		int x_len = x_string.size();
		if (x < 0)
			x_len--;

		int j = 0;
		int bit_restore = 0;
		int p = 0;
		long ret = 0;
		long tmp_val = x;
		for (int i = x_len - 1; i >= 0; i--, j++) {
			p = pow(10, i);
			bit_restore = tmp_val / p;
			tmp_val = tmp_val - bit_restore * p;
			ret += bit_restore * pow(10, j);

			if (ret < -2147483648 || ret > 2147483647) {
				return 0;
			}
		}
		return ret;
	}
};

int main(int argc, char *argv[])
{
	clock_t begin, end;
	begin = clock();
	Solution a;
	int b = 13579;
	std::cout << "ret:" << a.reverse(b) << std::endl;

	end = clock();
	std::cout << "Run time: " << (double)(end - begin) / CLOCKS_PER_SEC << "S" << std::endl;
	return(0);
}
