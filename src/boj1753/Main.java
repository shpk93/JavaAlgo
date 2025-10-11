package boj1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        int K = Integer.parseInt(br.readLine());
        int[][] edges = new int[E][3];

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] edge = new int[3];
            for(int j=0;j<3;j++){
                edge[j] = Integer.parseInt(st.nextToken());
            }
            edges[i] = edge;
        }

        int[] visited = dijkstra(V, K, edges);

        StringBuilder out = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            int w = visited[i];
            if (w == Integer.MAX_VALUE) {
                out.append("INF");
            } else out.append(w);
            out.append("\n");
        }

        System.out.println(out);
    }

    public static int[] dijkstra(int V, int K, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        // [정점][연결정점, 거리]

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
        }

        int[] visited = new int[V + 1];
        int inf = Integer.MAX_VALUE;
        Arrays.fill(visited, inf);


        // [현재정점, 거리]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        // visit에 시작정점 0 처리
        // pq 에 [시작정점, 0] 추가
        // pq가 빌때까지
        // 요소를빼고 visit[현재정점] 이랑 요소의 거리랑 같은지 체크
        // 아니면 스킵
        // 현재정점이랑 연결된 엣지 돌아서 visit배열 갱신

        visited[K] = 0;
        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cv = cur[0];
            int cw = cur[1];

            if (visited[cv] != cw) continue;

            for (int[] next : graph.get(cv)) {
                int nv = next[0];
                int nw = visited[cv] + next[1];

                if(visited[nv] <= nw) continue;

                visited[nv] = nw;
                pq.offer(new int[]{nv, nw});
            }
        }

        return visited;
    }
}
