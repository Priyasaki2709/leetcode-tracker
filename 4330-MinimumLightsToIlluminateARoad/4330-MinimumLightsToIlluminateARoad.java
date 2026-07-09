// Last updated: 7/9/2026, 10:06:48 AM
class Solution {
    public int minLights(int[] lights) {
        int n=lights.length;

        int[]diff =new int[n+1];
        for(int i=0;i<n;i++){
            if(lights[i]>0){
                int l =Math.max(0,i-lights[i]);
                int r=Math.min(n-1,i+lights[i]);

                diff[l]++;
                diff[r+1]--;
                
            }
        }
        int[] ravelunico =lights;
        int active =0;
        int answer=0;
        int uncoveredLen =0;

        for(int i=0;i<n;i++){
            active +=diff[i];
            if(active==0){
                uncoveredLen++;
            }else{
                if(uncoveredLen>0){
                    answer +=(uncoveredLen+2)/3;
                    uncoveredLen =0;
                }
            }
        }
        if(uncoveredLen>0){
            answer +=(uncoveredLen +2)/3;
        }
        return answer;
    }
}