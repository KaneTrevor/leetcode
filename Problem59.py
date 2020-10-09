"""
59. Spiral Matrix II

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

"""


class Solution:
    def __init__(self):
        pass

    def generateMatrix(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        if n == 1:
            return [[1]]

        squareNum = pow(n, 2)
        row = line = n
        matrix = [[0 for _ in range(n)] for _ in range(n)]
        a = 0
        b = 1
        c = n - 1
        d = 0
        x = 1
        times = -1

        try:
            while x <= squareNum:
                for i in xrange(a, line):
                    matrix[a][i] = x
                    x += 1
                a += 1

                if x > squareNum:
                    return matrix

                for i in xrange(b, row - 1):
                    matrix[i][line - 1] = x
                    x += 1
                b += 1

                for i in xrange(line - 1, times, -1):
                    matrix[c][i] = x
                    x += 1
                c -= 1
                times += 1

                if x > squareNum:
                    return matrix

                for i in xrange(row - 1 - 1, times, -1):
                    matrix[i][d] = x
                    x += 1
                d += 1

                if x > squareNum:
                    return matrix
                else:
                    line -= 1
                    row -= 1

            return matrix

        except Exception as e:
            print "e:", e, "matrix:", matrix
            return matrix


if __name__ == '__main__':
    import datetime

    startTime = datetime.datetime.now()
    x = 3
    ret = Solution().generateMatrix(x)
    endTime = datetime.datetime.now()

    print 'output:', ret
    print 'running time:%s', (endTime - startTime)
