package boj27971;

import java.util.*;
public class Main {

    public static void main(String[] arg) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();

       int A = sc.nextInt();
       int B = sc.nextInt();

       if (A>B){
           int tmp = A;
           A = B;
           B = tmp;
       }

       int[] dp = new int[N+1];
       boolean[] block = new boolean[N+1];
       Arrays.fill(dp, Integer.MAX_VALUE);
       dp[0] = 0;

       for(int i=0;i<M;i++){
           int L = sc.nextInt();
           int R = sc.nextInt();

           for(int j=L;j<=R;j++){
               block[j] = true;
           }
       }

       for(int i=0;i<=N;i++){
           if(i+A <=N && !block[i+A] && dp[i] != Integer.MAX_VALUE){
               dp[i+A] = Math.min(dp[i] + 1, dp[i+A]);
           }
           if(i+B <=N && !block[i+B] && dp[i] != Integer.MAX_VALUE){
               dp[i+B] = Math.min(dp[i] + 1, dp[i+B]);
           }
       }

       System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}