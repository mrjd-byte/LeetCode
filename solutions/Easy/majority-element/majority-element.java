class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ans) {
                count++;
            } else {
                count--;
                if (count == 0){
                    count = 1;
                    ans = nums[i];
                }
            }
        }
        return ans;
    }
}