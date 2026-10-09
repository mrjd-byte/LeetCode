class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int minutes = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        while (!queue.isEmpty() && freshOranges > 0) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = row + dRow[dir];
                    int nextCol = col + dCol[dir];

                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        freshOranges--;
                        queue.offer(new int[] { nextRow, nextCol });
                    }
                }
            }
            minutes++;
        }
        if (freshOranges > 0) {
            return -1;
        }
        return minutes;
    }
}
