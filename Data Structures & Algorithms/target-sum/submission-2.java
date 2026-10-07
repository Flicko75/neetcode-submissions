class Solution {
    int[][] dp;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        total = 0;

        for (int i=0; i<n; i++) total += nums[i];

        dp = new int[n][2 * total + 1];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(nums, target, 0, 0);
    }

    private int dfs(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (sum == target) return 1;
            else return 0;
        }

        if (dp[i][sum + total] != -1) {
            return dp[i][sum + total];
        }

        dp[i][sum + total] = dfs(nums, target, sum - nums[i], i + 1) 
                + dfs(nums, target, sum + nums[i], i + 1);

        return dp[i][sum + total];
    }
}
