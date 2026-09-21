class MinStack {
    private Stack<Integer> main;
    private Stack<Integer> minStack;

    public MinStack() {
        main = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        main.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int removed = main.pop();
        if (minStack.peek() == removed){
            minStack.pop();
        }
    }
    
    public int top() {
        return main.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
