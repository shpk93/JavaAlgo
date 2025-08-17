package boj10799;

import java.util.*;
public class Main {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String inputs = sc.nextLine();

        int stack = 0;
        int result = 0;

        for(int i=0;i<inputs.length()-1;i++){

            String target = String.valueOf(inputs.charAt(i));
            String target2 = String.valueOf(inputs.charAt(i+1));
            if(target.equals("(") && target2.equals(")")){
                result += stack;
                i++;
            }else if(target.equals("(")){
                stack++;
            }else{
                result +=1;
                stack--;
            }
        }

        result += stack; // 마지막 ) 계산

        System.out.println(result);
    }
}
