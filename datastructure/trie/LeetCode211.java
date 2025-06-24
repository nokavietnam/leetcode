package trie;
// 211. Design Add and Search Words Data Structure

// Design a data structure that supports adding new words and finding if a string matches any previously added string.
// Implement the WordDictionary class:
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

// Example:
// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True

// Constraints:
//        1 <= word.length <= 25
// word in addWord consists of lowercase English letters.
// word in search consist of '.' or lowercase English letters.
// There will be at most 2 dots in word for search queries.
// At most 104 calls will be made to addWord and search.

public class LeetCode211 {

    static class WordDictionary {

        public class Node {
            boolean isEndOfWord;
            Node[] children;
            public Node() {
                isEndOfWord = false;
                children = new Node[26];
            }
        }

        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node current = root;
            for (char ch : word.toCharArray()) {
                if (current.children[ch - 'a'] == null) {
                    current.children[ch - 'a'] = new Node();
                }
                current = current.children[ch - 'a'];
            }
            current.isEndOfWord = true;
        }

        public boolean dfs(Node current, char[] word, int n, int idx) {
            if (current == null) {
                return false;
            }
            if (idx == n) {
                return current.isEndOfWord;
            }
            if (word[idx] != '.') {
                return dfs(current.children[word[idx] - 'a'], word, n, idx + 1);
            }
            for (int i = 0; i < 26; ++i) {
                if (dfs(current.children[i], word, n, idx + 1)) {
                    return true;
                }
            }
            return false;
        }

        public boolean search(String word) {
            return dfs(root, word.toCharArray(), word.length(), 0);
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}