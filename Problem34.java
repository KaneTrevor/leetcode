//import com.google.common.collect.Lists;


class Problem34 {
    private int biSearch(int[] arr, int key) {
        int middle;
        int low = 0;
        int high = arr.length - 1;

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

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) {
            return new int[]{-1, -1};
        }
        int minNum = nums[0];
        int maxNum = nums[len - 1];

        if (len < 2 && minNum == target) {
            return new int[]{0, 0};
        }

        if (target < minNum && target > maxNum) {
            return new int[] {-1, -1};
        }

        int index = biSearch(nums, target);
        if (index < 0) {
            return new int[] {-1, -1};
        }

        int startPos = 0;
        int endPos = len - 1;
        for (int i = index; i < len; i++) {
            if (nums[i] != target) {
                endPos = i - 1;
                break;
            }
        }

        for (int j = index; j >= 0; j--) {
            if (nums[j] != target) {
                startPos = j + 1;
                break;
            }
        }
        return new int[] {startPos, endPos};
    }
}


class Problem34 {
    public static void main(String[] args) {
        int[] nums = new int[]{-5,5,6,6,6,7,7,7,9};
        int target = 7;
        int[] ret = new Problem34().searchRange(nums, target);

        for (int index: ret) {
            System.out.println("Output:" + index);
        }
        //if (index > 0) {
        //    System.out.println(" a: " + nums[index]);
        //}
    }
}
