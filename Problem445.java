/*
445. Add Two Numbers II

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first
and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/


import java.util.LinkedList;

class Problem445 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       if (l1 == null)
           return l2;
       else if (l2 == null)
           return l1;

        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        do {
            if (l1 != null) {
                q1.push(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                q2.push(l2.val);
                l2 = l2.next;
            }
        } while (l1 != null || l2 != null);

        ListNode p = null;
        int carry = 0;

        do {
            int a = q1.isEmpty() ? 0 : q1.pop();
            int b = q2.isEmpty() ? 0 : q2.pop();
            int sum  = a + b + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            ListNode k = new ListNode(sum);
            k.next = p;
            p = k;
        } while (!q1.isEmpty() || !q2.isEmpty() || carry > 0);

        return p;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem445 pr = new Problem445();
        ListNode a5 = pr.new ListNode(9, null);
        ListNode a4 = pr.new ListNode(9, a5);
        ListNode a3 = pr.new ListNode(9, a4);
        ListNode a2 = pr.new ListNode(9, a3);
        ListNode a1 = pr.new ListNode(9, a2);


        ListNode b3 = pr.new ListNode(9, null);
        ListNode b2 = pr.new ListNode(9, b3);
        ListNode b1 = pr.new ListNode(9, b2);

        ListNode ret = new Problem445().addTwoNumbers(a1, b1);

        while (ret != null) {
            System.out.println("Output:" + ret.val);
            ret = ret.next;
        }

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}


