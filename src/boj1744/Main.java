package boj1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(inputs));
    }

    public static int solution(int[] inputs) {
        int result = 0;

        List<Integer> minusOrZero = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();

        for (int num : inputs) {
            if (num > 0) plus.add(num);
            else minusOrZero.add(num);
        }

        minusOrZero.sort((a, b) -> a - b);
        plus.sort((a, b) -> b - a);


        for (int i = 0; i < plus.size(); i++) {
            int cur = plus.get(i);
            Integer next = i == plus.size() - 1 ? null : plus.get(i + 1);

            if (next != null && (cur * next) > cur) {
                result += cur * next;
                i++;
            } else result += cur;
        }
        for (int i = 0; i < minusOrZero.size(); i++) {
            int cur = minusOrZero.get(i);
            Integer next = i == minusOrZero.size() - 1 ? null : minusOrZero.get(i + 1);

            if (next != null && (cur * next) > cur) {
                result += cur * next;
                i++;
            } else result += cur;
        }


        return result;
    }
}
