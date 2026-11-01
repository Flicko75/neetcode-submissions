class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, reach = 0;

        for (int i=0; i<n; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (nums[i] == 0 && reach <= i) {
                break;
            }
        }

        return reach >= n - 1;
    }
}
