// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without duplicate characters.

// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.

// Example 2:
// Input: s = "bbbbb"
// Output: 1
//Explanation: The answer is "b", with the length of 1.

// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

// Constraints:
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
import java.lang.Math;
import java.util.*;

public class LeetCode3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int begin = 0;
            int maxLength = 0;
            HashSet<Character> charSet = new HashSet<>();
            for (int end = 0; end < n; ++end) {
                while (charSet.contains(s.charAt(end))) {
                    charSet.remove(s.charAt(begin));
                    ++begin;
                }
                charSet.add(s.charAt(end));
                maxLength = Math.max(maxLength, end - begin + 1);
            }
            return maxLength;
        }
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        String s1 = "abcabcbb", s2 = "bbbbb", s3 = "pwwkew";
        Solution solution = new Solution();
        System.out.println("Test case 1: " + (solution.lengthOfLongestSubstring(s1) == 3 ? ANSI_GREEN + "passed" : ANSI_RED + "failed") + ANSI_RESET);
        System.out.println("Test case 2: " + (solution.lengthOfLongestSubstring(s2) == 1 ? ANSI_GREEN + "passed" : ANSI_RED + "failed") + ANSI_RESET);
        System.out.println("Test case 3: " + (solution.lengthOfLongestSubstring(s3) == 3 ? ANSI_GREEN + "passed" : ANSI_RED + "failed") + ANSI_RESET);
    }
}