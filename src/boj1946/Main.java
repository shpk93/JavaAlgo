package boj1946;

import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){

            int N = Integer.parseInt(br.readLine());
            List<int[]> inputs = new ArrayList<>();
            for(int j=0;j<N;j++){

                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                inputs.add(new int[]{a, b});
            }

            sb.append(solution(inputs)).append("\n");
        }

        System.out.println(sb);


    }

    public static int solution(List<int[]> inputs){
        int result = 0;

        inputs.sort((a, b) -> a[0] - b[0]);
        int min = 2000000;
        for(int i=0;i<inputs.size();i++){
            int target = inputs.get(i)[1];

            if(target < min){
                result ++;
                min = target;
            }
        }


        return result;
    }
}