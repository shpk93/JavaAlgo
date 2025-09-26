package boj13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i=0;i<T;i++){
            int K = Integer.parseInt(br.readLine());
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            result.append(solution(K, inputs));
            result.append("\n");
        }
        System.out.println(result);
    }

    private static long solution(int k, int[] inputs) {
        Queue<Long> pq = new PriorityQueue<>();
        long result = 0;
        for(int input:inputs){
            pq.offer((long) input);
        }
        while(pq.size() >= 2){
            long pop1 = pq.poll();
            long pop2 = pq.poll();

            result += pop1 + pop2;
            pq.offer(pop1+ pop2);
        }

        return result;
    }
}
