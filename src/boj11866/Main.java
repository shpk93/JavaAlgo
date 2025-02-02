package boj11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(solution());

    }

    private static String solution() {
        Queue<Integer> queue = new LinkedList<>();
        List<String> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i <= K && !queue.isEmpty(); i++) {
                int target = queue.poll();
                if (i == K) answer.add(String.valueOf(target));
                else queue.add(target);
            }
        }

        return "<" + String.join(", ", answer) + ">";
    }
}
