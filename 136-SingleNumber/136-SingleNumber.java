// Last updated: 7/9/2026, 10:07:25 AM
class Solution {
    public int singleNumber(int[] nums) {
        int result =0;
        for(int num:nums){
            result ^=num;
        }
        return result;
        
    }
}