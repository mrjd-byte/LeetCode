class Pair{
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        Set<String> set = new HashSet<String>();
        for (String word : wordList) {
            set.add(word);
        }
        set.remove(beginWord);
        if (!set.contains(endWord)) return 0;

        while(!queue.isEmpty()) {
            String word = queue.peek().first;
            int steps = queue.peek().second;
            queue.remove();
            if (word.equals(endWord)) {return steps;}

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replaceWord = new String(replacedCharArray);

                    if (set.contains(replaceWord)) {
                        set.remove(replaceWord);
                        queue.add(new Pair(replaceWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}