
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


import java.util.*;
import javafx.util.Pair;

class Problem40 {
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

    private void combination2(int[] nums, int len, int move, int[] subs, int subIndex) {
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
            for (int i = len; i >= move; --i) { // 从后往前依次选定一个
                subs[move - 1] = nums[i - 1]; // 选定一个后

                int sum = 0;
                for (int j = 0; j < subIndex; ++j) {
                    sum += subs[j];
                }
                if (sum <= target) {
                    combination2(nums, i - 1, move - 1, subs, subIndex); // 从前i-1个里面选取m-1个进行递归
                }
            }
        }
    }

    void combination2(int[] nums) {
        int[] subs = new int[nums.length]; //存储子组合数据的数组
        //全组合问题就是所有元素(记为n)中选1个元素的组合, 加上选2个元素的组合...加上选n个元素的组合的和
        for (int i = 0; i < nums.length; ++i) {
            final int move = i + 1;
            combination2(nums, nums.length, move, subs, move);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        Pair<Boolean, Integer> pos = biSearchIndex(candidates, target);
        int index = pos.getValue();
        if (!pos.getKey() && index < 0) {
            return new ArrayList<List<Integer>>() {{}};
        }

        int[] nums = Arrays.copyOfRange(candidates, 0, pos.getValue());
        if (index < candidates.length && candidates[pos.getValue()] == target) {
            matrix.add(Collections.singletonList(target));
        }
        combination2(nums);

        return new ArrayList<>(matrix);
    }

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();
//        int[] nums = new int[]{10,1,2,7,6,1,5};
        int[] nums = new int[] {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target = 27;
        List<List<Integer>> ret = new Problem40().combinationSum2(nums, target);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}

