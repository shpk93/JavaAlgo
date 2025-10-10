package boj2583;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int M = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);

        int[][] map = new int[M][N];

        for (int i = 0; i < K; i++) {
            line = br.readLine().split(" ");
            int sx = Integer.parseInt(line[0]);
            int sy = Integer.parseInt(line[1]);
            int ex = Integer.parseInt(line[2]);
            int ey = Integer.parseInt(line[3]);


            for (int y = sy; y < ey; y++) {
                for (int x = sx; x < ex; x++) {
                    map[y][x] = 1;
                }
            }
        }

        System.out.println(solution(map));
    }

    static String solution(int[][] map) {
        int count = 0;
        List<Integer> size = new ArrayList<>();

        int label = 2;

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == 0) {
                    size.add(bfs(map, y, x, label));
                    count++;
                    label++;
                }
            }
        }


        Collections.sort(size);
        StringBuilder result = new StringBuilder();

        result.append(count).append("\n");
        for (int s : size) {
            result.append(s).append(" ");
        }
        return result.toString();
    }

    static int bfs(int[][] map, int sy, int sx, int label) {
        int[] dy = new int[]{0, 0, -1, 1};
        int[] dx = new int[]{1, -1, 0, 0};

        int size = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sy, sx});
        map[sy][sx] = label;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if (map[ny][nx] != 0) continue;
                map[ny][nx] = label;
                queue.offer(new int[]{ny, nx});
            }
        }

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == label) {
                    size++;
                }
            }
        }

        return size;
    }
}
