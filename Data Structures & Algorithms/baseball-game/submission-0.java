class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        if (operations.length == 0) return 0;
        int sum = 0;

        for (String c : operations){
            if (c.equals("+")){
                int a = stack.pop();
                int b = stack.peek();
                stack.push(a);
                stack.push(a + b);
            }
            else if (c.equals("C")){
                stack.pop();
            }
            else if (c.equals("D")){
                stack.push(stack.peek() * 2);
            }
            else {
                stack.push(Integer.parseInt(c));
            }
        }

        sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}