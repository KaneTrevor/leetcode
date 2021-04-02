
//    private void count(int i, String str, int[] num, int n) {
//        if (n == 0) {
//            System.out.println(str);
//            return;
//        }
//        if (i == num.length) {
//            return;
//        }
//
//        count(i + 1, str + num[i] + ",", num, n - 1);
//        count(i + 1, str, num, n);
//    }
//
//    private static void count1(int i, String str, int[] num) {
//        if (i == num.length) {
//            System.out.println(str);
//            return;
//        }
//        count1(i + 1, str, num);
//        count1(i + 1, str + num[i] + ",", num);
//    }
//
//    private void count3(int i, List<Integer> tmp, int[] num) {
//        if (i == num.length) {
//            System.out.println(tmp);
//
//            int sum = 0;
//            for (int a: tmp) {
//                sum += a;
//            }
//
//            if (sum == target) {
//                matrix.add(tmp);
//            }
//            return;
//        }
//        count3(i + 1, tmp, num);
//        tmp.add(num[i]);
//        count3(i + 1, tmp, num);
//    }
//
//    public void combination(int [] array, int n) {
//        combination(array, new int[n], 0, n);
//    }
//
//    public void combination(int [] array, int[] indexes, int start, int n) {
//        if (n == 1) {
//            String prefix = generatePrefix(array, indexes);
//            for (int i = start; i < array.length; i++) {
//                System.out.print(prefix);
//                System.out.print(array[i]);
//                System.out.println(']');
//            }
//
//            //for (Integer i : array) {
//            //    System.out.print(i);
//            //    System.out.print(" ");
//            //}
//            //System.out.println();
//        } else {
//            for (int i = start; i <= array.length - n; i++) {
//                indexes[indexes.length - n] = i;
//                combination(array, indexes, i + 1, n - 1);
//            }
//        }
//    }
//
//    private String generatePrefix(int [] array, int[] indexes) {
//        StringBuilder prefixBuilder = new StringBuilder("[");
//        for (int i = 0; i < indexes.length - 1; i++) {
//            prefixBuilder.append(array[indexes[i]]).append(", ");
//        }
//        return prefixBuilder.toString();
//    }
//
//    private void combinations(List<Integer> selected, List<Integer> data, int n) {
//        if (n == 0) {
//            // output all selected elements
//            for (Integer i : selected) {
//                System.out.print(i);
//                System.out.print(" ");
//            }
//            System.out.println();
//            return;
//        }
//
//        if (data.isEmpty()) {
//            // output empty list
//            return;
//        }
//
//        // select element 0
//        selected.add(data.get(0));
//        combinations(selected, data.subList(1, data.size()), n - 1);
//
//        // un-select element 0
//        selected.remove(selected.size() - 1);
//        combinations(selected, data.subList(1, data.size()), n);
//    }


/*
46. Permutations
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

import javafx.util.Pair;

import java.util.*;

class Problem46 {
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

//        List<List<Integer>> ret = new Solution46().permute(nums);

        List<List<Integer>> ret = new Problem46().permute(nums);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
