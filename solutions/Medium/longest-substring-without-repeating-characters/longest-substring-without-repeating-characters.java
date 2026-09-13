class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {return 0;}
        int[] arrHash = new int[256];
        Arrays.fill(arrHash, -1);
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length() && left <= right) {
            char ch = s.charAt(right);
            while (arrHash[ch] != -1) {
                arrHash[s.charAt(left)]--;
                left++;
            }
            arrHash[ch]++;
            maxLength = Math.max(right - left + 1, maxLength);
            right++;

        }
        return maxLength;
    }
}