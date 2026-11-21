class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;

        int right = 0;
        int left = 0;
        while (left <= right && right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {
                while (set.contains(ch)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(ch);
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}