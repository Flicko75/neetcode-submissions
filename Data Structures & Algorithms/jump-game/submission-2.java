class Solution {
    HashMap<Integer, Boolean> dp;
    public boolean canJump(int[] nums) {
        dp = new HashMap<>();
        return explore(nums, 0);
    }

    private boolean explore(int[] nums, int i) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        if (i == nums.length - 1) {
            return true;
        }

        if (i >= nums.length || nums[i] == 0) {
            return false;
        }

        for (int j=1; j<=nums[i]; j++) {
            if (explore(nums, i + j)) {
                dp.put(i, true);
                return true;
            }
        }

        dp.put(i, false);
        return false;
    }
}
