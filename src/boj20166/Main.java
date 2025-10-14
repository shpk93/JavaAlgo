package boj20166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        String[][] map = new String[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(tmp.charAt(j));
            }
        }

        String[] inputs = new String[K];

        for (int i = 0; i < K; i++) {
            String tmp = br.readLine();
            inputs[i] = tmp;
        }


        System.out.println(solution(N,M,K,map, inputs));
    }

    public static String solution(int N, int M, int K, String[][] map, String[] inputs) {
        StringBuilder result = new StringBuilder();
        Map<String, Integer> hash = new HashMap<>();

        for (String input : inputs) {
            hash.put(input, 0);
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                go(y, x, map, hash);
            }
        }

        for (String input : inputs) {
            result.append(hash.get(input)).append("\n");
        }
        return result.toString();
    }

    public static void go(int sy, int sx, String[][] map, Map<String, Integer> hash) {
        int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};
        int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};

        Queue<El> queue = new ArrayDeque<>();
        queue.offer(new El(sy, sx, map[sy][sx]));
        if (hash.containsKey(map[sy][sx])) {
            hash.put(map[sy][sx], hash.get(map[sy][sx]) + 1);
        }

        while (!queue.isEmpty()) {
            El cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                if (cur.string.length() < 5) {
                    int ny = (cur.y + dy[i] + map.length) % map.length;
                    int nx = (cur.x + dx[i] + map[0].length) % map[0].length;
                    El next = new El(ny, nx, cur.string + map[ny][nx]);
                    if (hash.containsKey(next.string)) {
                        hash.put(next.string, hash.get(next.string) + 1);
                    }
                    queue.offer(next);
                }

            }
        }
    }

    static class El {
        int y;
        int x;
        String string = "";

        public El(int y, int x, String string) {
            this.y = y;
            this.x = x;
            this.string = string;
        }
    }
}
