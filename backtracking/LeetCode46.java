// 46. Permutations
// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
//
// Example 3:
// Input: nums = [1]
// Output: [[1]]
//
// Constraints:
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

import java.util.*;

public class LeetCode46 {
    static class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> chosenCandidates = new ArrayList<>();
            dfs(0, nums.length, nums, chosenCandidates, ans);
            return ans;
        }
        public void dfs(int idx, int n, int[] nums, List<Integer> chosenCandidates, List<List<Integer>> ans) {
            if (idx == n) {
                ans.add(new ArrayList<>(chosenCandidates));
                return;
            }
            for (int i = 0; i < n; ++i) {
                if (chosenCandidates.contains(nums[i])) {
                    continue;
                }
                chosenCandidates.add(nums[i]);
                dfs(idx + 1, n, nums, chosenCandidates, ans);
                chosenCandidates.remove(chosenCandidates.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 1, 2, 3 };
        List<List<Integer>> ans = solution.permute(nums1);
        for (List<Integer> list : ans) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}