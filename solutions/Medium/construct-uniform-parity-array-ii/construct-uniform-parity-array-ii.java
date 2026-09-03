class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        int oddCnt = 0;

        for (int num : nums1) {
            min = Math.min(num, min);
            if (num % 2 == 1) {
                oddCnt++;
            }  
        }

        return min % 2 != 0 || oddCnt == 0;
        
    }
}