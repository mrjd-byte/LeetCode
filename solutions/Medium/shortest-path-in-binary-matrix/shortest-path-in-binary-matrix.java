class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        int[][] directions = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        queue.add(new int[] { 0, 0, 1 });
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int distance = curr[2];

            if (row == n - 1 && col == n - 1) {
                return distance;
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];

                if (nr >= 0 && nr < n &&
                        nc >= 0 && nc < n &&
                        grid[nr][nc] == 0 &&
                        !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.add(new int[] { nr, nc, distance + 1 });
                }
            }
        }

        return -1;
    }
}