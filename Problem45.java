/*
45. Jump Game II

Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.


Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
 the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2



Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] <= 105

*/

class Problem45 {
    int step = 0;
    int len = 0;

    private void find(int[] nums, int pos, int count) {
        int arrive = nums[pos];
        if (arrive < 1) {
            return;
        } else if (pos + arrive >= len - 1) {
            count++;
            if (count < step || step == 0) {
                step = count;
            }
            return;
        }

        int maxPos = 0;
        int maxIndex = 0;
        for (int i = arrive; i > 0; i--) {
            if (nums[pos + i] + i > maxPos) {
                maxPos = nums[pos + i] + i;
                maxIndex = i;
            }
        }

        find(nums, maxIndex + pos, count + 1);
    }

    public int jump(int[] nums) {
        len = nums.length;
        if (len <= 1) {
            return 0;
        }

        find(nums, 0, 0);
        return step;
    }

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();
        //int[] nums = new int[]{3,4,0,3,3,3,2,0,1,1}; //4
        int[] nums = new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,
                3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}; // 13
        int ret = new Problem45().jump(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
