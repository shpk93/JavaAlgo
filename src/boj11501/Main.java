package boj11501;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            int[] inputs = new int[N];

            for (int j = 0; j < N; j++) {
                inputs[j] = Integer.parseInt(line[j]);
            }
            System.out.println(solution(inputs));
        }

    }

    public static long solution(int[] inputs) {
        long result = 0;
        int max = 0;

        for(int i= inputs.length-1; i>=0;i--){
            max = Math.max(inputs[i], max);
            result += max - inputs[i];
        }

        return result;
    }
}
