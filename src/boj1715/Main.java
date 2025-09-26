package boj1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        int[] inputs = new int[N];
        for(int i=0;i<N;i++){
            inputs[i] = Integer.parseInt(br.readLine());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : inputs) {
            pq.add(x);
        }

        while(pq.size() >= 2){
            int pop1 = pq.poll();
            int pop2 = pq.poll();

            result += pop1 + pop2;

            pq.add(pop1 + pop2);
        }

        System.out.println(result);
    }
}
