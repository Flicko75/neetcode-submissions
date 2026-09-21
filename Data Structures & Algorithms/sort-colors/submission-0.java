class Solution {
    public void sortColors(int[] nums) {
        MS(nums, 0, nums.length - 1);
    }

    public void MS(int[] nums, int start, int end){
        if (start < end){
            int mid = start + (end - start) / 2;
            MS(nums, start, mid);
            MS(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] nums, int start, int mid, int end){
        int i = start;
        int j = mid + 1;
        int k = start;
        int[] B = new int[end + 1];

        while (i <= mid && j <= end){
            if (nums[i] < nums[j]){
                B[k++] = nums[i++];
            }
            else {
                B[k++] = nums[j++];
            }
        }

        for (; i<=mid; i++){
            B[k++] = nums[i];
        }

        for (; j<=end; j++){
            B[k++] = nums[j];
        }

        for (i=start; i<=end; i++){
            nums[i] = B[i]; 
        }
    }
}