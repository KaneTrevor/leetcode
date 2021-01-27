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
import java.util.HashMap;
import java.util.LinkedList;



class Problem141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        return true;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        ListNode head = null;

        boolean ret = new Problem141().hasCycle(head);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
