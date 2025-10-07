package boj1026;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
        int[] B = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::valueOf)
                .toArray();

        int result = 0;

        for (int i = 0; i < N; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);
    }
}
