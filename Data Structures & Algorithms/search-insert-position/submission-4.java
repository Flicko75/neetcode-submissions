class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right){
            int mid = (left + right) / 2;

            if (target == nums[mid]){
                return mid;
            }
            else if (target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return left;
    }
}