/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.

*/

package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}

func swapPairs(head *ListNode) *ListNode {
	if nil == head {
		return head
	}
	p := new(ListNode)
	change := new(ListNode)
	preChange := new(ListNode)
	preChange = nil
	p = head
	count := 1

	for ; p!= nil; {
		if count % 2 == 0 {
			//handle the node after p
			change.Next = p.Next
			p.Next = change

			//handle the node before p
			if nil != preChange {
				preChange.Next = p
			}
			if count == 2 {
				head = p
			}
			preChange = change
			p = change
		} else {
			change = p
		}

		if nil != p.Next {
			p = p.Next
		} else {
			return head
		}
		count++
	}
	return head
}

func main() {
	l14 := ListNode{4, nil}
	l13 := ListNode{3, &l14}
	l12 := ListNode{2, &l13}
	l11 := ListNode{1, &l12}

	p := swapPairs(&l11)
	for {
		fmt.Printf("p-val: %d\n", p.Val)
		if p.Next != nil {
			p = p.Next
		} else {
			break
		}
	}
}