/*
234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

*/


class Problem234 {
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

    ListNode travel;

    private Boolean recursiveCheck(ListNode p, ListNode head) {
        if (p.next == null) {
            return (head.val == p.val);
        } else {
            ListNode k = p;
            p = p.next;
            Boolean check = recursiveCheck(p, head);
            if (!check) {
                return false;
            }

            travel = travel.next;
            return (travel.val == k.val);
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        this.travel = head;
        return recursiveCheck(head, head);
    }


    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem234 pr = new Problem234();
        ListNode a5 = pr.new ListNode(4, null);
        ListNode a4 = pr.new ListNode(2, a5);
        ListNode a3 = pr.new ListNode(3, a4);
        ListNode a2 = pr.new ListNode(2, a3);
        ListNode a1 = pr.new ListNode(1, a2);
        boolean ret = new Problem234().isPalindrome(a1);

        System.out.println("Output:" + ret);
        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}


