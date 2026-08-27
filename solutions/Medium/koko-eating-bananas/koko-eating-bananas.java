class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int pile : piles) {
                sum += Math.ceil((double) pile / (double) mid);
            }
            if (sum <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}