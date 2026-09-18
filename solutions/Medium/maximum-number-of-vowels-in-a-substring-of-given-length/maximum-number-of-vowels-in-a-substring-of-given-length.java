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
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < k; i++) {
            if (isVow(s.charAt(i))) {
                ans++;
            }
        }
        int vowCnt = ans;
        for (int right = k; right < n; right++) {
            if (isVow(s.charAt(right))) {
                vowCnt++;
            }
            if (isVow(s.charAt(left))) {
                vowCnt--;
            }

        ans = Math.max(ans, vowCnt);  
        left++;
    }
    return ans;
}
}