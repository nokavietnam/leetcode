// 994. Rotting Oranges
// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

import java.util.*;

public class LeetCode994 {
    static class Solution {
        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] visited = grid;
            Queue<int[]> q = new LinkedList<>();
            int countFreshOrange = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 2) {
                        q.offer(new int[] {i, j});
                    }
                    if (visited[i][j] == 1) {
                        countFreshOrange++;
                    }
                }
            }
            if (countFreshOrange == 0)
                return 0;
            if (q.isEmpty())
                return -1;

            int minutes = -1;
            int[][] dirs = {{1, 0},{-1, 0},{0, -1},{0, 1}};
            while (!q.isEmpty()) {
                int size = q.size();
                while (size > 0) {
                    int[] cell = q.poll();
                    int x = cell[0];
                    int y = cell[1];
                    for (int[] dir : dirs) {
                        int i = x + dir[0];
                        int j = y + dir[1];
                        if (i >= 0 && i < m && j >= 0 && j < n && visited[i][j] == 1) {
                            visited[i][j] = 2;
                            countFreshOrange--;
                            q.offer(new int[] {i, j});
                        }
                    }
                    --size;
                }
                minutes++;
            }

            if (countFreshOrange == 0)
                return minutes;
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(grid));
    }
}