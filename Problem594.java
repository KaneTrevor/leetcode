/*
594. Longest Harmonious Sub-sequence

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious sub-sequence among all its possible sub-sequences.

A sub-sequence of array is a sequence that can be derived from the array by deleting some or no elements without changing
the order of the remaining elements.



Example 1:

Input: nums = [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious sub-sequence is [3,2,2,2,3].
Example 2:

Input: nums = [1,2,3,4]
Output: 2
Example 3:

Input: nums = [1,1,1,1]
Output: 0


Constraints:

1 <= nums.length <= 2 * 104
-109 <= nums[i] <= 109
*/

import java.util.*;

class Problem594 {

    public int findLHS(int[] numbers) {
        int maxLHS = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : numbers) {
            map.merge(a, 1, (prev, one) -> prev + one);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int j = 0; j < list.size() - 1; j++) {
            if (list.get(j + 1) - list.get(j) < 2) {
                int max = map.get(list.get(j + 1)) + map.get(list.get(j));
                if (max > maxLHS) {
                    maxLHS = max;
                }
            }
        }

        return maxLHS;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{1,3,2,2,5,2,4,7};
        int ret = new Problem594().findLHS(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

