class Solution {     
    private int[] findPse(int[] arr) {         
        Deque<Integer> stack = new ArrayDeque<>();         
        int[] ans = new int[arr.length];         
        for (int i = 0; i < arr.length; i++) {             
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {                 
                stack.pop();             
            }             
            ans[i] = !stack.isEmpty() ? stack.peek() : -1;             
            stack.push(i);         
        }         
        return ans;     
    }      

    private int[] findNse(int[] arr) {         
        Deque<Integer> stack = new ArrayDeque<>();         
        int[] ans = new int[arr.length];         
        Arrays.fill(ans, arr.length);          
        for (int i = arr.length - 1; i >= 0; i--) {             
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {                 
                stack.pop();             
            }             
            if (!stack.isEmpty()) {                 
                ans[i] = stack.peek();             
            }             
            stack.push(i);
        }         
        return ans;     
    }      

    public int largestRectangleArea(int[] heights) {         
        int[] nse = findNse(heights);         
        int[] pse = findPse(heights);         
        int maxArea = 0;         
        for (int i = 0; i < heights.length; i++) {             
            int area = heights[i] * (nse[i] - pse[i] - 1);             
            maxArea = Math.max(maxArea, area);         
        }         
        return maxArea;     
    } 
}