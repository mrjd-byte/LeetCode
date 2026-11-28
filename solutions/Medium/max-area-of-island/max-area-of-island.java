class Solution {
    private int dfs(int[][] grid, int rows, int cols, int i, int j, int area) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        area += dfs(grid,rows, cols, i - 1, j, 1);
        area += dfs(grid,rows, cols, i + 1, j, 1);
        area += dfs(grid,rows, cols, i, j - 1, 1);
        area += dfs(grid,rows, cols, i, j + 1, 1);

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    System.out.println(i);
                    System.out.println(j);
                    int area = dfs(grid,rows, cols, i, j, 1);
                    System.out.println("area:" + area);
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