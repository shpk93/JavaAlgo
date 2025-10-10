package boj2252;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] edges = new int[M][2];

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(line[0]);
            edges[i][1] = Integer.parseInt(line[1]);
        }

        String result = solution(N, M, edges);
        System.out.println(result);
    }

    public static String solution(int N, int M, int[][] edges) {
        StringBuilder result = new StringBuilder();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] edge = edges[i];
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            graph.get(from).add(to);
            indegrees[to]++;
        }

        // 그래프 그리고
        // 정점카운트세는 그래프도 그리고

        Queue<Integer> queue = new ArrayDeque<>();

        for (int v = 0; v < indegrees.length; v++) {
            int indegree = indegrees[v];
            if (indegree == 0) {
                queue.offer(v);
            }
        }

        // 큐가 빌때까지
        // 큐에서 빼낸 정점에 indegree가 없으면 result 에 푸시
        // 그래프에 연결된곳을 돌면서 indegree -- 하고 만약 0 이라면 큐에푸시

        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.append(v + 1).append(" ");

            for (int nv : graph.get(v)) {
                indegrees[nv]--;
                if (indegrees[nv] == 0) {
                    queue.offer(nv);
                }
            }
        }

        return result.toString();
    }
}
