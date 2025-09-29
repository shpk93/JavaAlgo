package boj2075;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (pq.size() < N) {
                    pq.offer(x);              // 아직 N개 안 찼으면 그냥 넣기
                } else if (x > pq.peek()) {   // N개 찼으면 루트(제일 작은 값)보다 클 때만 교체
                    pq.poll();
                    pq.offer(x);
                }
            }
        }

        int result = pq.poll();
        System.out.println(result);
    }
}
