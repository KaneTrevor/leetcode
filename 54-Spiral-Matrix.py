"""
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

"""


class Solution(object):
    def __init__(self):
        pass

    def spiralOrder(self, matrix):
        row = len(matrix)
        if row < 1:
            return matrix
        if row == 1:
            return matrix[0]
        line = len(matrix[0])

        numOfMatrix = row * line
        x = []

        try:
            while len(x) < numOfMatrix:
                for i in xrange(0, line):
                    x.append(matrix[0][i])

                if len(x) == numOfMatrix:
                    return x

                for i in xrange(1, row-1):
                    x.append(matrix[i][line-1])
                x.extend(matrix[row-1][::-1])

                if len(x) == numOfMatrix:
                    return x

                for i in xrange(row - 1 - 1, 0, -1):
                    x.append(matrix[i][0])

                if len(x) == numOfMatrix:
                    return x

                tmp = []
                for i in xrange(1, row-1):
                    tmp.append(matrix[i][1:line-1])
                matrix = tmp

                if len(matrix) > 0:
                    line = len(matrix[0])
                    row = len(matrix)
            return x

        except Exception as e:
            print "e:", e, "matrix:", matrix
            return x


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    test = Solution()
    x = [[1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12]]
    ret = test.spiralOrder(x)

    endTime = datetime.datetime.now()
    print 'spiralOrder:', ret
    print 'running time:%s', (endTime - startTime)

