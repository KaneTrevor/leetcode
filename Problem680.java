/*
680. Valid Palindrome II

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/


class Problem680 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean deleteFlag = false;
        char[] charArr = s.toCharArray();
        while (i < j) {
            if (charArr[i] == charArr[j]) {
                i++;
                j--;
            } else {
                if (!deleteFlag && i == j - 1) {
                    return true;
                }

                //try to delete the left character
                if (!deleteFlag && charArr[i + 1] == charArr[j]) {
                    i += 2;
                    j--;

                    if (i == j) {
                        return true;
                    }
                    else if (charArr[i] != charArr[j]) {
                        i -= 2;
                        j++;
                    } else {
                        deleteFlag = true;
                        continue;
                    }
                }

                //try to delete the right character
                if (!deleteFlag && charArr[i] == charArr[j - 1]){
                    i++;
                    j -= 2;
                    deleteFlag = true;
                    continue;
                }

                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        String input = "lcuppucul";
        //String input = "akvDkvka";
        boolean ret = new Problem680().validPalindrome(input);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
