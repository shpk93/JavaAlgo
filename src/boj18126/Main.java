package boj18126;


import java.io.*;
import java.util.*;

class Main {
    static long result = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];


        for(int i=0;i<N-1;i++){
            String[] line = br.readLine().split(" ");

            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            int C = Integer.parseInt(line[2]);

            graph[A][B] = C;
            graph[B][A] = C;
        }

        boolean[] visit = new boolean[N+1];
        visit[0] = true;

        dfs(1, visit, graph, 0);
        System.out.println(result);
    }


    public static void dfs(int n, boolean[] visit, int[][] graph, long value){
        visit[n] = true;
        result = Math.max(value, result);

        for(int i=1;i<graph[n].length;i++){
            if(!visit[i] && graph[n][i] >0){
                dfs(i, visit, graph, value + graph[n][i]);
            }
        }
    }

    public static long bfs(int n, boolean[] visit, int[][] graph){
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{n,0});
        visit[n] = true;

        long result = 0;
        while(!queue.isEmpty()){
            long[] line = queue.poll();
            int node = (int) line[0];
            long value = line[1];

            boolean leaf = true;

            for(int nextNode = 1; nextNode< graph[node].length;nextNode++){
                if(!visit[nextNode] && graph[node][nextNode] > 0) {
                    leaf = false;
                    queue.add(new long[] {nextNode, value + graph[node][nextNode]});
                    visit[nextNode] = true;
                }
            }
            if(leaf) result = Math.max(result, value);
        }
        return result;
    }
}
