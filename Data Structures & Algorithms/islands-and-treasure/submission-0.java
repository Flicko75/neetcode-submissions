class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0) return;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r < 0 || c < 0 || r >= m || c >= n ||
                    grid[r][c] != Integer.MAX_VALUE) 
                    continue;
                
                queue.offer(new int[]{r, c});

                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
