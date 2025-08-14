package boj30993;


import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();


        for (int i = 0; i < A; i++) {
            list.add("A");
        }
        for (int i = 0; i < B; i++) {
            list.add("B");
        }

        for (int i = 0; i < C; i++) {
            list.add("C");
        }


 // 1 1 2 3 6 7 30
        // 1
        // 1, 2




    }

    public static void backtracking(int target){


    }

}
