/*
25. Reverse Nodes in k-Group

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple
of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.




*/

package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	if nil == head {
		return head
	}
	p := new(ListNode)
	tmp := new(ListNode)
	p = head
	tmp = nil
	headFlag := true

	list := make([] *ListNode, k)
	for ; p!= nil; {
		for i := 0; i < k; i++ {
			if nil == p {
				return head
			}
			list[i] = p
			p = p.Next
		}

		//the last series point to new ones
		if nil != tmp {
			tmp.Next = list[k-1]
		}

		//handle the first and last one of the series
		tmp = list[k-1].Next
		for i := k-1; i > 0; i-- {
			list[i].Next = list[i-1]
		}
		list[0].Next = tmp
		p = tmp
		if headFlag {
			head = list[k-1]
			headFlag = false
		}

		//point to the last of new series
		tmp = list[0]
	}
	return head
}

func main() {
	l15 := ListNode{5, nil}
	l14 := ListNode{4, &l15}
	l13 := ListNode{3, &l14}
	l12 := ListNode{2, &l13}
	l11 := ListNode{1, &l12}

	p := reverseKGroup(&l11, 3)
	for {
		fmt.Printf("p-val: %d\n", p.Val)
		if p.Next != nil {
			p = p.Next
		} else {
			break
		}
	}
}