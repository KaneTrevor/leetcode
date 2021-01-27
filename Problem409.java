/*
409. Longest Palindrome

Given a string s which consists of lowercase or uppercase letters, return the length of
the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2


Constraints:

1 <= s.length <= 2000
s consits of lower-case and/or upper-case English letters only.
*/


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Problem409 {
    public int longestPalindrome(String s) {
        char[] chArr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch: chArr) {
            map.merge(ch, 1, (prev , one) -> prev + one);
        }

        int[] oneWord = {0 , 0};
        map.forEach((ch , val) -> {
            if (val % 2 == 0) {
                oneWord[1] += val;
            } else if (val > 2) {
                oneWord[1] += val - 1;
                if (oneWord[0] < 1) {
                    oneWord[0]++;
                }
            } else if (val == 1 && oneWord[0] < 1) {
                oneWord[0]++;
            }
        }) ;

        return oneWord[0] + oneWord[1];
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        String input = "cct";
        int ret = new Problem409().longestPalindrome(input);
        end = System.currentTimeMillis();

        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
