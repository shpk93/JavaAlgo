package boj2178;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line2 = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line2.charAt(j)));
            }
        }

        System.out.println(bfs(0, 0, N - 1, M - 1, map));
    }

    static public int bfs(int sy, int sx, int ey, int ex, int[][] map) {
        int[] dy = new int[]{1, -1, 0, 0};
        int[] dx = new int[]{0, 0, -1, 1};

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[map.length][map[0].length];

        queue.offer(new int[]{sy, sx});
        visit[sy][sx] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if (map[ny][nx] == 0 || visit[ny][nx] > 0) continue;

                visit[ny][nx] = visit[now[0]][now[1]] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }


        return visit[ey][ex];
    }
}
