package boj2170;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] inputs = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            inputs[i][0] = Integer.parseInt(line[0]);
            inputs[i][1] = Integer.parseInt(line[1]);
        }

        System.out.println(solution(inputs));
    }

    public static int solution(int[][] inputs) {
        int result = 0;
        int start = -1000000000;
        int end = -1000000000;

        Arrays.sort(inputs, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        for (int[] input : inputs) {
            int ns = input[0];
            int ne = input[1];

            if (end < ns) {
                result += Math.abs(end - start);
                start = ns;
                end = ne;
            } else {
                end = Math.max(end, ne);
            }
        }

        result += Math.abs(end - start);

        return result;
    }
}
