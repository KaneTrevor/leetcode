import java.util.Arrays;
import java.util.List;
//import com.google.common.collect.Lists;


class Problem33 {
    private int biSearch(int[] arr, int key, int low, int high) {
        //int low = 0;
        //int high = arr.length - 1;
        int middle;

        if (key < arr[low] || key > arr[high]) {
            return -1;
        }

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                high = middle - 1;
            } else if (arr[middle] < key) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    private int maxNumSearch(int[] arr) {
        int low = 0;
        int middle;
        int high = arr.length - 1;
        int head = arr[0];
        int tail = arr[arr.length - 1];

        while (low <= high) {
            middle = (low + high) / 2;
            if (arr[middle] >= head) {
                low = middle + 1;
            } else if (arr[middle] < tail) {
                if (middle > 0 && arr[middle] < arr[middle - 1]) {
                    return middle;
                }
                high = middle - 1;
            } else {
                return middle;
            }
        }

        return 0;
    }

    int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 2) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }

        int tailNum = nums[len - 1];
        int headNum = nums[0];
        if (target < headNum && target > tailNum) {
            return -1;
        }

        if (target == headNum) {
            return 0;
        } else if (target == tailNum) {
            return len - 1;
        }

        //for (int i = 0; i < nums.length - 1; i++) {
        //    //that target found before pivotIndex shows
        //    if (nums[i] == target) {
        //        return i;
        //    }
        //
        //    if (nums[i + 1] < nums[i]) {
        //        pivotIndex = i + 1;
        //        pivotNum = nums[i + 1];
        //        break;
        //    }
        //}

        int pivotIndex;
        int minNum;
        int maxNum;

        if (tailNum > headNum) {
            pivotIndex = len;
            minNum = headNum;
            maxNum = tailNum;
        } else {
            pivotIndex = maxNumSearch(nums);
            minNum = nums[pivotIndex];
            maxNum = pivotIndex > 0 ? nums[pivotIndex - 1] : nums[pivotIndex];
        }

        System.out.println("maxNum:" + maxNum + " minNum:" + minNum);
        if (target < minNum || target > maxNum) {
            return -1;
        }

        if (target > nums[0]) {
            return biSearch(nums, target, 0, pivotIndex - 1);
        } else {
            return biSearch(nums, target, pivotIndex, len - 1);
        }
    }
}


class Problem33 {
    public static void main(String[] args) {
        //List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[] nums = new int[]{4, 5, -1, 1, 2, 3};
        int target = 2;
        int index = new Problem33().search(nums, target);


        System.out.println("Output:" + index);
        if (index > 0) {
            System.out.println(" a: " + nums[index]);
        }
    }
}
