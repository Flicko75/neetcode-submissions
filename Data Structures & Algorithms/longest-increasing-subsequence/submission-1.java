class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i=1; i<nums.length; i++) {
            if (dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
            } else {
                int left = 0;
                int right = dp.size() - 1;

                while (left < right) {
                    int mid = left + (right - left) / 2;

                    if (dp.get(mid) < nums[i]) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }

                dp.set(left, nums[i]);
            }
        }

        return dp.size();
    }
}
