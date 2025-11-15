package com.hoclamdev.arrayandhashing;

/*
36. Valid Sudoku
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Example 1:
Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:
Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

Constraints:
board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class P36ValidSudoku {
//    private static boolean isValidSudoku(char[][] board) {
//        Set<Character>[] cols = new HashSet[9];
//        Set<Character>[] rows = new HashSet[9];
//        Set<Character>[] boxes = new HashSet[9];
//        for (int i = 0; i < 9; ++i) {
//            rows[i] = new HashSet<>();
//            cols[i] = new HashSet<>();
//            boxes[i] = new HashSet<>();
//        }
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] == '.') {
//                    continue;
//                }
//                char cell = board[i][j];
//
//                if (rows[i].contains(cell)) {
//                    return false;
//                }
//                rows[i].add(cell);
//
//                if (cols[j].contains(cell)) {
//                    return false;
//                }
//                cols[j].add(cell);
//
//                Set<Character> box = boxes[(i / 3) * 3 + (j / 3)];
//                if (box.contains(cell)) {
//                    System.out.println(cell + " " + i + " " + j);
//                    return false;
//                }
//                box.add(cell);
//            }
//        }
//        return true;
//    }

    private static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (!isValidCell(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidCell(char[][] board, int row, int col) {
        char ch = board[row][col];
        board[row][col] = '.';
        for (int i = 0; i < 9; ++i) {
            if (ch == board[i][col]) {
                return false;
            }
            if (ch == board[row][i]) {
                return false;
            }
            int boxRow = (row / 3) * 3 + i / 3;
            int boxCol = (col / 3) * 3 + i % 3;
            if (ch == board[boxRow][boxCol]) {
                return false;
            }
        }
        board[row][col] = ch;
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println("Result: " + isValidSudoku(board));
    }
}

/*
0 1 2
3 4 5
6 7 8

i = 1
j =  0

 */