class Solution {
    private int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int i=0; i<word1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, word1, word2);
    }

    private int dfs(int i, int j, String w1, String w2) {
        int n = w1.length(), m = w2.length();

        if (i == n) return m - j;
        if (j == m) return n - i;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int res = 0;

        if (w1.charAt(i) != w2.charAt(j)) {
            res = Math.min(dfs(i, j + 1, w1, w2), dfs(i + 1, j, w1, w2));
            res = Math.min(res, dfs(i + 1, j + 1, w1, w2));
            dp[i][j] = res + 1;
        } else {
            dp[i][j] = dfs(i + 1, j + 1, w1, w2);
        }

        return dp[i][j];
    }
}
