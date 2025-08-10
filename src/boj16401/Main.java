package boj16401;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Main {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int result = binarySearch(arr, m);


        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int target){
        int left = 1;
        int right = 1000000000;
        while(left <= right){
            int middle = ((left+right) / 2);

            int can = 0;

            for(long num:arr){
                can += (int) (num / middle);
            }
            if(can < target){
                right = middle -1;
            }else{
                left = middle +1;
            }

        }

        return left -1 ;
    }
}
