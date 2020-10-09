/*
23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


*/

package main

import (
	"fmt"
)

type ListNode struct {
	Val int
	Next *ListNode
}

func mergeKLists(lists []*ListNode) *ListNode {
	length := len(lists)
	p := new(ListNode)
	if length == 0 {
		p = nil
		return p
	}
	head := new(ListNode)
	head = p

	for {
		minVal := 0
		beginIndex := 0
		for i := 0; i < length; i++ {
			if lists[i] != nil {
				minVal = lists[i].Val
				beginIndex = i
				break
			}
		}

		minIndex := beginIndex
		for i := beginIndex; i < length; i++ {
			if nil != lists[i] && lists[i].Val < minVal {
				minVal = lists[i].Val
				minIndex = i
			}
		}
		if nil == lists[minIndex] {
			return head.Next
		}

		p.Next = lists[minIndex]
		p = p.Next
		lists[minIndex] = lists[minIndex].Next

		//check if all lists reach their ends
		endCount := 0
		for i := 0; i < length; i++ {
			if lists[i] == nil {
				endCount++
			}
		}

		if endCount == length {
			break
		}
	}

	return head.Next
}


func main() {
	l13 := ListNode{3, nil}
	l12 := ListNode{2, &l13}
	l11 := ListNode{1, &l12}

	l25 := ListNode{9, nil}
	l24 := ListNode{6, &l25}
	l23 := ListNode{-2, &l24}
	l22 := ListNode{0, &l23}
	l21 := ListNode{-3, &l22}

	l33 := ListNode{5, nil}
	l32 := ListNode{4, &l33}
	l31 := ListNode{-1, &l32}

	pListNode := make([] *ListNode, 3)
	pListNode[0] = &l11
	pListNode[1] = &l21
	pListNode[2] = &l31

	p := mergeKLists(pListNode)
	for {
		fmt.Printf("p-val: %d\n", p.Val)
		if p.Next != nil {
			p = p.Next
		} else {
			break
		}
	}

}