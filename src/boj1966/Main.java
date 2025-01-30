package boj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int T;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(solution(N, M, arr)).append('\n');
        }
        System.out.println(sb);
    }


    public static int solution(int N, int M, int[] arr) {
        class Pair {
            final int index;
            final int value;

            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }

        }
        int answer = 0;
        int[] o = new int[10];
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(new Pair(i, arr[i]));
            o[arr[i]]++;
        }

        while (!queue.isEmpty()) {
            Pair target = queue.poll();
            int count = 0;
            for (int i = target.value + 1; i < o.length; i++) {
                count += o[i];
            }
            if (count > 0) queue.add(target);
            else {
                o[target.value]--;
                answer++;
                if (target.index == M) return answer;
            }
        }

        return answer;
    }


}
