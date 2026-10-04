class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;

        dp = new Boolean[nums.length][sum/2 + 1];

        return dfs(nums, 0, sum/2);
    }

    private boolean dfs(int[] nums, int i, int target) {
        if (i == nums.length) {
            return target == 0;
        }

        if (target < 0) {
            return false;
        }

        if (dp[i][target] != null) {
            return dp[i][target];
        }

        dp[i][target] = dfs(nums, i+1, target) ||
                        dfs(nums, i+1, target - nums[i]);
        
        return dp[i][target];
    }
}
