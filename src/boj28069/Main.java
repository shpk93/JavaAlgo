package boj28069;


import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        boolean result = false;

        Deque<int[]> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[N+1];

        queue.offer(new int[]{0,0});
        visit[0] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int pos = cur[0];
            int time = cur[1];

            if(time > K) continue;
            if(pos == N) {
                result = true;
                break;
            }

            int next1 = pos + 1;
            int next2 = pos + (pos /2);

            if(next1 <= N && !visit[next1]){
                visit[next1] = true;
                queue.offer(new int[]{next1, time+1});
            }
            if(next2 <= N && !visit[next2]){
                visit[next2] = true;
                queue.offer(new int[]{next2, time+1});
            }

        }

        System.out.println(result ? "minigimbob" : "water");
    }
}
