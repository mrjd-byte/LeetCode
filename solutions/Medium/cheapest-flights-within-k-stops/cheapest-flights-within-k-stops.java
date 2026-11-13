class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];

            adjacencyList.get(from).add(new int[]{to, price});
        }

        int[] minFlights = new int[n];
        Arrays.fill(minFlights, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        minHeap.offer(new int[]{0, src, 0});

        while (!minHeap.isEmpty()) {

            int[] current = minHeap.poll();

            int currentCost = current[0];
            int currentCity = current[1];
            int flightsUsed = current[2];

            if (currentCity == dst) {
                return currentCost;
            }

            if (flightsUsed > k || flightsUsed >= minFlights[currentCity]) {
                continue;
            }

            minFlights[currentCity] = flightsUsed;

            for (int[] edge : adjacencyList.get(currentCity)) {

                int nextCity = edge[0];
                int ticketPrice = edge[1];

                minHeap.offer(new int[]{
                    currentCost + ticketPrice,
                    nextCity,
                    flightsUsed + 1
                });
            }
        }

        return -1;
    }
}