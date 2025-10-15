package boj1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int X = Integer.parseInt(line[2]);

        int[][] edges = new int[M+1][3];

        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] edge = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            edges[i] = edge;
        }

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // 시작, 끝의 거리를 얻는 다익스트라 함수를 만들고
        // 정점 -> X 로 가는것 X -> 정점으로 가는값 min으로 쳐보자

        int result = 0;

        for(int i=1;i<=N;i++){
            result = Math.max(result, dijkstrea(i,X, graph) + dijkstrea(X,i,graph));
        }

        System.out.println(result);
    }

    public static int dijkstrea(int start, int end, List<List<int[]>> graph){
        if(start == end) return 0;
        // [정점 , 거리]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[1] - b[1];
        });
        pq.add(new int[]{start,0});
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int v = cur[0];
            int w = cur[1];

            if(dist[v] != w) continue;

            for(int[] edge: graph.get(v)){
                int nv = edge[0];
                int nw = edge[1] + w;

                if(nw >= dist[nv]) continue;

                dist[nv] = nw;
                if(nv == end) break;
                pq.add(new int[]{nv,nw});
            }
        }

        return dist[end];
    }
}
