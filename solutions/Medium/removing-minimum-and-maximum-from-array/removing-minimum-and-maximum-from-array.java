class Solution {
    public int minimumDeletions(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        int minInd = 0;
        int maxInd = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
                minInd = i;
            } 
            if(nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
        }
        int n = nums.length;
        int left = Math.min(minInd, maxInd);
        int right = Math.max(minInd, maxInd);

        int deleteFromLeft = right + 1;
        int deleteFromRight = n - left;
        int deleteFromBoth = (left + 1) + (n - right);

        return Math.min(deleteFromLeft, Math.min(deleteFromRight, deleteFromBoth));
    }
}