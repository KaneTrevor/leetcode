/*
540. Single Element in a Sorted Array

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
your product fails the quality check. Since each version is developed based on the previous version, all the versions
after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the
 first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1


Constraints:

1 <= bad <= n <= 231 - 1
*/

class Problem278 extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, h = n, m;
        while (l <= h){
            m = l + (h - l) / 2;
            if (isBadVersion(m)) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int ret = new Problem278().firstBadVersion(6);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}


class VersionControl {
    boolean isBadVersion(int version) {
        return (version >= 3);
    }
}