class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max=Integer.MIN_VALUE;
        for(int x:piles){
            max=Math.max(x,max);
        }

        int l=1;
        int r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            long totalHrs=func(piles,mid);
            if(totalHrs<=h){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    public long func(int[] piles, int mid){
        long total=0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/mid);
        }
        return total;
    }
}