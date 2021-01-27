/*
744. Find Smallest Letter Greater Than Target

Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
*/

class Problem744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target > letters[letters.length - 1]) {
            return letters[0];
        }

        int low = 0, high = letters.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (letters[mid] < target) {
                low = mid + 1;
            } else if (letters[mid] > target) {
                high = mid - 1;
            } else {
                while (mid < letters.length && letters[mid] == target) {
                    mid++;
                }
                return mid > letters.length - 1 ? letters[0] : letters[mid];
            }
        }

        return letters[low];
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();

        char[] input = new char[] {'c','f','j'};
        char ret = new Problem744().nextGreatestLetter(input, 'j');
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}
