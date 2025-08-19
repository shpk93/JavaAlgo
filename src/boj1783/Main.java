package boj1783;


import java.util.*;

public class Main {

    public static void main(String[] arg) throws Exception{
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();


        System.out.println(solution(N,M));

    }

    public static int solution(int n, int m){
        if(n == 1 || m == 1){
            return 1;
        }
        if(n == 2){
            return Math.min(4, (m+1) /2);
        }if(n >= 3){
            if(m<7){
                return Math.min(4, m);
            }
            return m-2;
        }

        return -1;
    }
}


