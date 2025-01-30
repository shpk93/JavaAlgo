package boj18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static String solution() {
        // 값, 정답
        HashMap<Integer, Integer> hash = new HashMap<>();

        int answer = 0;
        int[] sorted = Arrays.stream(arr).sorted().toArray();

        for (int value : sorted) {
            if (!hash.containsKey(value)) {
                hash.put(value, answer);
                answer++;
            }
        }

        return Arrays.stream(arr)
                .map(hash::get)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}
