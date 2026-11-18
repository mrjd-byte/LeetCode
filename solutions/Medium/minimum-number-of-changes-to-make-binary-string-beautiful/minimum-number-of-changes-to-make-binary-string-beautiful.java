class Solution {
    public int minChanges(String s) {
        int count = 0;

        int i = 0;
        while (i < s.length() - 1) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);
            if (ch1 != ch2) {
                count++;
            }
            i += 2;
        } 
        return count;
    }
}