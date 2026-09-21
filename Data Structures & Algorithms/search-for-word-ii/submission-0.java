class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isWord;

    TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void insert(String word) {
        TrieNode curr = this;

        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}

class Solution {

    private int ROW, COL;
    private boolean[][] visited;
    private Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.insert(word);
        }

        ROW = board.length;
        COL = board[0].length;
        visited = new boolean[ROW][COL];
        res = new HashSet<>();

        for (int r=0; r<ROW; r++) {
            for (int c=0; c<COL; c++) {
                dfs(r, c, board, root, "");
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(int row, int col, char[][] board, TrieNode root, String word) {
        if (row < 0 || col < 0 || row >= ROW || col >= COL 
            || visited[row][col] || !root.children.containsKey(board[row][col])) {
                return;
        }

        visited[row][col] = true;
        word += board[row][col];
        root = root.children.get(board[row][col]);
        if (root.isWord) {
            res.add(word);
        }

        dfs(row + 1, col, board, root, word);
        dfs(row - 1, col, board, root, word);
        dfs(row, col + 1, board, root, word);
        dfs(row, col - 1, board, root, word);

        visited[row][col] = false;
    }
}
