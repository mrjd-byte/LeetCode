class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int provinces = 0;

        for (int start = 0; start < n; start++) {
            if (visited[start] == 1) {
                continue;
            }

            provinces++;

            Queue<Integer> q = new LinkedList<>();

            visited[start] = 1;
            q.offer(start);

            while (!q.isEmpty()) {
                int city = q.poll();

                for (int nextCity = 0; nextCity < n; nextCity++) {
                    if (isConnected[city][nextCity] == 1 && visited[nextCity] == 0) {
                        visited[nextCity] = 1;
                        q.offer(nextCity);
                    }
                }
            }
        }

        return provinces;
    }
}