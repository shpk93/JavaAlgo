package boj11279;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] inputs;

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder result = new StringBuilder();
        for (int i : inputs) {
            if (i == 0) {
                if (!pq.isEmpty()) {
                    result.append(pq.poll()).append("\n");
                } else {
                    result.append(0).append("\n");
                }
            } else {
                pq.add(i);
            }
        }

        System.out.println(result);
    }
}
