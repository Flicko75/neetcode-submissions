class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }        

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if (x > y) maxHeap.offer(x - y);
            else if (x < y) maxHeap.offer(y - x);
            else continue;
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
