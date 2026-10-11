class Solution {
    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        dp = new int[r][c];

        for (int i=0; i<r; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                ans = Math.max(ans, dfs(i, j, matrix));
            }
        }

        return ans;
    }

    private int dfs(int r, int c, int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;

        if (r < 0 || r >= row ||
            c < 0 || c >= col) {
                return 0;
            }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int max = 1;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < row &&
                nc >= 0 && nc < col &&
                matrix[nr][nc] > matrix[r][c]) {
                    max = Math.max(1 + dfs(nr, nc, matrix), max);
                }
        }

        dp[r][c] = max;
        return max;
    }
}
