package boj1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution());
    }

    private static String solution() {
        StringBuilder br = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.stream(arr).forEach(i -> {
            if (i == 0) {
                Integer target = pq.poll();
                if (target == null) target = 0;
                br.append(target).append('\n');
            } else {
                pq.add(i);
            }
        });

        return br.toString();
    }
}
