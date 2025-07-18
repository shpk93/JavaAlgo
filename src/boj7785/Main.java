package boj7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[][] logArray = new String[n][2];
        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            String[] line = br.readLine().split(" ");
            logArray[i] = line;
        }

        Arrays.stream(logArray).forEach(arr ->{
            String name = arr[0];
            String action = arr[1];

            if(action.equals("enter")){
                set.add(name);
            }else {
                set.remove(name);
            }
        });

        List<String> result = new ArrayList<>(set);
        result.sort(Collections.reverseOrder());


        System.out.println(String.join("\n", result));
    }

}
