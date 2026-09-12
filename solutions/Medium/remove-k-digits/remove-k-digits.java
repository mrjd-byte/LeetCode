class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && k > 0 && (num.charAt(i)) < (stack.peek())) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        while (ans.length() > 0 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        ans.reverse();

        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();
    }
}