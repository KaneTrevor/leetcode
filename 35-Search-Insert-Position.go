/*
35. Search Insert Position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/

package main

import (
	"fmt"
)

func searchInsert(nums []int, target int) int {
	length := len(nums)
	if length == 0 {
		return 0
	}
	if target < nums[0] {
		return 0
	}

	for i := 0; i < length; i++ {
		if nums[i] == target {
			return i
		} else if i+1 < length && nums[i] < target && target < nums[i+1] {
			return i + 1
		}
	}
	return length
}

func main() {
	var array = []int{1, 3, 5, 6}
	lenArray := searchInsert(array, 0)

	fmt.Println("len", lenArray)
}
