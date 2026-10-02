class Solution {
    int[] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        int res = 1;

        for (int i=0; i<n; i++) {
            res = Math.max(res, dfs(nums, i));
        }

        return res;
    }

    private int dfs(int[] nums, int i) {
        if (dp[i] != -1) return dp[i];

        int length = 1;

        for (int j=i+1; j<nums.length; j++) {
            if (nums[i] < nums[j]) {
                length = Math.max(length, 1 + dfs(nums, j));
            }
        }

        dp[i] = length;
        return length;
    }
}
