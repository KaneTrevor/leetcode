/*
283. Move Zeroes

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

import java.util.Arrays;

class Problem283 {
    @Deprecated
    public void exchange(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    @Deprecated
    public void moveZeroes2(int[] nums) {
        int j;

        for (int i = 0; i < nums.length - 1; i++) {
             if (nums[i] == 0) {
                 j = i + 1;
                 while (j < nums.length && nums[j] == 0)
                     j++;

                 if (j < nums.length)
                    exchange(nums, i, j);
             }
        }
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{0,1,0,3,12};
        //int[] nums = new int[]{5,0,1,2,0,0,3,1,0,7,2};
        //int[] nums = new int[]{1,2,2,3,3,4,4,8,8};
        new Problem283().moveZeroes(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + Arrays.toString(nums));
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

