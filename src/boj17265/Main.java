package boj17265;

import java.io.*;
import java.util.*;
class Main {

    static int N;
    static String[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];

        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");

            for(int j=0;j<line.length;j++){
                map[i][j] = line[j];
            }
        }


        int[] result = go(map);


        System.out.print(result[0]);
        System.out.print(" ");
        System.out.print(result[1]);


    }

    public static int[] go(String[][] map){
        Queue<int[]> queue = new LinkedList<>();
        int[] dy = new int[]{-1,0};
        int[] dx = new int[]{0,1};

        int max = 0;
        int min = Integer.MAX_VALUE;


        // 0 = 숫자
        // 1 - +
        // 2 - -
        // 3 - *
        queue.add( new int[]{0,0, Integer.parseInt(map[0][0]), 0});

        while(!queue.isEmpty()){
            int[] data = queue.poll();

            int y = data[0];
            int x = data[1];
            int value = data[2];
            int yensanja = data[0];

            for(int i=0;i<dy.length;i++){

                int ny = y+ dy[i];
                int nx = x + dx[i];
                int nv = value;
                int nyen = 0;

                if (ny < 0 || nx < 0 || ny >= map.length || nx >= map.length) continue;

                if (map[ny][nx].equals("+")) {
                    nyen = 1;
                } else if (map[ny][nx].equals("-")) {
                    nyen = 2;
                } else if (map[ny][nx].equals("*")) {
                    nyen = 3;
                }

                if (yensanja == 1) {
                    nv += Integer.parseInt(map[ny][nx]);
                } else if (yensanja == 2) {
                    nv -= Integer.parseInt(map[ny][nx]);

                } else if (yensanja == 3) {
                    nv *= Integer.parseInt(map[ny][nx]);
                }

                if(ny == N-1 && nx == N-1){
                    max = Math.max(nv, max);
                    min = Math.min(nv, min);
                }

                queue.add(new int[]{ny, nx, nv, nyen});
            }
        }

        return new int[]{ max, min };
    }
}
