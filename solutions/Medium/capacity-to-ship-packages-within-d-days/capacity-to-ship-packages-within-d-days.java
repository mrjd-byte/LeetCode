class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE;
        int right = 0; //sum of all weights

        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        // System.out.println(left);
        // System.out.println(right);
        while (left <= right) {
            int mid = (left + right) / 2;
            int nDays = 1;
            int weigh = 0;

            for (int i = 0; i < weights.length; i++) {
                if ((weights[i] + weigh) <= mid) {
                    weigh += weights[i];
                } else {
                    nDays++;
                    weigh = weights[i];
                }
            }

            if (nDays <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}