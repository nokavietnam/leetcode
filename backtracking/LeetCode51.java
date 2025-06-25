// 51. N-Queens
//
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Each solution contains a distinct board configuration of the n-queens placement,
//        where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//
// Example 2:
// Input: n = 1
// Output: [["Q"]]
//
// Constraints:
// 1 <= n <= 9

import java.util.*;

class LeetCode51 {
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> ans = new ArrayList<>();
            char[][] board = new char[n][n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(board[j], '.');
            }
            dfs(0, n, board, ans);
            return ans;
        }

        public void dfs(int row, int n, char[][] board, List<List<String>> ans) {
            if (row == n) {
                List<String> solution = new ArrayList<>();
                for (char[] rowArr : board) {
                    solution.add(new String(rowArr));
                }
                ans.add(solution);
                return;
            }
            for (int i = 0; i < n; ++i) {
                if (!isValid(row, i, n, board)) {
                    continue;
                }
                board[row][i] = 'Q';
                dfs(row + 1, n, board, ans);
                board[row][i] = '.';
            }
        }

        public boolean isValid(int row, int col, int n, char[][] board) {
            for (int i = 0; i <= row; ++i) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }

            // main diagonal
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }

            // second diagonal
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
                if (board[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> ans = solution.solveNQueens(4);
        for (List<String> list : ans) {
            for (String item : list) {
                System.out.println(item + " ");
            }
            System.out.println();
        }
    }
}