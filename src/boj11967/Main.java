package boj11967;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static Map<String, List<Edge>> graph = new HashMap<>();
    static Set<String> canVisit = new HashSet<>();
    static Set<String> visit = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                graph.put(y + "," + x, new ArrayList<>());
            }
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            String from = line[0] + "," + line[1];
            graph.get(from).add(new Edge(Integer.parseInt(line[2]), Integer.parseInt(line[3])));
        }

        // 그래프 그리기 끝

        // 1,1 에서 BFS 돌면서 불키기 시작
        // 시작시 불킨 갯수랑 BFS 끝났을 시점에 불킨 숫자랑 동일할때 까지 반복

        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};

        canVisit.add("1,1");
        for (Edge to : graph.getOrDefault("1,1", new ArrayList<>())) {
            canVisit.add(to.y + "," + to.x);
        }
        int start = canVisit.size();

        while(true) {
            Queue<String> queue = new ArrayDeque<>();
            queue.offer("1,1");
            visit = new HashSet<>();
            visit.add("1,1");

            while (!queue.isEmpty()) {
                String from = queue.poll();

                int sy = Integer.parseInt(from.split(",")[0]);
                int sx = Integer.parseInt(from.split(",")[1]);

                // 연결된 방 접근
                for (int i = 0; i < 4; i++) {
                    int ny = sy + dy[i];
                    int nx = sx + dx[i];

                    String next = ny + "," + nx;
                    if (ny < 1 || nx < 1 || ny >= N + 1 || nx >= N + 1) continue;
                    if (!canVisit.contains(next)) continue;
                    if (visit.contains(next)) continue;


                    // 불키고 방문처리
                    for (Edge to : graph.getOrDefault(next, new ArrayList<>())) {
                        canVisit.add(to.y + "," + to.x);
                    }
                    visit.add(next);
                    queue.add(next);
                }
            }

            if(start == canVisit.size()) break;
            start = canVisit.size();
        };


        System.out.println(canVisit.size());
    }


    static class Edge {
        int y;
        int x;

        public Edge(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
