package boj1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = inputs[i];
            String target = maxPq.size() - minPq.size() == 0 ? "max" : "min";

            if (target.equals("max")) {
                if (!minPq.isEmpty() && minPq.peek() < num) {
                    maxPq.add(minPq.poll());
                    minPq.add(num);
                } else {
                    maxPq.add(num);
                }
            } else {
                if (maxPq.peek() > num) {
                    minPq.add(maxPq.poll());
                    maxPq.add(num);
                } else {
                    minPq.add(num);
                }
            }

            result.append(maxPq.peek()).append("\n");
        }

        System.out.println(result);
    }
}
