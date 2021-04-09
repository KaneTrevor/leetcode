/*
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
search target in nums. If target exists, then return its index. Otherwise, return -1.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:

    1 <= nums.length <= 10^4
    -9999 <= nums[i], target <= 9999
    All the integers in nums are unique.
    nums is sorted in an ascending order.
*/

class Problem704 {
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

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 7;
        int ret = new Problem704().biSearch(nums, target);
        System.out.println("Output:" + ret);
    }
}
