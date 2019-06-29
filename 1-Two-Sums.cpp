/*
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

#include <iostream>
#include<math.h>
#include<vector>

class Solution {
public:
	std::vector<int> twoSum(std::vector<int>& nums, int target) {
		for (std::vector<int>::size_type ix = 0; ix != nums.size(); ++ix) {
			for (std::vector<int>::size_type j = ix + 1; j != nums.size(); ++j)	{
				if (nums[ix] + nums[j] == target) {
					std::vector<int> ilist = { static_cast<int>(ix), static_cast<int>(j) };
					return ilist;
				}
			}
		}

		std::vector<int> list(0, 0);
		return list;
	}
};

int main(int argc, char *argv[])
{
	std::vector<int> nums = { 3, 2, 4, 15 };
	Solution a;
	std::vector<int> ret = a.twoSum(nums, 6);
	std::vector<int>::iterator it = ret.begin();

	for (; it != ret.end(); it++) {
		std::cout << *it;
	}
	std::cout << std::endl;
	system("pause");
	return(0);
}
