class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int n : asteroids){
            boolean destroyed = false;

            while(!stack.isEmpty() && n<0 && stack.peek()>0){
                if (Math.abs(n) > stack.peek()){
                    stack.pop();
                    continue;
                }
                else if (Math.abs(n) == stack.peek()){
                    stack.pop();
                }
                destroyed = true;
                break;
            }

            if (!destroyed){
                stack.push(n);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        
        return res;
    }
}