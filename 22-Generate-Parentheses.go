/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of
well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

package main

import (
	"fmt"
)

func generateParenthesis(n int) []string {
	strMap := make([]string, 0)
	if n == 1 {
		strMap = append(strMap, "()")
	} else {
		matrix := make([]int, (n-1)*2)
		for i := 0; i < n-1; i++ {
			matrix[i] = 1
		}
		for i := n - 1; i < 2*n-2; i++ {
			matrix[i] = -1
		}
		permutation(&strMap, matrix, 0, len(matrix))
	}
	return strMap
}

func isRepeated(data []int, left int, right int) bool {
	for i := left; i < right; i++ {
		if data[i] == data[right] {
			return true
		}
	}
	return false
}

func permutation(strMap *[]string, data []int, step int, length int)  {
	if length == step + 1 {
		trial := make([]int, length*2)
		trial[0] = 1
		trial[length*2-1] = -1
		str := "("
		count := 1

		for i := 0; i < length; i++ {
			trial[i+1] = data[i]
			count += data[i]
			if -1 == data[i] {
				str += ")"
			} else {
				str += "("
			}
			if count < 0 {
				return
			}
		}
		str += ")"
		*strMap = append(*strMap, str)
	} else {
		for i := step; i < length; i++ {
			if !isRepeated(data, step, i) {
				data[step], data[i] = data[i], data[step]
				permutation(strMap, data, step + 1, length)
				data[step], data[i] = data[i], data[step]
			}
		}
	}
}

func main() {
	input := 5
	ret := generateParenthesis(input)
	fmt.Println("ret", ret)
}
