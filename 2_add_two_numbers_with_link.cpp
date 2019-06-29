/*
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are
stored in reverse order and each of

their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Definition for singly-linked list.
struct ListNode {
int val;
ListNode next;
ListNode(int x) : val(x), next(NULL) {}
};

*/

#include <iostream>
#include<math.h>
#include<vector>
#include <algorithm>


struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};


class Solution {
public:
	ListNode* addTwoNumbers(ListNode* a, ListNode* b) {
		ListNode *head = new ListNode(0);
		head = a;
		int move_to_next_flag = 0;
		while (a || b) {
			a->val += b->val;
			if (move_to_next_flag) {
				a->val += 1;
				move_to_next_flag = 0;
			}
			if (a->val > 9) {
				a->val -= 10;
				move_to_next_flag = 1;
			}

			if (a->next || b->next || move_to_next_flag) {
				if (!b->next) {
					b->next = new ListNode(0);
				}
				if (!a->next) {
					a->next = new ListNode(0);
				}
			}

			a = a->next;
			b = b->next;
		}
		return head;
	}
};

int main(int argc, char *argv[])
{
	ListNode l1(9);
	ListNode l2(9);
	l1.next = &l2;
	ListNode l4(1);

	Solution a;
	ListNode *p = a.addTwoNumbers(&l1, &l4);

	while (p) {
		std::cout << "p-val: " << p->val << "  " << std::endl;
		p = p->next;
	}
	system("pause");
	return(0);
}
