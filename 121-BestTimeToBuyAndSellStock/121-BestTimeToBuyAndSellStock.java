// Last updated: 7/9/2026, 10:07:26 AM
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxprofit =0;

        for(int price:prices){
            if(price<minPrice){
                minPrice =price;
            }else{
                maxprofit =Math.max(maxprofit,price - minPrice);
            }
        }
        return maxprofit;
        
    }
}