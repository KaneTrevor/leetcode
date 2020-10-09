"""
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000

Example 2:

Input: 2.10000, 3
Output: 9.26100

Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Note:

    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [-2^31, 2^31-1]
"""


class Solution(object):
    def __init__(self):
        self.result = 1

    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if x == 0:
            return 0
        elif x == 1:
            return 1
        elif x == -1:
            if n % 2 == 0:
                return 1
            else:
                return -1

        if n == 0:
            return 1
        elif n > 0:
            for i in xrange(n):
                self.result *= x
                if self.result == 0.0:
                    return 0
        else:
            for i in xrange(-n):
                self.result *= 1.0/x
                if self.result == 0.0:
                    return 0
        return self.result


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    test = Solution()
    x = 2.0
    n = -21474836 #21474836
    ret = test.myPow(x, n)

    endTime = datetime.datetime.now()
    print 'myPow:', ret
    print 'running time:%s', (endTime - startTime)

