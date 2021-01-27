/*
345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".


*/


import java.util.Arrays;
import java.util.HashSet;

class Problem345 {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));


    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }

    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int i = 0, j = charArr.length - 1;
        while (i <= j) {
            if (vowels.contains(charArr[i]) && vowels.contains(charArr[j])) {
                swap(charArr, i, j);
                i++;
                j--;
            } else if (vowels.contains(charArr[i])) {
                j--;
            } else if (vowels.contains(charArr[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        String input = "aA";
        String ret = new Problem345().reverseVowels(input);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
