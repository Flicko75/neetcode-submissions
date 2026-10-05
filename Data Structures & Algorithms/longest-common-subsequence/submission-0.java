class Solution {
    int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        dp = new int[m][n];

        for (int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(text1, text2, 0, 0);
    }

    private int dfs(String t1, String t2, int i, int j) {
        if (i == t1.length() || j == t2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int LCS = 0;

        if (t1.charAt(i) == t2.charAt(j)) {
            LCS =  1 + dfs(t1, t2, i + 1, j + 1);
        }
        else {
            LCS =  Math.max(
                dfs(t1, t2, i, j + 1),
                dfs(t1, t2, i + 1, j)
            );
        }

        dp[i][j] = LCS;

        return LCS;
    }
}
