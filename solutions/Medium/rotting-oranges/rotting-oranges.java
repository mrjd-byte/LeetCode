class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int fresh = 0;
        int minute = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }


        while (!q.isEmpty() && fresh > 0) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = row + dRow[dir];
                    int nextCol = col + dCol[dir];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        fresh--;
                        q.offer(new int[]{nextRow, nextCol});
                    }
                }

            }
            minute++;
        }
        if (fresh > 0) return -1;
        return minute;
    }
}