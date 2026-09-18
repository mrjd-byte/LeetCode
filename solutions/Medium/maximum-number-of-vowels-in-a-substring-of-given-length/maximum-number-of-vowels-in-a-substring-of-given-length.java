class Solution {
    public boolean isVow(char ch) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char c : vowels) {
            if (ch == c) {
                return true;
            }
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int maxCount = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            if (isVow(ch)) {
                count++;
            }
            while (right - left + 1> k) {
                if (isVow(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, count);
            right++;
        }
        return maxCount;
    }
}