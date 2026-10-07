class Solution {
    private void dfs(int[][] image, int color, int initValue, int i, int j) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != initValue) {
            return;
        }
        image[i][j] = color;
        dfs(image, color, initValue, i + 1, j);
        dfs(image, color, initValue, i - 1, j);
        dfs(image, color, initValue, i, j + 1);
        dfs(image, color, initValue, i, j - 1);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int initValue = image[sr][sc];

        if (initValue == color)
            return image;

        dfs(image, color, initValue, sr, sc);

        return image;
    }
}