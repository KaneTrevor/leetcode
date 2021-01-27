/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one
element which appears exactly once. Find this single element that appears only once.

Follow up: Your solution should run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10


Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Problem540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1, m;
        while (l < h) {
            m = l + (h - l ) / 2;

            if (0 < m && m < nums.length - 1 && nums[m - 1] != nums[m] && nums[m] != nums[m + 1]) {
                return nums[m];
            } else if (m % 2 == 0 && m < nums.length - 1) {
                if (nums[m] == nums[m + 1]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            } else if (m % 2 != 0 && m > 0) {
                if (nums[m] == nums[m - 1]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        //int[] nums = new int[]{3,3,7,7,10,11,11};
        int[] nums = new int[]{1,1,2,3,3,4,4,8,8};
        //int[] nums = new int[]{1,2,2,3,3,4,4,8,8};
        int ret = new Problem540().singleNonDuplicate(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

