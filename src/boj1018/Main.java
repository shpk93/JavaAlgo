package boj1018;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        String[][] map = new String[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        System.out.println(solution(map));
    }

    public static int solution(String[][] map) {
        int result = 99999999;

        for (int y = 0; y <= N - 8; y++) {
            for (int x = 0; x <= M - 8; x++) {
                String[][] newMap = cut(y, x, map);

                int tmp = Math.min(getCount(newMap, false), getCount(newMap, true));
                result = Math.min(result, tmp);
            }
        }


        return result;
    }

    public static String[][] cut(int startY, int startX, String[][] map) {
        String[][] newMap = new String[8][8];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                newMap[y][x] = map[startY + y][startX + x];
            }
        }
        return newMap;
    }

    public static int getCount(String[][] map, Boolean bool) {
        int count = 0;
        String target1 = bool ? "W" : "B";
        String target2 = bool ? "B" : "W";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (!map[i][j].equals(target1)) count++;
                } else {
                    if (!map[i][j].equals(target2)) count++;
                }
            }
        }

        return count;
    }
}
