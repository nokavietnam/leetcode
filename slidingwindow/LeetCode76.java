// 76. Minimum Window Substring
// Given two strings s and t of lengths m and n respectively,
// return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".
// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

// Constraints:
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.

// Follow up: Could you find an algorithm that runs in O(m + n) time?

public class LeetCode76 {
    static class Solution {
        // TC: O(n)
        // SP: O(n)
        public String minWindow(String s, String t) {
            int[] freqT = new int[58];
            for (int i = 0; i < t.length(); ++i) {
                ++freqT[t.charAt(i) - 'A'];
            }
            int minLength = Integer.MAX_VALUE;
            String ans = "";
            int left = 0;
            int n = s.length();
            int[] freqCurrent = new int[58];
            for (int right = 0; right < n; ++right) {
                ++freqCurrent[s.charAt(right) - 'A'];
                while (isContain(freqT, freqCurrent)) {
                    if (right - left + 1 < minLength) {
                        ans = s.substring(left, right + 1);
                        minLength = right - left + 1;
                    }
                    --freqCurrent[s.charAt(left) - 'A'];
                    ++left;
                }
            }
            return ans;
        }

        public boolean isContain(int[] freq, int[] s) {
            for (int i = 0; i < 58; ++i) {
                if (s[i] < freq[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println("result: " + solution.minWindow(s1, t1));
    }
}