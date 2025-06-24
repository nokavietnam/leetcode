#  Trie



```java
class TrieNode {
    public TrieNode[] children = new TrieNode[N];
    boolean isEndOfWord;
}

// or 

public TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}
```