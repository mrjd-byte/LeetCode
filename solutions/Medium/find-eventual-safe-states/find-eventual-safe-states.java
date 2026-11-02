class Solution {
    private boolean dfs(int node, int[] visited, int[] pathVisited,
        int[] safe, int[][] graph) {
        visited[node] = 1;
        pathVisited[node] = 1;

        for (int neighbor : graph[node]) {
            if (visited[neighbor] == 0) {
                if (!dfs(neighbor, visited, pathVisited, safe, graph)) {
                    return false;
                }
            }

            else if (pathVisited[neighbor] == 1) {
                return false;
            }

            else if (safe[neighbor] == 0) {
                return false;
            }
        }

        pathVisited[node] = 0;

        safe[node] = 1;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vertices = graph.length;

        int[] visited = new int[vertices];
        int[] pathVisited = new int[vertices];
        int[] safe = new int[vertices];

        for (int node = 0; node < vertices; node++) {
            if (visited[node] == 0) {
                dfs(node, visited, pathVisited, safe, graph);
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int node = 0; node < vertices; node++) {
            if (safe[node] == 1) {
                answer.add(node);
            }
        }
        return answer;
    }
}
