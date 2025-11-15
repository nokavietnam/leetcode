package com.hoclamdev.arrayandhashing;

/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore, its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:
Input: nums = [1,0,1,2]
Output: 3

Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

import java.util.HashSet;
import java.util.Set;

public class P128LongestConsecutiveSequence {
    private static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> setNums = new HashSet<>();
        for (int num : nums) {
            setNums.add(num);
        }
        int maxLength = 0;

        for (int num : setNums) {
            if (setNums.contains(num - 1)) {
                continue;
            }
            int count = 0;
            do {
                ++count;
            } while (setNums.contains(num + count));
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,3,7,2,5,8,4,6,0,1};
        System.out.println("Result: " + longestConsecutive(nums));
    }
}
