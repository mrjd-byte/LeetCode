class Solution {
    public int numberOfSubstrings(String s) {
        int[] trackCharacters ={-1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                trackCharacters[0] = i;
            } else if (ch == 'b') {
                trackCharacters[1] = i;
            } else {
	            trackCharacters[2] = i;
            }
            int minLength = Math.min(trackCharacters[0], Math.min(trackCharacters[1], trackCharacters[2]));
	        count += minLength + 1;
        }
        return count;
    }
}