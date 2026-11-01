class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, reach = 0;

        for (int i=0; i<n-1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (nums[i] == 0 && reach <= i) {
                return false;
            }
        }

        return true;
    }
}
