class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        int minString = strs[0].length();

        for (String str : strs) {
            minString = Math.min(str.length(), minString);
        }

        for (int i = 0; i < minString; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return ans.toString();
                }
            }
            ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
}