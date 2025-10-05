package boj1931;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] inputs = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            inputs[i][0] = Integer.parseInt(line[0]);
            inputs[i][1] = Integer.parseInt(line[1]);
        }

        Arrays.sort(inputs, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int result = 0;
        int[] tmp = new int[2];
        for (int[] now : inputs) {
            if (tmp[1] <= now[0]) {
                tmp = now;
                result++;
            }
        }

        System.out.println(result);

    }
}
