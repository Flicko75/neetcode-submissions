class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];

        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(amount, coins, 0);
    }

    private int dfs(int amt, int[] coins, int i) {
        if (amt == 0) {
            return 1;
        }

        if (i >= coins.length) {
            return 0;
        }

        if (dp[i][amt] != -1) {
            return dp[i][amt];
        }

        int ways = dfs(amt, coins, i + 1);

        if (amt >= coins[i]) {
            ways += dfs(amt - coins[i], coins, i);
        }

        dp[i][amt] = ways;

        return ways;
    }
}
