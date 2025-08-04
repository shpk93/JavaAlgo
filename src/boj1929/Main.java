package boj1929;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성하세요

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for(int i=N;i<=M;i++){
            if(isPrime(i)){
                arr.add(i);
            }
        }

        String result = arr.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("\n"));

        System.out.println(result);
    }
    public static boolean isPrime(int num){
        if(num ==1) return false;
        if(num ==2) return true;

        int end = (int) Math.sqrt(num) + 1;
        for(int i=2;i<=end;i++){
            if(num% i == 0) return false;
        }
        return true;
    }
}
