package boj2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int[][] visit = new int[N][N];

        List<Integer> houseList = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == 1 && visit[y][x] == 0) {
                    houseList.add(bfs(y, x, map, visit));
                }
            }
        }
        Collections.sort(houseList);

        String result = houseList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        System.out.println(houseList.size());
        System.out.println(result);
    }

    public static int bfs(int y, int x, int[][] map, int[][] visit) {
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{y, x});
        visit[y][x] = 1;
        int result = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map[0].length) continue;
                if (map[ny][nx] == 0) continue;
                if (visit[ny][nx] == 1) continue;

                result++;
                visit[ny][nx] = 1;
                queue.offer(new int[]{ny, nx});
            }

        }
        return result;
    }
}
