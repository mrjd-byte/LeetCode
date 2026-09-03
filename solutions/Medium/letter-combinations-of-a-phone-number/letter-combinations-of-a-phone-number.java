class Solution {
    public final String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void helper(String digits, int index, String current, List<String> res) {
        if (index == digits.length()) {
            res.add(current);
            return;
        }

        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            helper(digits, index + 1, current + s.charAt(i), res);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        helper(digits, 0, "", res);
        return res;
    }
    
}