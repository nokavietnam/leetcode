package com.hoclamdev.arrayandhashing;

/*
347. Top K Frequent Elements
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]

Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

public class P347TopKFrequentElements {
//    private static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> counter = new HashMap<>();
//        for (int num : nums) {
//            counter.put(num, counter.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(
//                (a, b) -> Integer.compare(counter.get(b), counter.get(a))
//        );
//        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
//            queue.add(entry.getKey());
//        }
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = queue.poll();
//
//        }
//        return res;
//    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] order = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (order[entry.getValue()] == null) {
                order[entry.getValue()] = new ArrayList<>();
            }
            order[entry.getValue()].add(entry.getKey());
        }
        int j = 0;
        int[] result = new int[k];
        for (int i = nums.length; i >= 0 && j < k; --i) {
            if (order[i] != null && !order[i].isEmpty()) {
                for (int num : order[i]) {
                    result[j++] = num;
                    if (j == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}

/*
Complexity
Time Complexity: N + N + N * number(but It so small may be skip => O(N)
Space Complexity: O(N)
 */
