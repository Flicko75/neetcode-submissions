class Solution {
    private int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for (int i=0; i<s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, 0, s, t);
    }

    private int dfs(int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        }

        if (i == s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = dfs(i + 1, j, s, t);

        if (s.charAt(i) == t.charAt(j)) {
            ans += dfs(i + 1, j + 1, s, t);
        }

        dp[i][j] = ans;
        return ans;
    }
}
