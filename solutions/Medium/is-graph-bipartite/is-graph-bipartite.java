class Solution {
    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;
        for (int i = 0; i < graph[node].length; i++) {
            int neighbor = graph[node][i];
            if (color[neighbor] == -1) {
                if (dfs(neighbor, 1 - col, color, graph) == false) {
                    return false;
                } 
            } else if (color[neighbor] == col) {
                    return false;
                }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}