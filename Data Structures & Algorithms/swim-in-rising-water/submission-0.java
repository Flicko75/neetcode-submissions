class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == n - 1 && c == n - 1) {
                return time;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n 
                    && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        int currTime = Math.max(time, grid[nr][nc]);
                        pq.offer(new int[]{currTime, nr, nc});
                    }
            }
        }

        return 0;
    }
}
