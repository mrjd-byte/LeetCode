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
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.get(ch) > 0) {
                Pair pair = new Pair(ch, map.get(ch));
                // System.out.println(pair.ch);
                // System.out.println(pair.freq);
                maxHeap.offer(pair);
                map.put(ch, -1);
            }
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