// 113. Path Sum II
// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

// Example 1:
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22

// Example 2:
// Input: root = [1,2,3], targetSum = 5
//Output: []

//Example 3:
// Input: root = [1,2], targetSum = 0
// Output: []

// Constraints:
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000

import java.util.*;

public class LeetCode113 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
//        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//            List<List<Integer>> res = new ArrayList<>();
//            List<Integer> current = new ArrayList<>();
//            int currentSum = 0;
//            findPathSums(root, targetSum, currentSum, current, res);
//            return res;
//        }
//
//        public void findPathSums(TreeNode root, int targetSum, int currentSum, List<Integer> current, List<List<Integer>> res) {
//            if (root == null) {
//                return;
//            }
//            currentSum += root.val;
//            current.add(root.val);
//
//            if (root.left == null && root.right == null && targetSum == currentSum) {
//                res.add(new ArrayList<>(current));
//            }
//
//            findPathSums(root.left, targetSum, currentSum, current, res);
//            findPathSums(root.right, targetSum, currentSum, current, res);
//            currentSum -= root.val;
//            current.remove(current.size() - 1);
//        }

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Stack<Object[]> stack = new Stack<>();
            List<Integer> currentInit = new ArrayList<>();
            currentInit.add(root.val);
            stack.push(new Object[]{root, root.val, currentInit});
            while (!stack.isEmpty()) {
                Object[] objects = stack.pop();
                TreeNode node = (TreeNode) objects[0];
                int currentSum = (int) objects[1];
                List<Integer> current = (List<Integer>) objects[2];

                if (node.left == null && node.right == null && currentSum == targetSum) {
                    res.add(new ArrayList<>(current));
                }
                if (node.left != null) {
                    List<Integer> newPath = new ArrayList<>(current);
                    newPath.add(node.left.val);
                    stack.push(new Object[]{node.left, currentSum + node.left.val, newPath});
                }
                if (node.right != null) {
                    List<Integer> newPath = new ArrayList<>(current);
                    newPath.add(node.right.val);
                    stack.push(new Object[]{node.right, currentSum + node.right.val, newPath});
                }
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Integer[] arr = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = buildTree(arr);
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.pathSum(root, 22);
        for (List<Integer> list : ans) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    // =====================================================================================================================
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}