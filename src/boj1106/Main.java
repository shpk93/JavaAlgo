package boj1106;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int C = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);

        int[][] inputs = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            inputs[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        System.out.println(solution(C, inputs));
    }

    public static long solution(int C, int[][] inputs) {
        int[] maxValue = new int[102]; // 인풋 중 해당 비용으로 얻을 수 있는 최대 인원

        for (int[] input : inputs) {
            int price = input[0];
            int value = input[1];
            maxValue[price] = Math.max(maxValue[price], value);
        }

        long[] dp = new long[100 * 1000 + 5]; // 해당 비용으로 얻을 수 있는 최대 수

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 101; j++) {
                if (maxValue[j] != 0 && i + j < 100 * 1000 + 5) {
                    dp[i + j] = Math.max(dp[i + j], dp[i] + maxValue[j]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= C) return i;
        }

        return -1;
    }
}
