class Solution {
    public boolean checkDivisibility(int n) {
        int x = n;
        int prod = 1;
        int sum = 0;

        while(x > 0){
            int rem = x % 10;
            prod *= rem;
            sum += rem;
            x /= 10;
        }

        if(n % (prod + sum) == 0) {
            return true;
        }
        return false;
    }
}