package com.hoclamdev.arrayandhashing;

/*
* 242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
* An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
* */

import java.util.HashMap;
import java.util.Map;

public class P242ValidAnagram {

//    public boolean isAnagram(String s, String t) {
//        int[] counter = new int[26];
//        for (char ch : s.toCharArray()) {
//            counter[ch - 'a']++;
//        }
//        for (char ch : t.toCharArray()) {
//            counter[ch - 'a']--;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (counter[i] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    private static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch,0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println("Result: " + isAnagram(s, t));
    }
}

/*
Complexity:
Time Complexity: O(N)
Space Complexity: O(N)
 */
