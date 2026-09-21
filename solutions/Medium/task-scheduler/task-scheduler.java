class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }    
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        maxHeap.addAll(freq.values());

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }
            for (int frq : temp) {
                if (--frq > 0) {
                    maxHeap.add(frq);
                }
            }
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return time;
    }
}