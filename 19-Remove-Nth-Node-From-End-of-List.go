/*
19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list
and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list
becomes 1->2->3->5.

Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?
*/

package main

import (
	"fmt"
)

//Definition for singly-linked list.
type ListNode struct {
	Val int
	Next *ListNode
}
var pPreNode **ListNode

func findPreDelNode(p *ListNode, n int) int {
	if nil == p.Next {
		if 1 == n {
			pPreNode = &p
		}
		return 1
	} else {
		p = p.Next
		distance := findPreDelNode(p, n)

		if distance - 1 == n {
			pPreNode = &p
		}
		return distance + 1
	}
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	var pIterator *ListNode

	preHead := ListNode{0, head}
	prePreHead := ListNode{0, &preHead}
	pIterator = &prePreHead
	count := findPreDelNode(pIterator, n)

	if count - 2 != n {
		(*pPreNode).Next = (*pPreNode).Next.Next
	} else {
		head = head.Next
	}

	return head
}

func main() {
	l5 := ListNode{5, nil}
	l4 := ListNode{4, &l5}
	l3 := ListNode{3, &l4}
	l2 := ListNode{2, &l3}
	head := &ListNode{1, &l2}

	p := removeNthFromEnd(head, 3)
	for {
		fmt.Printf("p-val: %d\n", p.Val)
		if p.Next != nil {
			p = p.Next
		} else {
			break
		}
	}
}