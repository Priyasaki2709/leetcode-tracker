// Last updated: 7/9/2026, 10:06:49 AM
class Solution {
    public int maxDistance(String moves) {
        int dx =0,dy=0,k=0;

        for(char ch:moves.toCharArray()){
            if(ch=='R') dx++;
            else if(ch =='L') dx--;
            else if(ch =='U') dy ++;
            else if(ch =='D') dy--;
            else k++;//'_'
        }
        return Math.abs(dx)+Math.abs(dy)+k;
    }
}