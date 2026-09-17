class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if ( k == 0) {
            return 0;
        }
        if (k == cardPoints.length) {
            int sum = 0;
            for (int card :cardPoints) {
                sum += card;
            }
            return sum;
        }

        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;
        int rightIndex = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum += cardPoints[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}