package boj18258;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];

        for(int i=0;i<N;i++){
            inputs[i] = br.readLine();
        }

        System.out.println(solution(inputs));
    }

    public static String solution(String[] inputs){
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        Arrays.stream(inputs).forEach(tmp -> {
            String[] input = tmp.split(" ");
            tmp = input[0];
            if (tmp.equals("push")) {
                deque.offer(input[1]);
                return;
            } else if (tmp.equals("pop")) {
                String pop = deque.poll();
                if (pop == null) {
                    result.append(-1);
                } else {
                    result.append(pop);
                }
            } else if (tmp.equals("size")) {
                result.append(deque.size());
            } else if (tmp.equals("front")) {
                if (deque.isEmpty()) {
                    result.append(-1);
                } else {
                    result.append(deque.peek());
                }
            } else if (tmp.equals("back")) {
                if (deque.isEmpty()) {
                    result.append(-1);
                } else {
                   result.append(deque.getLast());
                }
            } else {
                if (deque.isEmpty()) {
                    result.append(1);
                } else {
                    result.append(0);
                }
            }
            result.append("\n");
        });


        return result.toString();
    }
}
