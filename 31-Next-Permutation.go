/*
31. Next Permutation

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

package main

import "fmt"

func nextPermutation(nums []int) {
	size := len(nums)
	// find the first one which left smaller than the right side
	firstSmallIndex := -1
	for i := size - 1; i > 0; i-- {
		if nums[i-1] < nums[i] {
			firstSmallIndex = i - 1
			break
		}
	}

	// find the first one which right grater than the firstSmallIndex one
	if firstSmallIndex > -1 {
		for i := size - 1; i > firstSmallIndex; i-- {
			if nums[i] > nums[firstSmallIndex] {
				nums[firstSmallIndex], nums[i] = nums[i], nums[firstSmallIndex]
				break
			}
		}
	}

	//rearrange the nums on the right side of the firstSmallIndex
	count := 0
	for i := firstSmallIndex + 1; i < firstSmallIndex+1+(size-firstSmallIndex)/2; i++ {
		if nums[i] > nums[size-1-count] {
			nums[i], nums[size-1-count] = nums[size-1-count], nums[i]
		} else {
			break
		}
		count++
	}
}

func main() {
	var array = []int{1, 1, 5}
	nextPermutation(array)
	fmt.Println("ret", array)
}
