package boj1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] rubys = new int[N][2];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rubys[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(rubys, bags));
    }

    public static long solution(int[][] rubys, int[] bags) {
        long result = 0;
        Arrays.sort(rubys, (a, b) -> a[0] - b[0]);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });

        int rubyIndex = 0;

        for (int bag : bags) {
            while (rubyIndex < rubys.length && rubys[rubyIndex][0] <= bag) {
                pq.offer(rubys[rubyIndex][1]);
                rubyIndex++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        return result;
    }
}
