class Solution {
    private int ROW, COL;
    private static int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        ROW = grid.length;
        COL = grid[0].length;
        int maxArea = 0;

        for (int r=0; r<ROW; r++) {
            for (int c=0; c<COL; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= ROW || c >= COL ||
            grid[r][c] == 0) {
                return 0;
        }

        grid[r][c] = 0;

        int area = 1;
        for (int[] dir : directions) {
            area += dfs(grid, r + dir[0], c + dir[1]);
        }

        return area;
    }
}
