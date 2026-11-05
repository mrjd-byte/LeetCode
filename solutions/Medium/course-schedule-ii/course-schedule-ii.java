class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] topo = new int[numCourses];
        int i = 0;
        int processed = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[i++] = node;
            processed++;

            for(int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.offer(it);
                }
            }
        }

        if (processed != numCourses) {
            return new int[] {};
        }
        return topo;    
    }
}