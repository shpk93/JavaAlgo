package boj11779;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] edges = new int[m][3]; // [출발정점, 도착정점, 비용]

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i] = new int[]{Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken())};
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[][] result =  dijkstra(n,edges,start,end);

        System.out.println(result[0][end]);
        System.out.println(result[1].length);
        System.out.println(Arrays.stream(result[1])
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")));

    }

    public static int[][] dijkstra (int n, int[][] edges, int start, int end){
        int[] visited = new int[n+1];
        int[] pre = new int[n+1];
        List<Integer> path = new ArrayList<>();

        Arrays.fill(visited, Integer.MAX_VALUE);

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int sv = edge[0];
            int nv = edge[1];
            int w = edge[2];
            graph.get(sv).add(new int[]{w, nv});
        }

        // [비용, 다음정점]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        visited[start] = 0;
        pq.offer(new int[]{0, start});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int w = cur[0];
            int v = cur[1];

            if(visited[v] != w) continue;

            for(int[] edge: graph.get(v)){
                int nw = edge[0] + w;
                int nv = edge[1];

                if(visited[nv] <= nw) continue;

                pre[nv] = v;
                visited[nv] = nw;
                pq.add(new int[]{nw, nv});
            }
        }

        int tmp = end;
        while(tmp != start) {
            path.add(tmp);
            tmp = pre[tmp];
        }
        path.add(tmp);
        Collections.reverse(path);

        return new int[][]{visited, path.stream().mapToInt(Integer::valueOf).toArray()};
    }
}
