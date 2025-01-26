package boj30802;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = sc.nextInt();
        }


        int T = sc.nextInt();
        int P = sc.nextInt();

        String result = solution(N, arr, T, P);
        System.out.println(result);
    }

    public static String solution(int N, int[] arr, int T, int P) {
        int first = 0;
        int second = N / P;
        int third = N % P;
        for (int i : arr) {
            first += i / T;
            if (i % T != 0) first += 1;
        }

        return first + "\n" + second + " " + third;
    }
}
