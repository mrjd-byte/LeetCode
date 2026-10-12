class Solution {
    private void dfs(int i, int j, int m, int n, char[][] board, int[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] != 0 || board[i][j] != 'O') {
            return;
        }
        visited[i][j] = 1;
        dfs(i + 1, j, m, n, board, visited);
        dfs(i - 1, j, m, n, board, visited);
        dfs(i, j + 1, m, n, board, visited);
        dfs(i, j - 1, m, n, board, visited);
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (visited[i][0] == 0 && board[i][0] == 'O') {
                dfs(i, 0, m, n, board, visited);
            }
            if (visited[i][n - 1] == 0 && board[i][n - 1] == 'O') {
                dfs(i, n - 1, m, n, board, visited);
            }
        }

        for (int j = 0; j < n; j++) {
            if (visited[0][j] == 0 && board[0][j] == 'O') {
                dfs(0, j, m, n, board, visited);
            }
            if (visited[m - 1][j] == 0 && board[m - 1][j] == 'O') {
                dfs(m - 1, j, m, n, board, visited);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}