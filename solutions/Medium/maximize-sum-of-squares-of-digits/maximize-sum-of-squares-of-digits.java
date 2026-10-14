class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder("");
        if (sum > num * 9) {
            return "";
        }

        while (num > 0) {
            int digit = Math.min(9, sum);

            ans.append(digit);
            sum -= digit;
            num--;
        }
        if (sum > 0) {
            return "";
        }

        return ans.toString();
    }
}