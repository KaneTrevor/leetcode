
/*
160. Intersection of Two Linked Lists

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.



Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes
 before the intersected node in A; There are 3 nodes before the intersected node in B.


Example 2:


Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before
the intersected node in A; There are 1 node before the intersected node in B.


Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two
lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Each value on each linked list is in the range [1, 10^9].
Your code should preferably run in O(n) time and use only O(1) memory.
*/


class Problem160 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        if (headA.equals(headB)) {
            return headA;
        }

        int countA = 0, countB = 0, diff;
        ListNode pA = headA, pB = headB;

        while (pA.next != null) {
            pA = pA.next;
            countA++;
        }

        while (pB.next != null) {
            pB = pB.next;
            countB++;
        }

        if (!pA.equals(pB)) {
            return null;
        }

        pA = headA;
        pB = headB;
        if (countA > countB) {
            diff = countA - countB;
            for (int i = 0; i < diff; i++) {
                pA = pA.next;
            }
        } else {
            diff = countB - countA;
            for (int i = 0; i < diff; i++) {
                pB = pB.next;
            }
        }

        do {
            if (pA.equals(pB)) {
                return pA;
            }

            pA = pA.next;
            pB = pB.next;
        } while (pA.next != null);

        if (pA.equals(pB)) {
            return pA;
        }

        return null;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        Problem160 pr = new Problem160();
        ListNode a1 = pr.new ListNode(9);
        ListNode a2 = pr.new ListNode(4);
        ListNode a3 = pr.new ListNode(2);
        ListNode a4 = pr.new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        ListNode b1 = pr.new ListNode(3);
        ListNode b2 = pr.new ListNode(1);
        //ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = a3;

        ListNode ret = new Problem160().getIntersectionNode(a1, b1);

        end = System.currentTimeMillis();
        System.out.println("Output:" + (ret == null ? null : ret.val));
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
