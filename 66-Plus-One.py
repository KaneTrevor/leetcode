"""
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.


"""


class Solution:
    def __init__(self):
        pass

    def plusOne(self, digits):
        lenDigits = len(digits)

        index = lenDigits - 1
        while index >= 0:
            digits[index] += 1
            if digits[index] > 9:
                digits[index] = 0
                index -= 1
                if index < 0:
                    a = [1]
                    a.extend(digits)
                    return a
            else:
                return digits

        return digits


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    test = Solution()
    x = [4,3,2,1]
    ret = test.plusOne(x)

    endTime = datetime.datetime.now()
    print 'spiralOrder:', ret
    print 'running time:%s', (endTime - startTime)

