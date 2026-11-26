class Solution {
    private void dfs(int[][] image, int color, int initColor, int i, int j) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != initColor) {
            return;
        }
        image[i][j] = color;
        dfs(image, color, initColor, i + 1, j);
        dfs(image, color, initColor, i - 1, j);
        dfs(image, color, initColor, i, j + 1);
        dfs(image, color, initColor, i, j - 1);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initColor = image[sr][sc];

        if (initColor == color) {
            return image;
        }
        dfs(image, color, initColor, sr, sc);
        return image;

    }
}