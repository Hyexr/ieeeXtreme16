//40.3 points (44%)

import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;++i){
            int N = sc.nextInt();
            int[] weight = new int[N];
            for(int j=0;j<N;++j) weight[j] = sc.nextInt();
            List<Integer> adj[] = new ArrayList[N];
            for(int j=0;j<N;++j) adj[j] = new ArrayList<>();
            //建表
            for(int j=0;j<N-1;++j){
                int u = sc.nextInt()-1;
                int v = sc.nextInt()-1;
                adj[u].add(v);
                adj[v].add(u);
            }
            int Q = sc.nextInt();
            for(int j=0;j<Q;++j){
                // test
                int type = sc.nextInt();
                int u = sc.nextInt()-1;
                int v = sc.nextInt();
                if(type==1) weight[u] = v;
                else{
                    //路径乘积
                    System.out.println(BFS(adj, weight, u, v-1));
                }
            }
        }
    }
    static int BFS(List<Integer> adj[], int[] weight, int u, int v){
        boolean[] visited = new boolean[adj.length];
        int[] path = new int[adj.length];
        Deque<Integer> queue = new ArrayDeque<>();
        visited[u] = true;
        path[u] = weight[u];
        queue.offer(u);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int node2:adj[node]){
                if(!visited[node2]){
                    long dist = ((long) path[node] % 1000000007) * ((long) weight[node2] % 1000000007) % 1000000007;
                    path[node2] = (int) dist;
                    if(node2 == v) return path[node2];
                    visited[node2] = true;
                    queue.offer(node2);
                }
            }
        }
        return path[v];
    }
}
