class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put (c, new TrieNode());
            }

            temp = temp.children.get(c);
        }

        temp.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, TrieNode root) {
        TrieNode temp = root;

        for (int j=idx; j<word.length(); j++) {
            char c = word.charAt(j);

            if (c == '.') {
                for (TrieNode child : temp.children.values()) {
                    if (child != null && dfs(word, j + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!temp.children.containsKey(c)) {
                    return false;
                }
                temp = temp.children.get(c);
            }
        }
        return temp.isWord;
    }
}
