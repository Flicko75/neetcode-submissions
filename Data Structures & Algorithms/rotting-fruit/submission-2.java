class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int ROW = grid.length;
        int COL = grid[0].length;
        int fresh = 0;

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COL; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) return 0;

        int min = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i=0; i<size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < ROW && nc < COL &&
                        grid[nr][nc] == 1) {
                            grid[nr][nc] += 1;
                            q.offer(new int[]{nr, nc});
                        }
                }
            }

            if (!q.isEmpty()) {
                min++;
            }
        }

        for (int i=0; i<ROW; i++) {
            for (int j=0; j<COL; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return min;
    }
}
