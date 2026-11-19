class Solution {
    public int trap(int[] height) {
        int leftHeightMax = height[0];
        int rightHeightMax = height[height.length - 1];
        int l = 0;
        int r = height.length - 1;
        int water = 0;
        if (height.length == 0)
            return 0;

        while (l < r) {
            if (leftHeightMax < rightHeightMax) {
                water += leftHeightMax - height[l];
                l++;
                leftHeightMax = Math.max(leftHeightMax, height[l]);
            } else {
                water += rightHeightMax - height[r];
                r--;
                rightHeightMax = Math.max(rightHeightMax, height[r]);
            }
        }
        return water;
    }
}