/*
52. N-Queens II

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other

 Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example:

Input: 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

 */

import java.util.HashSet;

class Problem52 {
    int dimension = 0;
    int solveNum = 0;
    HashSet<Integer> record = new HashSet<>();

    private boolean findNSolution(int[][] matrix, int x, int y) throws ArrayIndexOutOfBoundsException {
        matrix[x][y] = 1;
        record.add(y);

        if (x > 0) {
            for (int j = 0; j < dimension; j++) {
                if (y == j)
                    continue;

                int delta = y - j;
                int x1 = x - delta;
                int x2 = x + delta;

                if ((x1 >= 0 && x1 < dimension && matrix[x1][j] > 0) || (x2 >= 0 && x2 < dimension && matrix[x2][j] > 0)) {
                    matrix[x][y] = 0;
                    record.remove(y);
                    return false;
                }
            }
        }

        if (x == dimension - 1) {
            solveNum++;
            //System.out.println(Arrays.deepToString(matrix));
            //matrix[x][y] = 0;
            //record.remove(y);
            return true;
        }

        x++;
        for (int j = 0; j < dimension; j++) {
            if (record.contains(j) || y + 1 == j || y - 1 == j) {
                continue;
            }
            if (findNSolution(matrix, x, j)) {
                matrix[x][j] = 0;
                record.remove(j);
            }
        }

        return true;
    }

    public int totalNQueens(int n) {
        assert n > 0;
        if (n == 1) {
            return 1;
        }
        this.dimension = n;
        int[][] matrix = new int[n][n];

        for (int k = 0; k < dimension; k++) {
            findNSolution(matrix, 0, k);
            matrix[0][k] = 0;
            record.remove(k);
        }

        return solveNum;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int n = 12;
        int ret = new Problem52().totalNQueens(n);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}