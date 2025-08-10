package boj9996;

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String pattern = sc.nextLine();


        for(int i=0;i<N;i++){
            if(go(pattern, sc.nextLine())){
                System.out.println("DA");
            }else {
                System.out.println("NE");
            }
        }


    }

    public static boolean go(String pattern, String target){
        String start = "";
        String end = "";

        int starIndex = pattern.indexOf('*');


        for(int i=0;i<starIndex;i++){
            start += pattern.charAt(i);
        }
        for(int i=starIndex +1; i<pattern.length(); i++){
            end += pattern.charAt(i);
        }

        if(target.length() < start.length() + end.length()) return false;

        String targetStart = target.substring(0,start.length());
        String targetEnd = target.substring(target.length() - end.length());

        return start.equals(targetStart) && end.equals((targetEnd));
    }
}
