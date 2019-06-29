/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be
made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/

package main
import "fmt"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */


type ListNode struct {
	 Val int
	 Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if nil == l1 {
		return l2
	}
	if nil == l2 {
		return l1
	}
	headNode := &ListNode{}
	p := &headNode

	l1EndFlag, l2EndFlag := false, false
	for {
		if l1.Val < l2.Val {
			(*p).Val = l1.Val
			if l1.Next != nil {
				l1 = l1.Next
				(*p).Next = &ListNode{}
				p = &(*p).Next
			} else {
				l1EndFlag = true
				break
			}
		} else {
			(*p).Val = l2.Val
			if l2.Next != nil {
				l2 = l2.Next
				(*p).Next = &ListNode{}
				p = &(*p).Next
			} else {
				l2EndFlag = true
				break
			}
		}
	}

	if l1EndFlag {
		(*p).Next = l2
	}
	if l2EndFlag {
		(*p).Next = l1
	}

	return headNode
}

func main() {
	l11 := ListNode{1, nil}
	l12 := ListNode{2, nil}
	l13 := ListNode{3, nil}
	l11.Next = &l12
	l12.Next = &l13

	l21 := ListNode{-3, nil}
	l22 := ListNode{0, nil}
	l23 := ListNode{-2, nil}
	l24 := ListNode{6, nil}
	l25 := ListNode{9, nil}
	l21.Next = &l22
	l22.Next = &l23
	l23.Next = &l24
	l24.Next = &l25


	p := mergeTwoLists(&l11, &l21)
	for {
		fmt.Printf("p-val: %d\n", p.Val)
		if p.Next != nil {
			p = p.Next
		} else {
			break
		}
	}

}