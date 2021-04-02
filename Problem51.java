/*
51. N-Queens
Hard

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

 */

import java.util.*;

class Problem51 {
    int dimension = 0;
    int solveNum = 0;
    HashSet<Integer> record = new HashSet<>();
    List<List<String>> solveList = new ArrayList<>();

    private void saveResult(char[][] matrix) {
        List<String> oneSolve = new ArrayList<>();
        for (int j = 0; j < dimension; j++) {
            oneSolve.add(String.valueOf(matrix[j]));
        }
        solveList.add(oneSolve);
    }

    private boolean findNSolution(char[][] matrix, int x, int y) throws Error {
        matrix[x][y] = 'Q';
        record.add(y);

        if (x > 0) {
            for (int j = 0; j < dimension; j++) {
                if (y == j)
                    continue;

                int delta = y - j;
                int x1 = x - delta;
                int x2 = x + delta;

                if ((x1 >= 0 && x1 < dimension && matrix[x1][j] == 'Q') || (x2 >= 0 && x2 < dimension && matrix[x2][j] == 'Q')) {
                    matrix[x][y] = '.';
                    record.remove(y);
                    return false;
                }
            }
        }

        if (x == dimension - 1) {
            saveResult(matrix);
            solveNum++;
            //System.out.println(Arrays.deepToString(matrix));
            return true;
        }

        x++;
        for (int j = 0; j < dimension; j++) {
            if (record.contains(j) || y + 1 == j || y - 1 == j) {
                continue;
            }
            if (findNSolution(matrix, x, j)) {
                matrix[x][j] = '.';
                record.remove(j);
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        assert n > 0;
        if (n == 1) {
            return Collections.singletonList(Collections.singletonList("Q"));
        }
        this.dimension = n;
        char[][] matrix = new char[n][n];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrix[i][j] = '.';
            }
        }

        for (int k = 0; k < dimension; k++) {
            findNSolution(matrix, 0, k);
            matrix[0][k] = '.';
            record.remove(k);
        }
        return solveList;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int n = 6;
        List<List<String>> ret = new Problem51().solveNQueens(n);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}