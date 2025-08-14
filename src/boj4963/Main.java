package boj4963;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        while(true) {
            String[] line = br.readLine().split( " ");
            if(line[0].equals("0") && line[1].equals("0")) break;


            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);


            int[][] map = new int[y][x];

            for(int i=0; i< y;i++){

                String[] line2 = br.readLine().split(" ");

                for(int j=0;j<x;j++){
                    try {
                        map[i][j] = Integer.parseInt(line2[j]);

                    } catch (Exception e) {
                        map[i][j] = 0;

                    }
                }
            }

            result.append(solution(map)).append("\n");
        }



        System.out.println(result);
    }

    public static int solution(int[][] map){
        int result = 0;

        int[][] visit = new int[map.length][map[0].length];

        for(int y=0;y<map.length;y++){
            for(int x=0;x<map[0].length;x++){
                if(map[y][x] == 1 && visit[y][x] == 0){
                    visit[y][x] = 1;
                    result += 1;
                    bfs(map, y,x, visit);
                }
            }
        }
        return result;
    }

    public static void bfs(int[][] map, int sy, int sx, int[][] visit){
        int[] dy = new int[]{0,0,1,-1,1,1,-1,-1};
        int[] dx = new int[]{1,-1,0,0,-1,1,-1,1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy,sx});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int y = tmp[0];
            int x = tmp[1];

            for(int i=0;i<dy.length;i++){
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny <0 || nx< 0 || ny>= map.length || nx>=map[0].length) continue;
                if(visit[ny][nx] == 1 ||  map[ny][nx] ==0) continue;

                visit[ny][nx] =1;
                queue.offer(new int[]{ny,nx});
            }
        }
    }
}
