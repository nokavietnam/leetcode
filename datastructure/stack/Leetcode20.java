// 20. Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

//Example 1:
//Input: s = "()"
//Output: true

//Example 2:
//Input: s = "()[]{}"
//Output: true

//Example 3:
//Input: s = "(]"
//Output: false

//Example 4:
//Input: s = "([])"
//Output: true

//Constraints:
//1 <= s.length <= 104
//s consists of parentheses only '()[]{}'.

package stack;

import java.util.*;

public class Leetcode20 {
    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.add(ch);
                    continue;
                }
                if (stack.isEmpty())
                    return false;

                char last = stack.pop();
                if (!isPair(last, ch)) {
                    return false;
                }
            }
            return stack.isEmpty();
        }

        private boolean isPair(char last, char cur) {
            return (last == '(' && cur == ')') || (last == '[' && cur == ']') || (last == '{' && cur == '}');
        }
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}