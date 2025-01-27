package boj1181;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static String[] arr;

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        System.out.println(String.join("\n", solution(arr)));
    }

    private static LinkedHashSet<String> solution(String[] arr) {
        Arrays.sort(arr, (a, b) -> {
            if (a.length() < b.length()) return -1;
            else if (a.length() > b.length()) return 1;
            else return a.compareTo(b);
        });

        return new LinkedHashSet<>(List.of(arr));
    }
}
