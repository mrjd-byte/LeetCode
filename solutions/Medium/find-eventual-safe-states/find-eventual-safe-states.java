class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vertices = graph.length;
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[vertices];

        for (int node = 0; node < vertices; node++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int node = 0; node < vertices; node++) {
            outdegree[node] = graph[node].length;
            for (int neighbor : graph[node]) {
                reverseGraph.get(neighbor).add(node);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int node = 0; node < vertices; node++) {
            if (outdegree[node] == 0) {
                q.offer(node);
            }
        }

        ArrayList<Integer> safe = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            safe.add(node);

            for (int predecessor : reverseGraph.get(node)) {
                outdegree[predecessor]--;
                if (outdegree[predecessor] == 0) {
                    q.offer(predecessor);
                }
            }
        }

        Collections.sort(safe);
        return safe;
    }
}
