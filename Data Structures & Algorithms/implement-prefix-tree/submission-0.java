class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }

            temp = temp.children.get(c);
        }

        temp.isWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                return false;
            }

            temp = temp.children.get(c);
        }

        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;

        for (char c : prefix.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                return false;
            }

            temp = temp.children.get(c);
        }

        return true;
    }
}
