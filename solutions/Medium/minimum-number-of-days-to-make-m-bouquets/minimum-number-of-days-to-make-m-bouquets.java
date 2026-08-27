class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int flower : bloomDay) {
            right = Math.max(flower, right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int bouquets = 0;
            int consecutive = 0;

            for (int i = 0; i < bloomDay.length; i++) {
                if (bloomDay[i] <= mid) {
                    consecutive++;
                    if (consecutive == k) {
                        bouquets++;
                        consecutive = 0;
                    }
                } else {
                    consecutive = 0;
                }
            }
            if (bouquets >= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}