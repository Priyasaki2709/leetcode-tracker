// Last updated: 7/12/2026, 8:47:57 AM
1class Solution {
2    public int secondsBetweenTimes(String startTime, String endTime) {
3        int start =toSeconds(startTime);
4        int end =toSeconds(endTime);
5        return end -start;
6        
7    }
8    private int toSeconds(String time){
9        String[]t=time.split(":");
10        int hours =Integer.parseInt(t[0]);
11        int minutes =Integer.parseInt(t[1]);
12        int seconds=Integer.parseInt(t[2]);
13        return hours *3600 +minutes *60 +seconds;
14    }
15}