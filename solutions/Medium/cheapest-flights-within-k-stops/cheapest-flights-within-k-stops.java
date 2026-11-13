class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjacency = new ArrayList<>();

        for (int city = 0; city < n; city++) {
            adjacency.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adjacency.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int maxFlights = k + 1;

        int[][] best = new int[maxFlights + 1][n];

        for (int used = 0; used <= maxFlights; used++) {
            Arrays.fill(best[used], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        best[0][src] = 0;
        minHeap.offer(new int[]{0, src, 0});

        while (!minHeap.isEmpty()) {
            int[] state = minHeap.poll();

            int cost = state[0];
            int city = state[1];
            int used = state[2];

            if (cost != best[used][city]) {
                continue;
            }

            if (city == dst) {
                return cost;
            }

            if (used == maxFlights) {
                continue;
            }

            for (int[] edge : adjacency.get(city)) {
                int neighbor = edge[0];
                int price = edge[1];

                int nextUsed = used + 1;
                int nextCost = cost + price;

                if (nextCost < best[nextUsed][neighbor]) {
                    best[nextUsed][neighbor] = nextCost;
                    minHeap.offer(new int[]{nextCost, neighbor, nextUsed});
                }
            }
        }

        return -1;
    }
}