class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int t = time[2];

            graph.get(u).add(new int[]{v, t});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        distance[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int node = curr[0];
            int time = curr[1];
            
            for (int[] nei : graph.get(node)) {
                int next = nei[0];
                int weight = nei[1];

                int newTime = time + weight;

                if (newTime < distance[next]) {
                    distance[next] = newTime;
                    pq.offer(new int[]{next, newTime});
                }
            }
        }

        int answer = 0;

        for (int i=1; i<=n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, distance[i]);
        }

        return answer;
    }
}
