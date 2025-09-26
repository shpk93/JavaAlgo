package boj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int N = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            if(Math.abs(a) == Math.abs(b)){
                return a-b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        for(int i=0;i<N;i++){
            int line = Integer.parseInt(br.readLine());
            if(line == 0){
                result.append(pq.isEmpty() ? 0 : pq.poll());
                result.append("\n");
            }else {
                pq.add(line);
            }
        }
        System.out.println(result);
    }
}
