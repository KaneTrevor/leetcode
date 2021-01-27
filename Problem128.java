/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

Follow up: Could you implement the O(n) solution?



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 104
-109 <= nums[i] <= 109
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class Problem128 {

    public int longestConsecutive(int[] numbers) {
        if (numbers.length <= 1) {
            return numbers.length;
        }

        int len = 1, maxLen = 0;
        HashSet<Integer> map = new HashSet<>();
        for (int a : numbers) {
            map.add(a);
        }

        List<Integer> list = new ArrayList<>(map);
        Collections.sort(list);

        for (int j = 0; j < list.size() - 1; j++) {
            if (list.get(j + 1) - list.get(j) < 2) {
                len++;
            } else {
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 1;
            }
        }

        if (len > maxLen) {
            maxLen = len;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{9,1,4,7,3,-1,0,5,8,-1,6};
        int ret = new Problem128().longestConsecutive(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

