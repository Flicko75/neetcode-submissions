class Solution {
    int[] dp;

    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(climb(cost, 0), climb(cost, 1));
    }

    private int climb(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = cost[i] + Math.min(climb(cost, i + 1), climb(cost, i + 2));

        return dp[i];
    }
}
