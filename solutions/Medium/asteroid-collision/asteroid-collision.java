class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length == 0) {return new int[] {};};
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && num < 0 && stack.peek() < Math.abs(num)) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() > 0 && num < 0 && stack.peek() == Math.abs(num)) {
                stack.pop();
            } 
            else if (stack.isEmpty() || stack.peek() < 0 || num > 0) {
                stack.push(num);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }
}