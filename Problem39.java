/*
39. Combination Sum

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

Constraints:

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    Each element of candidate is unique.
    1 <= target <= 500
 */

import java.util.*;
import javafx.util.Pair;

class Problem39 {
    int target = 0;
    Set<List<Integer>> matrix = new HashSet<>();

    private Pair<Boolean, Integer> biSearchIndex(int[] arr, int key) {
        int middle;
        int low = 0;
        int high = arr.length - 1;

        if (key < arr[low]) {
            return new Pair<>(false, -1);
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return new Pair<>(true, middle);
            }
        }

        return new Pair<>(false, low);
    }

    private void combination(int[] nums, int len, int move, int[] subs, int subIndex) {
        if (move == 0) { //出口
            List<Integer> one = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < subIndex; ++i) {
                //System.out.print(subs[i]);
                one.add(subs[i]);
                sum += subs[i];
            }
            //System.out.println();

            if (sum == target)
                matrix.add(one);
        } else {
            for (int i = len; i >= move; --i) { // from rear to the front
                subs[move - 1] = nums[i - 1]; // pick one

                int sum = 0;
                for (int j = 0; j < subIndex; ++j) {
                    sum += subs[j];
                }
                if (sum <= target) {
                    combination(nums, i - 1, move - 1, subs, subIndex); // from i-1 ones pick m-1 ones to recurse
                }
            }
        }
    }

    void combination(int[] nums) {
        int[] subs = new int[nums.length]; // the arrays which stores sub-combination
        //all combinations: n pick 1 add n pick 2 .... add n pick n
        for (int i = 0; i < nums.length; ++i) {
            final int move = i + 1;
            combination(nums, nums.length, move, subs, move);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        Pair<Boolean, Integer> pos = biSearchIndex(candidates, target);
        int index = pos.getValue();
        if (!pos.getKey() && index < 0) {
            return new ArrayList<List<Integer>>() {};
        }

        int[] nums = Arrays.copyOfRange(candidates, 0, pos.getValue());
        if (index < candidates.length && candidates[pos.getValue()] == target) {
            matrix.add(Collections.singletonList(target));
        }

        List<Integer> arrays = new ArrayList<>();
        for (int num : nums) {
            int v = target / num;
            for (int j = 0; j < v; j++) {
                arrays.add(num);
            }
        }

        combination(arrays.stream().mapToInt(Integer::valueOf).toArray());
        return new ArrayList<>(matrix);
    }

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();
        int[] nums = new int[]{2,3,4,5,6};
        int target = 12;
        List<List<Integer>> ret = new Problem39().combinationSum(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}