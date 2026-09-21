class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;

        int[] dq = new int[n]; 
        int front = 0;
        int back = 0;

        for (int i=0; i<n; i++){
            if (front < back && dq[front] == i - k)
                front++;
            
            while (front < back && nums[dq[back - 1]] < nums[i])
                back--;
            
            dq[back] = i;
            back++;

            if (i >= k - 1)
                res[idx++] = nums[dq[front]];
        }

        return res;
    }
}
