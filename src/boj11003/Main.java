package boj11003;

import java.util.*;
import java.util.stream.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int[] result = solution(N, L, inputs);

        StringBuilder sb = new StringBuilder();

        for(int a : result){
            sb.append(a).append(" ");
        }

        System.out.println(sb);
    }

    public static int[] solution(int N, int L, int[] inputs){
        Deque<int[]> deque = new ArrayDeque<>();
        // [인덱스,밸류]
        int[] result = new int[N];

        for(int i=0;i< inputs.length;i++) {
            int now = inputs[i];
            int min = now;

            // 먼저 들어간 애들 중 윈도우 사이즈에 안맞는애들제거
            while(!deque.isEmpty() && deque.getFirst()[0] <  i - L + 1){
                deque.pollFirst();
            }

            // 먼저들어간 애들 중 자기보다 큰 애들 제거
            while(!deque.isEmpty() && deque.getLast()[1] > min){
                deque.pollLast();
            }
            deque.addLast(new int[]{i, now});
            result[i] = deque.getFirst()[1];
        }
        return result;
    }
}
