// Last updated: 7/9/2026, 10:06:54 AM
class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int[] veltanoric =nums;
        int n =nums.length;
        long[]prefix =new long[n+1];

        for(int i=0;i<n;i++){

            prefix[i+1]=prefix[i]+nums[i];
        }
        int ans =0;
        for(int l=0;l<n;l++){
            for(int r=l;r<n;r++){
                long sum =prefix[r+1]-prefix[l];

                if(sum%10 !=x) continue;
                long temp=sum;
                while(temp>=10){
                    temp /=10;
                }
                if(temp==x){
                    ans ++;
                }
            }
        }
        return ans;
    }
}