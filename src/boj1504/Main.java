package boj1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(a, b, c));
            graph.get(b).add(new Edge(b, a, c));
        }


        st = new StringTokenizer(br.readLine());

        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());


        long result1 = dijkstra(1, target1, graph);
        long result2 = dijkstra(target1, target2, graph);
        long result3 = dijkstra(target2, N, graph);

        long result4 = dijkstra(1, target2, graph);
        long result5 = dijkstra(target2, target1, graph);
        long result6 = dijkstra(target1, N, graph);


        if ((result1 == -1 || result2 == -1 || result3 == -1) && (result4 == -1 || result5 == -1 || result6 == -1)) {
            System.out.println(-1);
        } else {
            long tmp1 = (result1 + result2 + result3);
            long tmp2 = (result4 + result5 + result6);

            System.out.println(Math.min(tmp1, tmp2));
        }


    }

    private static long dijkstra(int start, int end, List<List<Edge>> graph) {
        long[] dist = new long[graph.size()];
        long inf = Long.MAX_VALUE;
        Arrays.fill(dist, inf);

        // [w, v]
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        pq.offer(new long[]{0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long w = cur[0];
            int v = (int) cur[1];

            if (dist[v] != w) continue;

            for (Edge edge : graph.get(v)) {
                int nv = edge.to;
                long nw = w + edge.w;

                if (dist[nv] > nw) {
                    dist[nv] = nw;
                    pq.offer(new long[]{nw, nv});
                }
            }
        }

        return dist[end] == inf ? -1 : dist[end];
    }

    static class Edge {
        int from;
        int to;
        int w;

        public Edge(int a, int b, int c) {
            this.from = a;
            this.to = b;
            this.w = c;
        }

        @Override
        public String toString() {
            return "to" + to + " W " + w;
        }
    }
}
