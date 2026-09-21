class Solution {
    private boolean[][] visited;
    private int ROW, COL;

    public int numIslands(char[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        visited = new boolean[ROW][COL];
        int count = 0;

        for (int r=0; r<ROW; r++) {
            for (int c=0; c<COL; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= ROW || c < 0 || c >= COL
            || visited[r][c] || grid[r][c] == '0') {
                return;
        }

        visited[r][c] = true;

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
