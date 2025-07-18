package boj1620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] arg) throws Exception{
        int N;
        int M;
        List<String> monsters = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);

        for(int i=0;i<N;i++){
            String monster = br.readLine();
            monsters.add(monster);
            map.put(monster, i+1);
        }

        for(int i=0;i<M;i++){
            String input = br.readLine();
            if(input.matches("\\d+")){
                int numberInput = Integer.parseInt(input);
                sb.append(monsters.get(numberInput-1));
            }else{
                sb.append(map.get(input));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
