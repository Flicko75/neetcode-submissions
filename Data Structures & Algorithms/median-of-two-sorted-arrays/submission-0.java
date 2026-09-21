class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int count = 0;

        int i = 0;
        int j = 0;

        int curr = 0;
        int prev = 0;

        while (count <= (total / 2)){
            prev = curr;

            if (i >= m){
                curr = nums2[j];
                j++;
            }       
            else if (j >= n){
                curr = nums1[i];
                i++;
            }     
            else if (nums1[i] < nums2[j]){
                curr = nums1[i];
                i++;
            }
            else {
                curr = nums2[j];
                j++;
            }

            count++;
        }

        if (total % 2 == 1)
            return curr;
        return (prev + curr) / 2.0;
    }
}
