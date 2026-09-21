class Solution {
    private int ROW, COL;
    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public void solve(char[][] board) {
        ROW = board.length;
        COL = board[0].length;

        for (int c=0; c<COL; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c, board);
            }
            if (board[ROW - 1][c] == 'O') {
                dfs(ROW - 1, c, board);
            }
        }

        for (int r=0; r<ROW; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }
            if (board[r][COL - 1] == 'O') {
                dfs(r, COL - 1, board);
            }
        }

        for (int r=0; r<ROW; r++) {
            for (int c=0; c<COL; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'V') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {
        board[row][col] = 'V';

        for (int[] dir : directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nc >= 0 && nr < ROW && nc < COL
                && board[nr][nc] == 'O') {
                    dfs(nr, nc, board);
                }
        }
    }
}
