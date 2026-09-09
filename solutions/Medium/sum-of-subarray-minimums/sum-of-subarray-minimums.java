class Solution {
    private int[] findPse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }
        return ans;
    }

    private int[] findNse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) { //put = to handle the edge cases that is if duplicates
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] nse = findNse(arr);
        int[] pse = findPse(arr);

        long mod = (int)1e9 + 7;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            long freq = left * right;

            long val = (int) ((freq * arr[i]) % mod);

            sum = (sum + val) % mod;
        } 
        return (int) sum;
    }
}