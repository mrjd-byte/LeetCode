class Solution {
    private int dfs(int[][] grid, int rows, int cols, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        return 1 + dfs(grid,rows, cols, i - 1, j) + dfs(grid,rows, cols, i + 1, j) + dfs(grid,rows, cols, i, j - 1) + dfs(grid,rows, cols, i, j + 1);

    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    int area = dfs(grid,rows, cols, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        if (maxArea == Integer.MIN_VALUE) {
            return 0;
        }
        return maxArea;
    }
}