package com.hoclamdev.arrayandhashing;

/*
Encode and Decode Strings
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:
Input: ["neet","code","love","you"]
Output:["neet","code","love","you"]

Example 2:
Input: ["we","say",":","yes"]
Output: ["we","say",":","yes"]

Constraints:
0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P271EncodeAndDecodeStrings {
    private static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    private static List<String> decode(String str) {
        if (str == null || str.isEmpty()) {
            return new ArrayList<>();
        }
        int n = str.length();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n;){
            int j = i;
            StringBuilder strLength = new StringBuilder();
            while (j < n && str.charAt(j) != '#') {
               strLength.append(str.charAt(j));
               ++j;
            }
            int length = Integer.parseInt(strLength.toString());
            String item = str.substring(i + strLength.length() + 1, i + strLength.length() + 1 + length);
            result.add(item);
            i += length + strLength.length() + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("we","say",":","yes","!@#$%^&*()");
        System.out.println("Input: " + input);
        String encodeString = encode(input);
        System.out.println("strings encode: " + encodeString);
        List<String> decodeStrings = decode(encodeString);
        System.out.println("Decoded Strings: " + decodeStrings);
    }
}

/*
Complexity:
Time Complexity: O(N)
Space Complexity: O(N)
 */