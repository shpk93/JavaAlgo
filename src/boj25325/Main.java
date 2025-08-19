package boj25325;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] people = br.readLine().split(" ");
        String[] inputs = new String[n];
        for(int i=0;i<n;i++){
            inputs[i] = br.readLine();
        }

        System.out.println(solution(inputs, people));
    }


    public static String solution(String[] inputs, String[] people){
        HashMap<String, HashSet<String>> peopleHash = new HashMap<>();
        StringBuilder result = new StringBuilder();


        for(String person: people){
            peopleHash.put(person, new HashSet<>());
        }
        for(int i=0;i <inputs.length;i++){
            String[] line = inputs[i].split(" ");
            String me = people[i];
            for (String like : line) {
                peopleHash.get(like).add(me);
            }
        }

        HashMap<String,Integer> countHash = new HashMap<>();

        peopleHash.forEach((key,value)->{
            countHash.put(key, value.size());
        });

        countHash.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    if(entry2.getValue() == entry1.getValue()){
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                    return entry2.getValue() - entry1.getValue();
                })
                .forEach(entry -> result.append(entry.getKey() + " " + entry.getValue()).append("\n"));



        return result.toString();
    }
}


