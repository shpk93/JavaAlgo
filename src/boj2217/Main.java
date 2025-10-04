package boj2217;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(inputs));

    }

    public static int solution(int[] inputs) {
        int result = 0;
        Arrays.sort(inputs);

        // i는 밧줄을 사용할 갯수.
        // 정렬후 가장 큰 i개 밧줄 선택
        for (int i = 1; i <= inputs.length; i++) {
            result = Math.max(inputs[inputs.length - i] * i, result);
        }

        return result;
    }
}
