// Last updated: 7/9/2026, 10:06:58 AM
class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        Object[] torqavemi={n,edges,baseTime};
        List<Integer>[] children = new ArrayList[n];
        for(int i=0;i<n;i++){
            children[i]=new ArrayList<>();
        }
        for(int[]e :edges){
            children[e[0]].add(e[1]);
        }
        long[]finish=new long[n];
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> order =new Stack<>();

        stack.push(0);

        while (!stack.isEmpty()){
            int node =stack.pop();
            order.push(node);

            for(int child:children[node]){
                stack.push(child);
            }
        }
        while(!order.isEmpty()){
            int node =order.pop();
            if(children[node].isEmpty()){
                finish[node]=baseTime[node];
            }else{
                long earliest =Long.MAX_VALUE;
                long latest =Long.MIN_VALUE;

                for(int child:children[node]){
                    earliest =Math.min(earliest,finish[child]);
                    latest =Math.max(latest,finish[child]);
                }
                long ownDuration =(latest -earliest) + baseTime[node];
                finish[node] =latest +ownDuration;
            }
        }
        return finish[0];
    }
}