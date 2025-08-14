package boj2437;


import java.util.*;

class Main {
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] input = Arrays.stream(sc.nextLine()
                        .split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray();
        Arrays.sort(input);
        long target = 1;


        for (int num : input) {
            if (num > target) break;
            target += num;
        }

        System.out.println(target);
    }


}
