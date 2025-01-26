package boj2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        int result = 0;

        for (int i = 0; i <= 1000000; i++) {
            int tmp = i;
            int sum = i;
            while (tmp > 10) {
                sum += tmp % 10;
                tmp /= 10;
            }
            sum += tmp;
            if (N == sum) {
                result = i;
                break;
            }
        }

        return result;
    }
}
