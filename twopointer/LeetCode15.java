// 15. 3Sum
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

// Example 1:
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation:
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:
// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:
// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

// Constraints:
// 3 <= nums.length <= 3000
// -105 <= nums[i] <= 105

package twopointer;

import java.util.*;

public class LeetCode15 {
    static class Solution {
        // TC: O(n^2)
        // SC: O(1) or O(k) if calculating result
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;

            for (int i = 0; i < n - 2; ++i) {
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                int sum = 0 - nums[i];
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int total = nums[left] + nums[right];
                    if (total < sum) {
                        ++left;
                        continue;
                    }
                    if (total > sum) {
                        --right;
                        continue;
                    }
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    ++left;
                    while (nums[left] == nums[left - 1] && left < right) {
                        ++left;
                    }

                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}