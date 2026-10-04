class Solution {
    int[][] dp;
    int[][] directions;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int r=0; r<m; r++) {
            Arrays.fill(dp[r], -1);
        }

        directions = new int[][] {
            {0, 1},
            {1, 0}
        };

        return dfs(0, 0, m, n);
    }

    private int dfs(int r, int c, int m, int n) {
        if (r == m-1 && c == n-1) return 1;

        if (dp[r][c] != -1) return dp[r][c];

        int paths = 0;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n) {
                paths += dfs(nr, nc, m, n);
            }
        }

        dp[r][c] = paths;
        return paths;
    }
}
