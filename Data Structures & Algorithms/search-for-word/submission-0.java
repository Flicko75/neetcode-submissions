class Solution {

    private int ROW, COL;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;

        visited = new boolean[ROW][COL];

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COL; j++) {
                if (dfs(i, j, 0, word, board)) return true;
            }
        }

        return false;
    }

    private boolean dfs(int row, int col, int idx, String word, char[][] board) {
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= ROW || col >= COL ||
            board[row][col] != word.charAt(idx) ||
            visited[row][col]) {
                return false;
        }

        visited[row][col] = true;

        boolean res = dfs(row - 1, col, idx + 1, word, board) ||
                    dfs(row + 1, col, idx + 1, word, board) ||
                    dfs(row, col - 1, idx + 1, word, board) ||
                    dfs(row, col + 1, idx + 1, word, board);

        visited[row][col] = false;

        return res;
    }
}
