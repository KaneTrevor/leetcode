/*
167. Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.


Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]

*/

import java.util.*;

class Problem167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1, count = 0, a, b, c;

        while (count < numbers.length){
            a = numbers[i];
            b = numbers[j];
            c = a + b;
            count++;

            if (c < target) {
                i++;
            } else if (c > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{-5,-1,1,2,3,7,11,15};
        int target = 5;
        int[] ret = new Problem167().twoSum(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Output:" + Arrays.toString(ret));
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

