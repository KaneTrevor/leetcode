/*
485. Max Consecutive Ones

Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
*/

class Problem153 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0, i = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i++] > 0) {
                count++;
            }
            if (count > max)
                max = count;
            count = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        //int[] nums = new int[]{3,3,7,7,10,11,11};
        int[] nums = new int[]{0,1,1,1,1,1,0,1,0,1,1,1,0,1,1};
        //int[] nums = new int[]{1,2,2,3,3,4,4,8,8};
        int ret = new Problem153().findMaxConsecutiveOnes(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

