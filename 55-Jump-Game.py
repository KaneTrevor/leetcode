"""
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.

"""


class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        length = len(nums)
        if length == 1:
            return True
        elif nums[0] == 0:
            return False

        sum = 0
        for i in xrange(length - 1):
            sum += nums[i]
        if sum < length - 1:
            return False

        jumpFlag = False
        noneZeroFlag = True
        for i in xrange(length - 1):
            if nums[i] == 0:
                noneZeroFlag = False
                jumpFlag = False

                for p in xrange(i):
                    if nums[p] > i - p:
                        jumpFlag = True
                        break

                if not jumpFlag:
                    return False

        if noneZeroFlag:
            return True
        else:
            return jumpFlag


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    test = Solution()
    x = [1, 2, 0, 1, 1, 2, 3, 0, 0, 0]
    ret = test.canJump(x)

    endTime = datetime.datetime.now()
    print 'canJump:', ret
    print 'running time:%s', (endTime - startTime)
