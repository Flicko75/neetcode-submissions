class Solution {
    private int ROW, COL;
    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        boolean[][] pacific = new boolean[ROW][COL];
        boolean[][] atlantic = new boolean[ROW][COL];
        List<List<Integer>> res = new ArrayList<>();
        
        for (int c=0; c<COL; c++) {
            dfs(0, c, heights, pacific);
            dfs(ROW - 1, c, heights, atlantic);
        }

        for (int r=0; r<ROW; r++) {
            dfs(r, 0, heights, pacific);
            dfs(r, COL - 1, heights, atlantic);
        }

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COL; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean) {
        ocean[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < ROW && nc < COL &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    dfs(nr, nc, heights, ocean);
                }
        }
    }
}
