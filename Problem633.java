/*

633. Sum of Square Numbers

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
Example 3:

Input: c = 4
Output: true
Example 4:

Input: c = 2
Output: true
Example 5:

Input: c = 1
Output: true


Constraints:

0 <= c <= 231 - 1
*/


class Problem633 {

    public boolean judgeSquareSum(int c) {
        int b = (int)Math.sqrt((double)c);
        int a = 0, t;

        while (a <= b){
            t = a * a + b * b;

            if (t < c) {
                a++;
            } else if (t > c) {
                b--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        int target = 55;
        boolean ret = new Problem633().judgeSquareSum(target);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
