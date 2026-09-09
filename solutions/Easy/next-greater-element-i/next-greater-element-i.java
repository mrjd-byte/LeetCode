class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> decreasingStack = new ArrayDeque<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!decreasingStack.isEmpty() && decreasingStack.peek() <= nums2[i]) {
                decreasingStack.pop();
            }
            if (decreasingStack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], decreasingStack.peek());
            }
            decreasingStack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}