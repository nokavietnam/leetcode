//210. Course Schedule II
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
// You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return the ordering of courses you should take to finish all courses. If there are many valid answers,
// return any of them. If it is impossible to finish all courses, return an empty array.

//Example 1:
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

//Example 2:
//Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//Output: [0,2,1,3]
//Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
//So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

//Example 3:
//Input: numCourses = 1, prerequisites = []
//Output: [0]

//Constraints:
//1 <= numCourses <= 2000
//0 <= prerequisites.length <= numCourses * (numCourses - 1)
//prerequisites[i].length == 2
//0 <= ai, bi < numCourses
//ai != bi
//All the pairs [ai, bi] are distinct.

import java.util.*;

public class LeetCode210 {
    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] res = new int[numCourses];
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                adj.add(new ArrayList<>());
            }
            for (int[] edge : prerequisites) {
                adj.get(edge[1]).add(edge[0]);
            }
            int[] visited = new int[numCourses];
            List<Integer> stack = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                if (visited[i] == 0) {
                    if (!dfs(i, adj, visited, stack)) { // cycle
                        return new int[] {};
                    }
                }
            }
            int i = numCourses - 1;
            for (int item : stack) {
                res[i] = item;
                --i;
            }
            return res;
        }

        public boolean dfs(int node, List<List<Integer>> adj, int[] visited, List<Integer> stack) {
            visited[node] = 1;
            for (int neighbor : adj.get(node)) {
                if (visited[neighbor] == 1) {
                    return false; // cycle detected
                }
                if ((visited[neighbor] == 0) && !dfs(neighbor, adj, visited, stack)) {
                    return false; // cycle in deeper recursion
                }
            }
            visited[node] = 2; // mark as visited
            stack.add(node);
            return true;
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        Solution solution = new Solution();
        int[] ans = solution.findOrder(numCourses, prerequisites);
        for (int item : ans) {
            System.out.print(item + " ");
        }
    }
}