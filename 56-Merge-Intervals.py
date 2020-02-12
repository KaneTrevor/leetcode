"""
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

NOTE: input types have been changed on April 15, 2019. Please reset to default
code definition to get new method signature.

"""

import copy


class Solution(object):
    @staticmethod
    def sortByFirstNum(elem):
        return elem[0]

    @staticmethod
    def reMerge(vals, length, posX):
        ret = copy.copy(vals)
        i = length - 1

        while i >= 0 and posX <= vals[i][1]:
            posX = min(vals[i][0], posX)
            ret.pop()
            i -= 1
        return ret, posX

    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        ret = []
        length = len(intervals)
        if length < 2:
            return intervals

        intervals.sort(key=self.sortByFirstNum)
        posX = intervals[0][0]
        posY = intervals[0][1]
        i = 1

        while i < length:
            if posY < intervals[i][0] or posX > intervals[i][1]:
                ret.append([posX, posY])
                posX = intervals[i][0]
                posY = intervals[i][1]

                if i == length - 1:
                    # add the last element
                    ret.append([posX, posY])
            else:
                # move the index to the next element when overlapping happens
                while i < length-1 and posX <= intervals[i][1] and posY >= intervals[i][0]:
                    posX = min(intervals[i][0], posX)
                    posY = max(intervals[i][1], posY)
                    i += 1

                if i == length-1 and posX <= intervals[i][1] and posY >= intervals[i][0]:
                    posX = min(intervals[i][0], posX)
                    posY = max(intervals[i][1], posY)
                    ret.append([posX, posY])
                else:
                    ret.append([posX, posY])
                    posX = intervals[i][0]
                    posY = intervals[i][1]

                lenRet = len(ret)
                if lenRet > 0 and posX < ret[lenRet - 1][1]:
                    ret, posX = self.reMerge(ret, lenRet, posX)
                    ret.append([posX, posY])

                if i == length - 1 and lenRet > 0 and [posX, posY] != ret[lenRet - 1]:
                    # add the last element
                    ret.append([posX, posY])

            i += 1
        return ret


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    test = Solution()
    # x = [[-1,3],[3,6],[8,23],[-24,28],[28, 35],[25,66]]
    # x = [[1, 4], [3, 9], [0, 7]]
    # x = [[1, 2], [0, 4]]
    # x = [[1, 4], [0, 0]]
    # x = [[1, 1]]
    x = [[1,3],[15,18],[2,6],[8,10]]
    # x = [[2, 3], [4, 5], [6, 7], [8, 9], [1, 10]]
    # x = [[2,3],[2,2],[3,4],[3,4],[5,5]]
    # x = [[2, 3], [2, 2], [3, 3], [1, 3], [5, 7], [2, 2], [4, 6]]
    # x = [[1, 3], [4, 6], [6, 7]]
    ret = test.merge(x)

    endTime = datetime.datetime.now()
    print '\nmerge:', ret
    print 'running time:%s', (endTime - startTime)
