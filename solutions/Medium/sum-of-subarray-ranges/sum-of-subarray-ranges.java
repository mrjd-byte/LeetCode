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

    private int[] findPge(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }
        return ans;
    }

    private int[] findNge(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) { //put = to handle the edge cases that is if duplicates
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;
            stack.push(i);
        }
        return ans;  
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] nse = findNse(nums);
        int[] pse = findPse(nums);
        long sumMin = 0;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            long freq = left * right;
            sumMin += freq * nums[i];
        }
        
        int[] nge = findNge(nums);
        int[] pge = findPge(nums);
        long sumMax = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            long freq = left * right;
            sumMax += freq * nums[i];
        }

        return sumMax - sumMin;
    }
}