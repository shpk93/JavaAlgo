package boj6459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while(true){

            String line = br.readLine();
            if("0".equals(line)) break;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int[] inputs = new int[n];

            for(int i=0;i<n;i++){
                inputs[i] = Integer.parseInt(st.nextToken());
            }
            result.append(solution(inputs));
            result.append("\n");
        }
        System.out.println(result);
    }

    public static Long solution(int[] inputs){
        Deque<Integer> stack = new ArrayDeque<>();

        long result = 0L;
        for(int i=0;i<inputs.length;i++){
            int cur = inputs[i];

            while(!stack.isEmpty() && inputs[stack.peek()] >= cur){
                int prevIndex = stack.pop();
                long height = inputs[prevIndex];
                long width = stack.isEmpty() ? i :  i - stack.peek() -1;
                result = Math.max(result, width * height);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int prevIndex = stack.pop();
            long height = inputs[prevIndex];
            long width = stack.isEmpty() ? inputs.length :  inputs.length - stack.peek() -1;
            result = Math.max(result, width * height);
        }

        return result;
    }
}
