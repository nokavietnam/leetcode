// 78. Subsets
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
//
// Example 1:
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//
// Example 2:
// Input: nums = [0]
// Output: [[],[0]]
//
// Constraints:
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// All the numbers of nums are unique.
import java.util.*;

public class LeetCode78 {

    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> chosenCandidates = new ArrayList<>();
            ans.add(new ArrayList<>(chosenCandidates));
            dfs(0, n, nums, chosenCandidates, ans);
            return ans;
        }

        public void dfs(int idx, int n, int[] nums, List<Integer> chosenCandidates, List<List<Integer>> ans) {
            if (idx == n) {
                return;
            }
            chosenCandidates.add(nums[idx]);
            ans.add(new ArrayList<>(chosenCandidates));
            dfs(idx + 1, n, nums, chosenCandidates, ans);
            chosenCandidates.remove(chosenCandidates.size() - 1);
            dfs(idx + 1, n, nums, chosenCandidates, ans);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> ans = solution.subsets(nums);
        for (List<Integer> list : ans) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}