/*
28. Implement strStr()


Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not
part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask
during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This
is consistent to C's strstr() and Java's indexOf().
*/

package main

import (
	"fmt"
)

//TODO: KMP compare
//https://blog.csdn.net/yuxin6866/article/details/52149585

func strStr(haystack string, needle string) int {
	lenN := len(needle)
	if 0 == lenN {
		return 0
	}
	lenH := len(haystack)

	for i := 0; i< lenH; i++ {
		if needle[0] == haystack[i] {
			hIndex := i
			j := 0
			for j = 0; j < lenN && hIndex < lenH && needle[j] == haystack[hIndex]; j++ {
				hIndex++
			}
			if j == lenN {
				return i
			}
		}
	}
	return -1
}


func main() {
	haystack := "akaavaaa"
	needle := "aaa"
	index  := strStr(haystack, needle)

	fmt.Println("len", index )
}


