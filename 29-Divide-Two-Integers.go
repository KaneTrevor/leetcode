/*
29. Divide Two Integers

Given two integers dividend and divisor, divide two integers without using multiplication, division
and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero, which means losing its fractional part. For example,
truncate(8.345) = 8 and truncate(-2.7335) = -2.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.

Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.

Note:

    Both dividend and divisor will be 32-bit signed integers.
    The divisor will never be 0.
    Assume we are dealing with an environment which could only store integers within the 32-bit
    signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your
    function returns 231 − 1 when the division result overflows.
*/

package main

import (
	"fmt"
	"math"
)

func absInteger(n int)int  {
	if n < 0 {
		return -n
	} else {
		return n
	}
}

func divide(dividend int, divisor int) int {
	quotient := 0
	factor := 0
	negativeFlag := false

	if divisor == 1 {
		return dividend
	} else if divisor == -1 {
		minNum := int(math.Pow(2,31))
		if dividend > -minNum {
			return -dividend
		} else {
			return minNum - 1
		}
	}

	if dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0 {
		negativeFlag = true
		if dividend < 0 {
			dividend = -dividend
		} else {
			divisor = -divisor
		}
	} else {
		if absInteger(dividend) < absInteger(divisor) {
			return 0
		}
		if dividend < 0 {
			dividend = -dividend
			divisor = -divisor
		}
	}

	for {
		quotient = dividend - divisor * factor
		if quotient >= divisor {
			factor++
		} else {
			if negativeFlag {
				return -factor
			} else {
				return factor
			}
		}
	}
}

func main() {
	dividend := 7
	divisor := -3
	ret := divide(dividend, divisor)
	fmt.Println("ret", ret)
}