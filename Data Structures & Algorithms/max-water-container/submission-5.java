class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            maxArea = Math.max(area, maxArea);

            if (heights[r] <= heights[l]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }
}
