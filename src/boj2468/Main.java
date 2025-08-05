package boj2468;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static int N;
    public static int[][] map;
    static class Path {
        int y;
        int x;

        public Path(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = 1;
        for(int i=0;i<N;i++){
            String[] line = br.readLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(line[j]);
                max = Math.max(max, map[i][j]);
            }
        }

        int result = 0;

        for(int num=0;num<max;num++){
            int[][] visit = new int[N][N];
            int count = 0;
            int[][] newMap = getNewMap(num, map);

            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(newMap[y][x] == 1 && visit[y][x] == 0){
                        count++;
                        bfs(newMap, y,x,visit);
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    public static int[][] getNewMap(int deep, int[][] map){
        int[][] newMap = new int[N][N];

        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(map[y][x] > deep){
                    newMap[y][x] =1;
                }
            }
        }

        return newMap;
   }

    public static void bfs(int[][] map, int startY, int startX, int[][] visit){
        int[] dy = {0,0,1,-1};
        int[] dx = {1,-1,0,0};

        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(startY,startX));
        visit[startY][startX] = 1;


        while(!queue.isEmpty()){
            Path path = queue.poll();
            for(int i=0;i<4;i++){

                int ny = path.y + dy[i];
                int nx = path.x + dx[i];

                if(ny<0 || nx<0 || ny>=N || nx >= N) continue;
                if(visit[ny][nx] == 0 && map[ny][nx] >0){
                    visit[ny][nx] = 1;
                    queue.add(new Path(ny,nx));
                }
            }
        }

    }
}
