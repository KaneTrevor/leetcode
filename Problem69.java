/*
69. Sqrt(x)

Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result
 is returned.

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.


Constraints:

0 <= x <= 2^31 - 1
*/


class Problem69 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int low = 1, high = x, middle;
        while (high >= low) {
            middle = low + (high - low) / 2;
            int result = x / middle;
            if (result == middle ) {
                return middle;
            } else if (result < middle) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        int target = 2147395599;
        int ret = new Problem69().mySqrt(target);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
