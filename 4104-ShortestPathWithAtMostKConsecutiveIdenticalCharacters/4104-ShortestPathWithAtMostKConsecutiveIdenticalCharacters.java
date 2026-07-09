// Last updated: 7/9/2026, 10:06:57 AM
class Solution {
    static class Edge{
        int to,wt;
        Edge(int to,int wt){
            this.to=to;
            this.wt=wt;
        }
    }
    static class State{
        int node,cnt;
        long dist;
        State(int node,int cnt,long dist){
            this.node=node;
            this.cnt=cnt;
            this.dist=dist;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int[][] movorqeli =edges;
        List<Edge>[]graph =new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] e: edges){
            graph[e[0]].add(new Edge(e[1],e[2]));
        }
        long INF =Long.MAX_VALUE/4;
        long[][] dist =new long[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],INF);
        }
        PriorityQueue<State>pq = new PriorityQueue<>((a,b)-> Long.compare(a.dist,b.dist));
        dist[0][1]=0;
        pq.offer(new State(0,1,0));

        while(!pq.isEmpty()){
            State cur =pq.poll();
            if(cur.dist !=dist[cur.node][cur.cnt]) continue;
            for(Edge e:graph[cur.node]){
                int nextCnt;
                if(labels.charAt(cur.node)==labels.charAt(e.to)){
                    nextCnt =cur.cnt+1;
                    
                }else{
                    nextCnt =1;
                }
                if(nextCnt >k)continue;
                long nd =cur.dist +e.wt;
                if(nd<dist[e.to][nextCnt]){
                    dist[e.to][nextCnt] =nd;
                    pq.offer(new State(e.to,nextCnt,nd));
                }
            }
        }
        long ans =INF;
            for(int c=1;c<=k;c++){
                ans =Math.min(ans,dist[n-1][c]);
            }
            return ans ==INF ? -1:(int) ans;
        
    }
}