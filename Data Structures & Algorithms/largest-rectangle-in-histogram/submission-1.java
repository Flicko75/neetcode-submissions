class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i=0; i<heights.length; i++){
            while (!stack.isEmpty() &&
                heights[stack.peek()] > heights[i]){
                    int popped = stack.pop();
                    int height = heights[popped];
                    int right = i - 1;
                    int left = 0;

                    if (stack.isEmpty())
                        left = 0;
                    else
                        left = stack.peek() + 1;
                    
                    int area = height * (right - left + 1);
                    maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()){
            int popped = stack.pop();
            int height = heights[popped];
            int right = heights.length - 1;
            int left = 0;

            if (stack.isEmpty())
                left = 0;
            else 
                left = stack.peek() + 1;
            
            int area = height * (right - left + 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
