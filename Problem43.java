/*
43. Multiply Strings

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also
represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contain only digits 0-9.
    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

import java.util.ArrayList;
import java.util.List;

class Problem43 {
    List<int[]> matrix = new ArrayList<>();

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";

        int v = 0;
        for (int i = num1.length() - 1; i >= 0; i--, v++) {
            int a = Integer.parseInt(String.valueOf(num1.charAt(i)));

            int[] one = new int[num2.length() + v + 1];
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = Integer.parseInt(String.valueOf(num2.charAt(j)));
                int result = a * b;
                one[j + 1] = result;
            }

            //reset the numbers in one array which all between 0 to 9
            for (int k = one.length - 1; k >= 0; k--) {
                if (one[k] > 10) {
                    int tmp = one[k] / 10;
                    one[k] = one[k] - tmp * 10;
                    one[k - 1] += tmp;
                }
            }
            matrix.add(one);
        }

        int biggestSize = matrix.get(matrix.size() - 1).length;
        int allSize = matrix.size() + biggestSize;
        int[] all = new int[allSize];
        int k = allSize - 1;
        v = 0;
        for (int i = biggestSize - 1; i >= 0; i--, v++, k--) {
            int s = 0;
            for (int[] one : matrix) {
                if (one.length - 1 >= v) {
                    s += one[one.length - 1 - v];
                }
            }
            all[k] = s;
        }

        //reset the numbers in all array which all between 0 to 9
        for (int j = allSize - 1; j > 0; j--) {
            if (all[j] >= 10) {
                int n = 1;
                while (all[j] >= Math.pow(10, n)) {
                    n++;
                }
                n--;

                int tmp = all[j];
                for (int i = 1; i <= n; i++, n--) {
                    int pow = (int)Math.pow(10, i);
                    int p = tmp / pow;
                    all[j - i] += p;
                    tmp -= p * pow;
                }
                all[j] = tmp;
            }
        }

        StringBuilder sum = new StringBuilder();
        boolean begin = false;
        for (int j = 0; j < allSize; j++) {
            if (all[j] != 0) {
                begin = true;
            }
            if (begin) {
                sum.append((char) (all[j] + 48));
            }
        }
        return sum.toString();
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        String num1 = "401716832807512840963";
        String num2 = "167141802233061013023557397451289113296441069";
        String ret = new Problem43().multiply(num1, num2);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret + " len" + ret.length());
        System.out.println("Run Time:" + (end - start) + " ms");

//        String test = "999999998222000000790321";
//        System.out.println(test.length());
    }
}

//""401716832807512840963"
//"167141802233061013023557397451289113296441069""
