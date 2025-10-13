package boj13414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        String[] inputs = new String[M];
        for(int i=0;i<M;i++){
            inputs[i] = br.readLine().trim();
        }

        Set<String> set = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for(String input: inputs){
            set.remove(input);
            set.add(input);
        }
        int tmp = 0;

        for(String input: set){
            if (tmp == N) break;
            result.append(input).append("\n");
            tmp++;
        }
        System.out.println(result);
    }
}
