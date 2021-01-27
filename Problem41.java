/*
41. First Missing Positive

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3

Example 2:

Input: [3,4,-1,1]
Output: 2

Example 3:

Input: [7,8,9,11,12]
Output: 1

Follow up:

Your algorithm should run in O(n) time and uses constant extra space.

 */

import javafx.util.Pair;

import java.util.*;

class Problem41 {
    private Pair<Boolean, Integer> biSearchIndexZero(int[] arr) {
        int middle;
        int low = 0;
        int high = arr.length - 1;

        if (arr[high] <= 0) {
            return new Pair<>(false, -1);
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > 0) {
                high = middle - 1;
            } else if (arr[middle] <= 0) {
                low = middle + 1;
            } else {
                return new Pair<>(true, middle + 1);
            }
        }

        return new Pair<>(false, low);
    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length < 1) {
            return 1;
        }
        Arrays.sort(nums);
        Pair<Boolean, Integer> pos = biSearchIndexZero(nums);
        int index = pos.getValue();
        if (!pos.getKey() && index < 0) {
            return 1;
        }

        int[] sortedArr = Arrays.copyOfRange(nums, pos.getValue(), nums.length);
        if (sortedArr[0] > 1) {
            return 1;
        }

        int add = 2;
        Set<Integer> showSet = new HashSet<>();
        showSet.add(sortedArr[0]);
        for (int i = 1; i < sortedArr.length; i++) {
            if (!showSet.contains(sortedArr[i])) {
                if (sortedArr[i] != add) {
                    return add;
                } else {
                    add++;
                    showSet.add(sortedArr[i]);
                }
            }
        }
        return add;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{1, 2, 3, 3, 5, 1, -2, -1, 2, 0};

        int ret = new Problem41().firstMissingPositive(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}