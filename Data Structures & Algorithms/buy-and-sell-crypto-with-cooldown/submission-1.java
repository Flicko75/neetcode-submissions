class Solution {
    int[][] dp;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];

        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(prices, 0, 1);
    }

    private int dfs(int[] prices, int i, int canBuy) {
        if (i >= prices.length) return 0;

        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }

        int profit = 0;

        if (canBuy == 1) {
            profit = Math.max(
                dfs(prices, i + 1, canBuy - 1) - prices[i],
                dfs(prices, i + 1, canBuy)
            );
            dp[i][1] = profit;
        } else {
            profit = Math.max(
                dfs(prices, i + 2, canBuy + 1) + prices[i],
                dfs(prices, i + 1, canBuy)
            );
            dp[i][0] = profit;
        }

        return profit;
    }
}
