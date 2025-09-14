package boj1725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] inputs = new long[N];
        for(int i=0;i<N;i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N,inputs));


    }
    public static long solution(int N,long[] inputs){
        long result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<inputs.length;i++){
            long el = inputs[i];
//            4 7 6 8 5 9 1 0
            while(!stack.isEmpty() && inputs[stack.peek()] >= el){
                int prevIndex = stack.pop();
                long height = inputs[prevIndex];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                result = Math.max(result, width * height);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int prevIndex = stack.pop();
            long height = inputs[prevIndex];
            long width = stack.isEmpty() ? N: N - 1 - stack.peek();
            result = Math.max(result, width * height);
        }

        return result;
    }
}
