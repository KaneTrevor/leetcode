/*
53. N-Queens II

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

import com.sun.javafx.logging.JFRInputEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Problem53 {
    //check legal row of the queen
    //for (int i = 0; i < dimension; i++) {
    //    if (i == x) {
    //        continue;
    //    }
    //    if (matrix[i][y] > 0) {
    //        matrix[x][y] = 0;
    //        return false;
    //    }
    //}
    //check legal line of the queen
    //for (int j = 0; j < dimension; j++) {
    //    if (j == y) {
    //        continue;
    //    }
    //    if (matrix[x][j] > 0) {
    //        matrix[x][y] = 0;
    //        return false;
    //    }
    //}

    static final HashSet<Integer> posSet = new HashSet<>(Arrays.asList(0,1,2,3,4));
    int dimension = 0;
    int solveNum = 0;
    HashSet<Integer> record = new HashSet<>();
    //HashSet<int[][]> map = new HashSet<>();

    private boolean findNSolution(int[][] matrix, int x, int y) throws Error {
        matrix[x][y] = 1;
        record.add(y);

        if (solveNum == 7 && y == 2 && x == 4) {
            int kkk = 1;
        }
        if (x > 0) {
            int z = Math.max(x, y);
            for (int i = -z; y + i <= dimension; i++) {
                int v = x + i, k = x - i, t = y + i;

                if (t < 0 || t >= dimension) {
                    continue;
                }
                if (y == t && (v == x || k == x)) {
                    continue;
                }

                if ((v >= 0 && v < dimension && matrix[v][t] > 0) || (k >= 0 && k < dimension && matrix[k][t] > 0)) {
                    matrix[x][y] = 0;
                    record.remove(y);
                    return false;
                }
            }
        }
        //if (g  && x == 2) {
        //    System.out.println(Arrays.deepToString(matrix));
        //    int u = 1;
        //}

        if (x == dimension - 1) {
            //map.add(matrix);
            solveNum++;
            System.out.println(Arrays.deepToString(matrix));
            //matrix[x][y] = 0;
            //record.remove(y);

            //for (int i = 0; i < dimension; i++) {
            //    for (int j = 0; j < dimension; j++) {
            //        matrix[i][j] = 0;
            //    }
            //}
            return true;
        }

        x += 1;
        for (int j = 0; j < dimension; j++) {
            if (!record.contains(j)) {
                boolean solveFlag = false;
                solveFlag = findNSolution(matrix, x , j);
                if (solveFlag ) {   //&& dimension - record.size() > 1
                    matrix[x][j] = 0;
                    record.remove(j);
                }
            }
        }

        //if (x == 0) {
        //    matrix[x][y] = 0;
        //    System.out.println("x :" + x + "record:" + record.size());
        //    //record.clear();
        //}
        return true;
    }

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        this.dimension = n;
        int[][] matrix = new int[n][n];

        for (int k = 0; k < dimension; k++) {
            findNSolution(matrix, 0, k);

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = 0;
                }
            }
            record.clear();
        }

        return solveNum;
    }

    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        int n = 8;
        int ret = new Problem53().totalNQueens(n);
        end = System.currentTimeMillis();
        System.out.println("Output:" + ret);
        System.out.println("Run Time:" + (end - start) + " ms");
    }
}