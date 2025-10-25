package boj1766;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegrees = new int[N + 1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            indegrees[B]++;
            graph.get(A).add(B);
        }
        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        StringBuilder out = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < indegrees.length; i++) {
            if (indegrees[i] == 0) pq.offer(i);
        }


        while (!pq.isEmpty()) {
            int cur = pq.poll();
            out.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        System.out.println(out);
    }
}
