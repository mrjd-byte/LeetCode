class Solution {
    public int maxDepth(String s) {
        int ans = Integer.MIN_VALUE;
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
            ans = Math.max(cnt, ans);
        }
        return ans;
    }
}