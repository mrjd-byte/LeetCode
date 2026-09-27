class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                StringBuffer ans = new StringBuffer();
                while (stack.peek() != '(') {
                    ans.append(stack.pop());
                }
                stack.pop();
                for (int j = 0; j < ans.length(); j++) {
                    stack.push(ans.charAt(j));
                }
            } else {
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}