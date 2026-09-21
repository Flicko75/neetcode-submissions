class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );

        for (int[] p : points){
            int dist = (p[0] * p[0]) + (p[1] * p[1]);
            queue.offer(new int[]{dist, p[0], p[1]});
        }

        int[][] res = new int[k][2];
        for (int i=0; i<k; i++){
            int[] arr = queue.poll();
            res[i][0] = arr[1];
            res[i][1] = arr[2];
        }

        return res;
    }
}
