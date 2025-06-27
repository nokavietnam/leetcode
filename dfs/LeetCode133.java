// 133. Clone Graph
// Given a reference of a node in a connected undirected graph.
// Return a deep copy (clone) of the graph.
// Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
//
// class Node {
//     public int val;
//     public List<Node> neighbors;
// }

// Test case format:
// For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on.
// The graph is represented in the test case using an adjacency list.
// An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
// The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

// Example 1:
// Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
// Output: [[2,4],[1,3],[2,4],[1,3]]
// Explanation: There are 4 nodes in the graph.
// 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
// 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
// 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
//
// Example 2:
// Input: adjList = [[]]
// Output: [[]]
// Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.

// Example 3:
// Input: adjList = []
// Output: []
// Explanation: This an empty graph, it does not have any nodes.
//
// Constraints:
// The number of nodes in the graph is in the range [0, 100].
// 1 <= Node.val <= 100
// Node.val is unique for each node.
// There are no repeated edges and no self-loops in the graph.
// The Graph is connected and all nodes can be visited starting from the given node.

import java.util.*;

public class LeetCode133 {
    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static class Solution {

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Map<Node, Node> visited = new HashMap<>();
            return clone(node, visited);
        }

        public Node clone(Node node, Map<Node, Node> visited) {
            if (visited.containsKey(node)) {
                return visited.get(node);
            }
            Node clone = new Node(node.val);
            visited.put(node, clone);
            for (Node neightbor : node.neighbors) {
                clone.neighbors.add(clone(neightbor, visited));
            }
            return clone;
        }
    }

    public static void main(String[] args) {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node root = convertAdjListToGraph(adjList);
        System.out.print("Input:  ");
        printGraph(root);
        System.out.print("\nOutput: ");
        Solution solution = new Solution();
        printGraph(solution.cloneGraph(root));
    }
    // ====================================================================

    public static void printGraph(Node root) {
        boolean[] visited = new boolean[101];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        visited[root.val] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.val + " ");
            for (Node neighbor : node.neighbors) {
                if (!visited[neighbor.val]) {
                    queue.offer(neighbor);
                    visited[neighbor.val] = true;
                }
            }
        }
    }

    public static Node convertAdjListToGraph(int[][] adjList) {
        // Create a map to store nodes by their value for quick lookup
        Map<Integer, Node> nodeMap = new HashMap<>();

        // Create all nodes first (1-based indexing)
        for (int i = 0; i < adjList.length; i++) {
            int val = i + 1;
            nodeMap.put(val, new Node(val));
        }

        // Connect nodes based on adjacency list
        for (int i = 0; i < adjList.length; i++) {
            int val = i + 1;
            Node currentNode = nodeMap.get(val);
            // Add neighbors from adjList
            for (int neighborVal : adjList[i]) {
                currentNode.neighbors.add(nodeMap.get(neighborVal));
            }
        }

        // Return the first node (or any node as per requirement)
        return nodeMap.get(1);
    }
}