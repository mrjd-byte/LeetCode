class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        String s2 = goal + goal;
        return s2.contains(s);
    }
}