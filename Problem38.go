/*
38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.


Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/

package main

import (
	"fmt"
)

func readAndInterpret(str string) string {
	length := len(str)
	retStr := ""
	for i := 0; i < length; {
		sameNum := int(str[i])
		count := 0
		for j := i; j < length && int(str[j]) == sameNum; j++ {
			count++
		}
		i += count

		retStr += fmt.Sprintf("%d%c",count, sameNum)
	}
	return retStr
}

func countAndSay(n int) string {
	if n == 1 {
		return "1"
	} else {
		return readAndInterpret(countAndSay(n - 1))
	}
}

func main() {
	str := countAndSay(10)
	fmt.Println("str", str)
}


