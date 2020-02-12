"""
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


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
                while i < length - 1 and posX <= intervals[i][1] and posY >= intervals[i][0]:
                    posX = min(intervals[i][0], posX)
                    posY = max(intervals[i][1], posY)
                    i += 1

                if i == length - 1 and posX <= intervals[i][1] and posY >= intervals[i][0]:
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

    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        intervals.append(newInterval)
        ret = self.merge(intervals)
        return ret


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    test = Solution()
    # x = [[-1,3],[3,6],[8,23],[-24,28],[28, 35],[25,66]]
    # x = [[1, 4], [3, 9], [0, 7]]
    # x = [[1, 2], [0, 4]]
    # x = [[2, 4], [0, 0]]
    # x = [[1, 1]]
    x = [[1,3],[4,6],[8,10]]
    y = [6,9]
    ret = test.insert(x, y)

    endTime = datetime.datetime.now()
    print '\ninsert:', ret
    print 'running time:%s', (endTime - startTime)
