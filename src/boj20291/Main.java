package boj20291;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] inputs = new String[n];


        for(int i=0;i<n;i++){
            inputs[i] = br.readLine();
        }

        System.out.println(solution(inputs));

    }

    public static String solution(String[] inputs){
        Map<String,Integer> hash = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for(int i=0;i<inputs.length;i++){
            String exe = inputs[i].split("\\.")[1];
            hash.put(exe, hash.getOrDefault(exe, 0)+1);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(hash.entrySet());

        entries.sort((a,b)->{
            return a.getKey().compareTo(b.getKey());
        });

        entries.forEach(x ->{
            result.append(x.getKey()).append(" ").append(x.getValue());
            result.append("\n");
        });


        return result.toString();

    }

}
