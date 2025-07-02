// 643. Maximum Average Subarray I
// You are given an integer array nums consisting of n elements, and an integer k.
//Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.

//Example 1:
//Input: nums = [1,12,-5,-6,50,3], k = 4
//Output: 12.75000
//Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

//Example 2:
//Input: nums = [5], k = 1
//Output: 5.00000

//Constraints:
//n == nums.length
//1 <= k <= n <= 105
//-104 <= nums[i] <= 104

public class LeetCode643 {
    static class Solution {
        // TC: O(n)
        // SC: O(1)
        public double findMaxAverage(int[] nums, int k) {
            int n = nums.length;
            int current = 0;
            for (int i = 0; i < k; ++i) {
                current += nums[i];
            }
            double max = current;
            for (int i = k; i < n; ++i) {
                current -= nums[i - k];
                current += nums[i];
                max = Math.max(current, max);
            }
            return max / k;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;
        Solution solution = new Solution();
        System.out.println("result: " + solution.findMaxAverage(nums, k));
    }
}