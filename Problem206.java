
/*
206. Reverse Linked List

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/


class Problem206 {
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

    private ListNode recursivelyReverse(ListNode prev, ListNode p) {
        if (p.next == null) {
            //p.next = prev;
            return p;
        } else {
            ListNode head = recursivelyReverse(p, p.next);
            p.next.next = p;
            return head;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = recursivelyReverse(head, head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }


    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head, a = null , b = null;
        boolean aFlag = true;
        while (p.next != null) {
            a = p;
            p = p.next;
            a.next = b;
            b = p;
            aFlag = true;

            if (p.next != null) {
                //b = p;
                p = p.next;
                b.next = a;
                aFlag = false;
            } else {
                p.next = a;
                break;
            }
        }

        if (aFlag) {
            p.next = a;
        } else {
            p.next = b;
        }

        return p;
    }


    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        Problem206 pr = new Problem206();
        ListNode a5 = pr.new ListNode(5, null);
        ListNode a4 = pr.new ListNode(4, a5);
        ListNode a3 = pr.new ListNode(3, a4);
        ListNode a2 = pr.new ListNode(2, a3);
        ListNode a1 = pr.new ListNode(1, a2);
        ListNode ret = new Problem206().reverseList(a1);

        while (ret != null) {
            System.out.println("Output:" + ret.val);
            ret = ret.next;
        }

        end = System.currentTimeMillis();
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
