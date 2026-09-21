class MedianFinder {

    private Queue<Integer> left;
    private Queue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> b - a);
        right = new PriorityQueue<>((a,b) -> a - b);        
    }
    
    public void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()){
            left.offer(num);
        } else {
            right.offer(num);
        }

        if (left.size() - right.size() > 1){
            right.offer(left.poll());
        }
        if (right.size() - left.size() > 1){
            left.offer(right.poll());
        }
    }
    
    public double findMedian() {
        if (left.size() == right.size()){
            return (double) (left.peek() + right.peek()) / 2;
        } else if (left.size() > right.size()){
            return (double) left.peek();
        } else {
            return (double) right.peek();
        }
    }
}
