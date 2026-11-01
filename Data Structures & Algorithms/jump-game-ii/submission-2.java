class Solution {
    Map<Integer, Integer> dp;

    public int jump(int[] nums) {
        dp = new HashMap<>();
        return dfs(nums, 0);
    }

    private int dfs(int[] nums, int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        if (i == nums.length - 1) {
            return 0;
        }

        if (nums[i] == 0) {
            return 10000;
        }

        int res = 10000;

        for (int j=1; j<=nums[i] && i+j < nums.length; j++) {
            res = Math.min(res, 1 + dfs(nums, i + j));
        }
        
        dp.put(i, res);
        return res;
    }
}
