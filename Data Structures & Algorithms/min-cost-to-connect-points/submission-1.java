class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, 0});

        int res = 0;
        int count = 0;

        while (count < n) {
            int[] curr = pq.poll();

            int dist = curr[0];
            int node = curr[1];

            if (visited[node]) continue;

            visited[node] = true;
            count++;
            res += dist;

            for (int next=0; next<n; next++) {
                if (visited[next]) continue;

                int currDist = Math.abs(points[node][0] - points[next][0]) +
                    Math.abs(points[node][1] - points[next][1]);
                
                pq.offer(new int[]{currDist, next});
            }
        }

        return res;
    }
}
