/*
20. Valid Parentheses

Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/
package main

import (
	"fmt"
)

//Stack
type Element interface {}

type sliceEntry struct{
	element []Element
}

func NewSliceEntry() *sliceEntry {
	return &sliceEntry{}
}

func (entry *sliceEntry) Push(e Element) {
	entry.element = append(entry.element,e)
}

func (entry *sliceEntry) Pop() Element {
	size := entry.Size()
	if size == 0 {
		return nil
	}
	lastElement := entry.element[size-1]
	entry.element[size-1] = nil
	entry.element  = entry.element[:size-1]
	return lastElement
}

func (entry *sliceEntry) Top() Element {
	size := entry.Size()
	if size == 0 {
		return nil
	}
	return entry.element[size-1]
}

func (entry *sliceEntry) Clear() bool {
	if entry.IsEmpty() {
		return false
	}
	for i :=0;i<entry.Size();i++ {
		entry.element[i] = nil
	}
	entry.element = make([]Element,0)
	return true
}

func (entry *sliceEntry) Size() int {
	return len(entry.element)
}

func (entry *sliceEntry) IsEmpty() bool {
	if len(entry.element) == 0 {
		return true
	}
	return false
}

func isValid(s string) bool {
	var length int = len(s)
	if length == 0 {
		return true
	}
	entry := NewSliceEntry()

	var matchSum int = 0
	for i := 0; i < length; i++ {
		switch s[i] {
		case '{','[','(':
			entry.Push(byte(s[i]))
		case '}',']',')':
			bracket := entry.Pop()
			if nil == bracket && matchSum == length {
				return true
			}

			value, ok := bracket.(byte)
			if !ok {
				fmt.Println("It's not ok for type byte")
				return false
			}
			switch value {
			case '{':
				if s[i] == '}' {
					matchSum += 2
				} else {
					return false
				}
			case '[':
				if s[i] == ']' {
					matchSum += 2
				} else {
					return false
				}
			case '(':
				if s[i] == ')' {
					matchSum += 2
				} else {
					return false
				}
			default:
				return false
			}
		default:
			return false
		}
	}

	if matchSum == length {
		return true
	} else {
		return false
	}
}

func main() {
	//()[]{}
	//[({(())}[(}])]
	str := "[({(())}[(}])]"
	ret := isValid(str)
	fmt.Println("out put:", ret)
}