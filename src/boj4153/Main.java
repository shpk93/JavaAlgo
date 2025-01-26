package boj4153;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<int[]> arr = new ArrayList<>();

        while(true){
            int[] abc = new int[3];
            for(int i=0;i<3;i++){
                abc[i] = sc.nextInt();
            }
            if(abc[0] == 0 && abc[1] == 0 && abc[2] == 0){
                break;
            }
            arr.add(abc);
        }

        arr.forEach(x-> System.out.println(solution(x)));
    }

    public static String solution(int[] arr){
        Arrays.sort(arr);
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if(a*a + b*b == c*c) {
            return "right";
        }
        return "wrong";
    }
}
