class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], answer = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            int curr = nums[i];

            int oldMax = max;
            int oldMin = min;

            max = Math.max(curr, Math.max(curr * oldMax, curr * oldMin));
            min = Math.min(curr, Math.min(curr * oldMax, curr * oldMin));

            answer = Math.max(answer, max);
        }

        return answer;
    }
}
