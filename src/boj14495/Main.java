package boj14495;

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[118];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for(int i=5;i<=116;i++){
            dp[i] = dp[i-1] + dp[i-3];
        }

        // 116 까지 long으로 커버가능한듯 ;
        System.out.println(dp[n]);
    }
}
