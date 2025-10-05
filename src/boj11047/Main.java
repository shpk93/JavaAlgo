package boj11047;


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int[] inputs = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int money = K;
//
        for (int i = N - 1; i >= 0; i--) {
            if (money == 0) break;
            int coin = inputs[i];
            result += money / coin;
            money = money % coin;
        }

        System.out.println(result);

    }
}
