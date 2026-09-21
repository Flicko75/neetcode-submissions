class MedianFinder {

    PriorityQueue<Integer> leftHalf;
    PriorityQueue<Integer> rightHalf;

    public MedianFinder() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (leftHalf.isEmpty() || leftHalf.peek() >= num) {
            leftHalf.offer(num);
        } else {
            rightHalf.offer(num);
        }

        if (leftHalf.size() - rightHalf.size() > 1) {
            rightHalf.offer(leftHalf.poll());
        }
        if (rightHalf.size() - leftHalf.size() > 1) {
            leftHalf.offer(rightHalf.poll());
        }
    }
    
    public double findMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (double) (leftHalf.peek() + rightHalf.peek()) / 2;
        } else if (leftHalf.size() > rightHalf.size()) {
            return (double) leftHalf.peek();
        } else {
            return (double) rightHalf.peek();
        }
    }
}
