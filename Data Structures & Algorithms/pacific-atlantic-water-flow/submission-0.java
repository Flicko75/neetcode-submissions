class Solution {
    private int ROW, COL;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROW = heights.length;
        COL = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COL; j++) {
                boolean[][] visited = new boolean[ROW][COL];
                boolean[] ocean = dfs(heights, i, j, visited);

                if (ocean[0] && ocean[1]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private boolean[] dfs(int[][] heights, int r, int c, boolean[][] visited) {
        boolean pacific = (r == 0 || c == 0);
        boolean atlantic = (r == ROW - 1 || c == COL - 1);

        visited[r][c] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 &&
                nr < ROW && nc < COL &&
                !visited[nr][nc] &&
                heights[nr][nc] <= heights[r][c]) {

                    boolean[] result = dfs(heights, nr, nc, visited);

                    pacific = pacific || result[0];
                    atlantic = atlantic || result[1];
                }
        }

        return new boolean[]{pacific, atlantic};
    }
}
