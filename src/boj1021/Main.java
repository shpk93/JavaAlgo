package boj1021;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int result = 0;
        int[] targets = new int[M];

        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }


        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }


        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int left;
            int right = 0;

            for (int el : deque) {
                if (el != target) {
                    right++;
                } else {
                    break;
                }
            }
            left = deque.size() - right;
            result += Math.min(left, right);

            while (deque.getFirst() != target) {
                deque.addLast(deque.pollFirst());
            }
            deque.pollFirst();

        }
        System.out.println(result);
    }
}
