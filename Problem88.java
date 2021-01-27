/*
680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

import java.util.Arrays;
import java.util.LinkedList;

class Problem88 {
    private LinkedList<Integer> list = new LinkedList<>();

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, a, b,  len = m + n;
        boolean k = false;

        while (i < m) {
            a = nums1[i];
            b = j < n ? nums2[j] : a;

            if (list.size() > 0 && a > Math.min(list.getLast(), b)) {
                if (list.getLast() > b) {
                    list.addFirst(a);
                    nums1[i] = b;
                    j++;
                } else {
                    list.addFirst(a);
                    nums1[i] = list.getLast();
                    list.removeLast();
                }
            } else if (a > b) {
                list.addFirst(a);
                nums1[i] = b;
                j++;
            }

            i++;
        }

        while (i < len) {
            if (list.size() > 0 && (j >= n || list.getLast() <= nums2[j])) {
                nums1[i++] = list.getLast();
                list.removeLast();
            } else {
                nums1[i++] = nums2[j++];
            }
        }
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        //int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        //int[] nums2 = new int[]{2, 5, 6};

        //int[] nums1 = new int[]{1, 3, 5, 0, 0, 0};
        //int[] nums2 = new int[]{2, 4, 6};

        //int[] nums1 = new int[]{-1, 0, 0, 1,0, 0, 0};
        //int[] nums2 = new int[]{-2, 0, 2};

        //int[] nums1 = new int[]{4,5,6,0, 0, 0};
        //int[] nums2 = new int[]{1,2,3};

        //int[] nums1 = new int[]{1,2,4,5,6,0};
        //int[] nums2 = new int[]{3};

        int[] nums1 = new int[]{-1,0,1,1,0,0,0,0,0};
        int[] nums2 = new int[]{-1,0,2,2,3};


        new Problem88().merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        end = System.currentTimeMillis();
        System.out.println("Output:" + Arrays.toString(nums1));
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
