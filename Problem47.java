/*
47. Permutations II

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem47 {
    Set<List<Integer>> matrix = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        permutation(nums, 0, nums.length - 1);
        return new ArrayList<>(matrix);
    }

    public void permutation(int[] nums, int begin, int end) {
        if (begin == end) { //只剩最后一个字符时为出口
            List<Integer> one = new ArrayList<>();
            for (int oneNum : nums) {
//                System.out.print(oneNum + " ");
                one.add(oneNum);
            }
//            System.out.println();
            matrix.add(one);
        } else {
            for (int i = begin; i <= end; ++i) { //每个字符依次固定到数组或子数组的第一个
                if (canSwap(nums, begin, i)) { //去重
                    swap(nums, begin, i); //交换
                    permutation(nums, begin + 1, end); //递归求子数组的全排列
                    swap(nums, begin, i); //还原
                }
            }
        }
    }

    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    public boolean canSwap(int[] nums, int begin, int end) {
        for (int i = begin; i < end; ++i) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();
//        int[] nums = new int[]{10,1,2,7,6,1,5};
        int[] nums = new int[] {1,2,3};

//        List<List<Integer>> ret = new Solution47().permute(nums);

        List<List<Integer>> ret = new Problem47().permute(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
