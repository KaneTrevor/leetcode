//import com.google.common.collect.Lists;


class Problem36 {
    private static final int SUDOKU_LEN = 9;
    private static final int SMALL_BOX_LINE = 3;

    private boolean isValidBox(char[] box) {
        for (int i = 0; i < SUDOKU_LEN - 1; i++) {
            if (box[i] != '.') {
                char x = box[i];
                for (int j = i + 1; j < SUDOKU_LEN; j++) {
                    if (box[j] != '.' && x == box[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean isValidSudoku(char[][] board) {
        //for (int i = 0; i < SUDOKU_LEN; i++) {
        //    for (int j = 0; j < SUDOKU_LEN; j++) {
        //        if (board[i][j] != '.') {
        //            System.out.print((int) (board[i][j]) - (int) ('0') + " ");
        //            //System.out.print(Character.getNumericValue(x) + " ");
        //        } else {
        //            System.out.print(". ");
        //        }
        //    }
        //    System.out.println();
        //}

        char x;
        //check each line
        for (char[] line : board) {
            for (int j = 0; j < SUDOKU_LEN; j++) {
                if (line[j] != '.' && j < SUDOKU_LEN - 1) {
                  x = line[j];
                  for (int u = j + 1; u < SUDOKU_LEN ; u++) {
                      if (line[u] != '.' && x == line[u]) {
                          return false;
                      }
                  }
                }
            }
        }

        //check each row
        for (int i = 0; i < SUDOKU_LEN ; i++) {
            for (int j = 0; j < SUDOKU_LEN - 1; j++) {
                if (board[j][i] != '.') {
                    x = board[j][i];
                    for (int u = j + 1; u < SUDOKU_LEN; u++) {
                        if (board[j][i] != '.' && x == board[u][i]) {
                            return false;
                        }
                    }
                }
            }
        }

        //check each 3*3 sub-boxes
        int lineStart = 0;
        int rowStart = 0;
        char[] box = new char[9];

        for (int k = 0; k < SMALL_BOX_LINE; k++) {
            for (int t = 0; t < SMALL_BOX_LINE; t++) {
                int v = 0;
                for (int i = lineStart; i < lineStart + 3; i++) {
                    for (int j = rowStart; j < rowStart + 3; j++) {
                        box[v++] = board[i][j];
                    }
                }
                if (!isValidBox(box)) {
                    return false;
                }
                rowStart += SMALL_BOX_LINE;
            }
            rowStart = 0;
            lineStart += SMALL_BOX_LINE;
        }

        return true;
    }
}


class Problem36 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '5', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '1', '.', '8', '.', '.', '7', '9'}};

        boolean ret = new Problem36().isValidSudoku(matrix);
        System.out.println("Output:" + ret);

        //int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        //for (int i = 0; i < arr.length; i++) {
        //
        //    for (int j = 0; j < arr[i].length; j++) {
        //        System.out.print(arr[i][j] + ' ');
        //    }
        //    System.out.println();
        //}
    }
}
