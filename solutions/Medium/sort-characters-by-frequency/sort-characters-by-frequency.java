class Solution {
    class Pair {
        public Character ch;
        public int freq;

        Pair(Character ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String frequencySort(String s) {
        StringBuilder ans = new StringBuilder();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            for (int i = 0; i < pair.freq; i++) {
                ans.append(pair.ch);
            }
        }

        return ans.toString();

    }
}