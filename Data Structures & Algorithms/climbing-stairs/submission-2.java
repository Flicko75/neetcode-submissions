class Solution {
    int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return climb(n);
    }

    private int climb(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = climb(n - 1) + climb(n - 2);

        return dp[n];
    }
}
