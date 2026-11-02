class Solution {
    private boolean isCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] inPath) {
        visited[node] = true;
        inPath[node] = true;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == false) {
                if (isCycle(neighbor, adj, visited, inPath)) {
                    return true;
                }
            } else if (inPath[neighbor] == true) {
                return true;
            }
        }
        inPath[node] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == false) {
                if (isCycle(i, adj, visited, inPath)) {
                    return false;
                }
            }
        }
        return true;
    }
}