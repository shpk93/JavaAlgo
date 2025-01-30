package boj10814;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Member[] member;

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        member = new Member[N];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            member[i] = new Member(age, name);
        }
        Arrays.sort(member, Comparator.comparingInt(member -> member.age));

        for (int i = 0; i < N; i++) {
            sb.append(member[i].print()).append("\n");
        }
        System.out.println(sb);
    }

}

class Member {
    public String name;
    public int age;

    public Member(int age, String name) {
        this.name = name;
        this.age = age;
    }

    public String print() {
        return this.age + " " + this.name;
    }
}

