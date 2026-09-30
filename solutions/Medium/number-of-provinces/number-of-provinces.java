class Solution {
    private void dfs(int node,boolean[] visited, int[][] isConnected) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] != 0 && !visited[i]) {
                dfs(i, visited, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);

        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                count++;
                dfs(i, visited, isConnected);
            }
        }
        return count;
    }
}