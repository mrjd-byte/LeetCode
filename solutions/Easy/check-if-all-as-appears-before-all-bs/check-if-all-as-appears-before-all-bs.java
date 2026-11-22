class Solution {
    public boolean checkString(String s) {
        int bIndex = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bIndex = i;
            } else {
                if (i > bIndex) {
                    return false;
                }
            }
        }
        return true;
    }
}