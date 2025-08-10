package boj17271;


import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if(N == 0) {
            System.out.println(0);
            return;
        }
        if(N < M){
            System.out.println(1);
            return;
        }

        int[] dp = new int[N+1];

        for(int i=1;i<M;i++){
            dp[i] = 1;
        }
        dp[M] = dp[M-1] + 1;

        int mod = 1000000007;
        for(int i=M+1;i<=N;i++){
            dp[i] = (dp[i-1] + dp[i-M]) % mod;
        }

        System.out.println(dp[N]);

    }

}
