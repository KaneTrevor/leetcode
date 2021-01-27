/*
83. Remove Duplicates from Sorted List

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/


class Problem83 {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, a;
        while (p.next != null) {
            a = p.next;
            while (a != null && a.val == p.val) {
                a = a.next;
            }
            p.next = a;

            if (p.next != null)
                p = p.next;
        }

        return head;
    }


    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem83 pr = new Problem83();
        ListNode a01 = pr.new ListNode(5, null);
        ListNode a0 = pr.new ListNode(5, a01);
        ListNode a1 = pr.new ListNode(2, a0);
        ListNode a2 = pr.new ListNode(2, a1);
        ListNode a3 = pr.new ListNode(1, a2);
        ListNode a4 = pr.new ListNode(1, a3);
        ListNode ret = new Problem83().deleteDuplicates(a4);

        while (ret != null) {
            System.out.println("Output:" + ret.val);
            ret = ret.next;
        }

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
