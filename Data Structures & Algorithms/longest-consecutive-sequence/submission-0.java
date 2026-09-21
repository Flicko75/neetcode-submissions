class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            if (!set.contains(n)) set.add(n);
        }
        
        int max = 0;

        for (int i=0; i<nums.length; i++){
            int len = 0;
            int curr = nums[i];
            if (!set.contains(curr - 1)){
                while (set.contains(curr + 1)){
                    curr++;
                    len++;
                }
            }
            max = Math.max(max, len + 1);
        }

        return max;
    }
}
