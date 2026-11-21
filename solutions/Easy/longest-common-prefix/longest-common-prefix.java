class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        int minLength = strs[0].length();

        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        for (int charIndex = 0; charIndex < minLength; charIndex++) {
            char currentChar = strs[0].charAt(charIndex);

            for (int stringIndex = 1; stringIndex < strs.length; stringIndex++) {
                if (strs[stringIndex].charAt(charIndex) != currentChar) {
                    return prefix.toString();
                }
            }

            prefix.append(currentChar);
        }

        return prefix.toString();
    }
}